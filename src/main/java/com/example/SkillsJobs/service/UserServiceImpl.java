package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.*;
import com.example.SkillsJobs.entity.SkillEntity;
import com.example.SkillsJobs.entity.UserEntity;
import com.example.SkillsJobs.exception.InvalidBalanceException;
import com.example.SkillsJobs.exception.SkillNotFoundException;
import com.example.SkillsJobs.exception.UserNotFoundException;
import com.example.SkillsJobs.repository.SkillRepository;
import com.example.SkillsJobs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserSkillResponseDTO addSkillToUser(SkillRequestDTO requestDTO) {
        UserEntity user = userRepository.findById(requestDTO.userId())
                .orElseThrow(() ->
                        new UserNotFoundException("Пользователь с таким id " + requestDTO.userId() + " не найден"));

        for (String skillName: requestDTO.skill()){
            SkillEntity skill = skillRepository.findBySkill(skillName)
                    .orElseThrow(() ->
                            new SkillNotFoundException(requestDTO.skill() + " не найден."));
            user.addSkill(skill);
        }

        UserEntity saveUser = userRepository.save(user);

        return new UserSkillResponseDTO(
                saveUser.getSkills()
        );
    }

    @Override
    public Void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("Пользователь с таким id " + id + " не найден"));

        userRepository.delete(user);
        return null;
    }

    @Override
    public UserCreateResponseDTO updateUser(UserUpdateRequestDTO requestDTO) {
        UserEntity user = userRepository.findById(requestDTO.id())
                .orElseThrow(() ->
                        new UserNotFoundException("Пользователь с таким id " + requestDTO.id() + " не найден"));


        if (requestDTO.name() != null) {
            user.setName(requestDTO.name());
        }
        if (requestDTO.email() != null) {
            user.setEmail(requestDTO.email());
        }
        if (requestDTO.salary() != null) {
            user.setSalary(requestDTO.salary());
        }
        if (requestDTO.password() != null) {
            user.setPassword(passwordEncoder.encode(requestDTO.password()));
        }
        if (requestDTO.position() != null) {
            validateAndSetPosition(user, requestDTO.position());
        }

        UserEntity saveUser = userRepository.save(user);

        return new UserCreateResponseDTO(
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getSalary(),
                saveUser.getPosition()
        );
    }

    @Transactional
    @Override
    public UserTransferBalanceResponseDTO userTransfer(UserTransferBalanceRequestDTO requestDTO) {
        if (requestDTO.balance() <= 0 || requestDTO.balance() == null){
            throw new InvalidBalanceException("Баланс перевода отрицательный или пустой");
        }

        UserEntity user1 = userRepository.findById(requestDTO.userIdTransfer())
                .orElseThrow(() ->
                        new UserNotFoundException("Пользователь с таким id " + requestDTO.userIdTransfer() + " не найден"));

        UserEntity user2 = userRepository.findById(requestDTO.toUserId())
                .orElseThrow(() ->
                        new UserNotFoundException("Пользователь с таким id " + requestDTO.toUserId() + " не найден"));


        user1.setBalance(user1.getBalance() - requestDTO.balance());
        user2.setBalance(user2.getBalance() + requestDTO.balance());

        UserEntity saveFirstUser = userRepository.save(user1);
        UserEntity saveSecondUser = userRepository.save(user2);

        Map<Long, Integer> map = new HashMap<>();

        map.put(requestDTO.userIdTransfer(), user1.getBalance());
        map.put(requestDTO.toUserId(),user2.getBalance());

        return new UserTransferBalanceResponseDTO(map);
    }

    private void validateAndSetPosition(UserEntity user, String position) {
        Set<String> allowedPositions = Set.of("junior", "trainee", "middle", "senior", "team-lead", "ceo");

        if (!allowedPositions.contains(position)) {
            throw new RuntimeException("Некорректная должность: " + position);
        }

        user.setPosition(position);
    }

}

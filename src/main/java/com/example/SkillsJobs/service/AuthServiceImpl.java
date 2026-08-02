package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.UserCreateResponseDTO;
import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;
import com.example.SkillsJobs.entity.UserEntity;
import com.example.SkillsJobs.enums.Position;
import com.example.SkillsJobs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCreateResponseDTO createUser(UserRequestDTO requestDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(requestDTO.email());
        userEntity.setName(requestDTO.name());
        userEntity.setSalary(requestDTO.salary());

        String position = requestDTO.position();
        if (position != null && (position.equals("junior") || position.equals("trainee")
                || position.equals("middle") || position.equals("senior")
                || position.equals("team-lead") || position.equals("ceo"))) {
            userEntity.setPosition(position);
        } else {
            throw new RuntimeException("Некорректная должность");
        }

        userEntity.setPassword(passwordEncoder.encode(requestDTO.password()));

        UserEntity saveUser = userRepository.save(userEntity);

        return new UserCreateResponseDTO(
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getSalary(),
                saveUser.getPosition()
        );
    }

    @Override
    public UserResponseDTO getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();

        return new UserResponseDTO(
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getSalary(),
                userEntity.getPosition(),
                userEntity.getSkillList()
        );
    }
}

package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;
import com.example.SkillsJobs.entity.UserEntity;
import com.example.SkillsJobs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(requestDTO.email());
        userEntity.setName(requestDTO.name());
        userEntity.setPosition(requestDTO.position());
        userEntity.setSalary(requestDTO.salary());

        userEntity.setPassword(passwordEncoder.encode(requestDTO.password()));

        UserEntity saveUser = userRepository.save(userEntity);

        return new UserResponseDTO(
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
                userEntity.getPosition()
        );
    }
}

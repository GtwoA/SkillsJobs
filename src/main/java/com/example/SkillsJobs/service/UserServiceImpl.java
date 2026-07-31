package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.SkillRequestDTO;
import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;
import com.example.SkillsJobs.entity.SkillEntity;
import com.example.SkillsJobs.entity.UserEntity;
import com.example.SkillsJobs.repository.SkillRepository;
import com.example.SkillsJobs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    @Override
    public UserResponseDTO addSkill(SkillRequestDTO requestDTO) {
        UserEntity user = userRepository.findById(requestDTO.userId().getId())
                .orElseThrow(() -> new RuntimeException("Пользователь с таким id не найден"));

        UserEntity userEntity = new UserEntity();

//        for (String skill: requestDTO.skill()){
//            userEntity.
//        }
//
//        SkillEntity saveSkill = skillRepository.save(skillEntity);
        return null;
    }
}

package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.OnlySkillRequestDTO;
import com.example.SkillsJobs.dto.OnlySkillResponseDTO;
import com.example.SkillsJobs.dto.SkillRequestDTO;
import com.example.SkillsJobs.dto.SkillResponseDTO;
import com.example.SkillsJobs.entity.SkillEntity;
import com.example.SkillsJobs.entity.UserEntity;
import com.example.SkillsJobs.repository.SkillRepository;
import com.example.SkillsJobs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService{
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    public OnlySkillResponseDTO getAllSkillBySubstring(OnlySkillRequestDTO requestDTO) {
        Set<SkillEntity> skills = skillRepository.findSkillBySubstring(requestDTO.substring());

        Set<String> skillNames = skills.stream()
                .map(SkillEntity::getSkill)
                .collect(Collectors.toSet());

        return new OnlySkillResponseDTO(skillNames);
    }

}
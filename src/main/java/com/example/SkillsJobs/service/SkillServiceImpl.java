package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.SkillRequestDTO;
import com.example.SkillsJobs.dto.SkillResponseDTO;
import com.example.SkillsJobs.entity.SkillEntity;
import com.example.SkillsJobs.entity.UserEntity;
import com.example.SkillsJobs.repository.SkillRepository;
import com.example.SkillsJobs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService{
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

}
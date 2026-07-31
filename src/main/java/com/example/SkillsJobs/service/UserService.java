package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.SkillRequestDTO;
import com.example.SkillsJobs.dto.SkillResponseDTO;
import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO addSkill(SkillRequestDTO requestDTO);
}

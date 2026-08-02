package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.UserCreateResponseDTO;
import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;

public interface AuthService {
    UserCreateResponseDTO createUser(UserRequestDTO requestDTO);
    UserResponseDTO getUser(Long id);
}

package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO requestDTO);
    UserResponseDTO getUser(Long id);
}

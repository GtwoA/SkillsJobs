package com.example.SkillsJobs.dto;

import com.example.SkillsJobs.entity.UserEntity;

import java.util.Set;

public record SkillResponseDTO(
        Set<String> skill,
        UserEntity userId
) {
}

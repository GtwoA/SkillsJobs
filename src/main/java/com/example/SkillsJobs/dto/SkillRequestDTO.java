package com.example.SkillsJobs.dto;

import com.example.SkillsJobs.entity.UserEntity;

import java.util.Set;

public record SkillRequestDTO(
        Set<String> skill,
        UserEntity userId
) {
}

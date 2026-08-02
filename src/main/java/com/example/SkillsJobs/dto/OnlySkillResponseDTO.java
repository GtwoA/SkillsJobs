package com.example.SkillsJobs.dto;

import com.example.SkillsJobs.entity.SkillEntity;

import java.util.Set;

public record OnlySkillResponseDTO(
        Set<String> skillEntitySet
) {
}

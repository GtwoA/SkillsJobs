package com.example.SkillsJobs.dto;

import com.example.SkillsJobs.entity.SkillEntity;
import java.util.Set;

public record UserResponseDTO(
        String name,

        String email,

        Integer salary,

        String position,

        Set<SkillEntity> skill
) {
}

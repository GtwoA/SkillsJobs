package com.example.SkillsJobs.dto;

import jakarta.validation.constraints.Email;

public record UserUpdateRequestDTO(
        Long id,

        String name,

        @Email
        String email,

        String password,

        Integer salary,

        String position
) {
}

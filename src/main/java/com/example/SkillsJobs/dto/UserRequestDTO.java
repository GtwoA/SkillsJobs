package com.example.SkillsJobs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        String name,

        @Email
        String email,

        String password,

        Integer salary,

        String position
)
{}

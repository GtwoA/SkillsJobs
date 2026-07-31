package com.example.SkillsJobs.dto;

public record UserCreateResponseDTO(
        String name,

        String email,

        Integer salary,

        String position) {
}

package com.example.SkillsJobs.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseListDTO(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        List<String> errorList
) {
}

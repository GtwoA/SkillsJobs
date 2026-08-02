package com.example.SkillsJobs.dto;

import java.util.List;
import java.util.Set;

public record UserTransferBalanceRequestDTO(
        Set<Long> userId,
        Integer balance
) {
}

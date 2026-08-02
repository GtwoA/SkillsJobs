package com.example.SkillsJobs.dto;

import com.example.SkillsJobs.entity.UserEntity;

import java.util.List;
import java.util.Map;

public record UserTransferBalanceResponseDTO(
        Map<Long, Integer> userBalance
) {
}

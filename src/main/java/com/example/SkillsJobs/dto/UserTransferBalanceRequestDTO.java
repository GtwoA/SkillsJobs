package com.example.SkillsJobs.dto;

import java.util.List;
import java.util.Set;

public record UserTransferBalanceRequestDTO(
        Long userIdTransfer,
        Long toUserId,
        Integer balance
) {
}

package com.example.SkillsJobs.service;

import com.example.SkillsJobs.dto.*;

public interface UserService {
    UserSkillResponseDTO addSkillToUser(SkillRequestDTO requestDTO);
    Void deleteUser(Long id);
    UserCreateResponseDTO updateUser(UserUpdateRequestDTO requestDTO);
    UserTransferBalanceResponseDTO userTransfer(UserTransferBalanceRequestDTO requestDTO);

}

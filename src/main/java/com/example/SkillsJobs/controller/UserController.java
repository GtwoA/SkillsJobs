package com.example.SkillsJobs.controller;

import com.example.SkillsJobs.dto.*;
import com.example.SkillsJobs.service.AuthServiceImpl;
import com.example.SkillsJobs.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final AuthServiceImpl userServices;

    @PostMapping("/add")
    public ResponseEntity<UserSkillResponseDTO> addSkills(
            @RequestBody SkillRequestDTO request){
        return new ResponseEntity<>(userService.addSkillToUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(
            @Valid @PathVariable("id") Long id){
        return new ResponseEntity<>(userServices.getUser(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<UserCreateResponseDTO> updateUser(
            @RequestBody UserUpdateRequestDTO requestDTO){
        return new ResponseEntity<>(userService.updateUser(requestDTO), HttpStatus.OK);
    }

    @PatchMapping("/updateMoney")
    public ResponseEntity<UserTransferBalanceResponseDTO> updateBalanceUser(
            @RequestBody UserTransferBalanceRequestDTO requestDTO){
        return new ResponseEntity<>(userService.userTransfer(requestDTO), HttpStatus.OK);
    }
}

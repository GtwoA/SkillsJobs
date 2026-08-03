package com.example.SkillsJobs.controller;

import com.example.SkillsJobs.dto.UserCreateResponseDTO;
import com.example.SkillsJobs.dto.UserRequestDTO;
import com.example.SkillsJobs.dto.UserResponseDTO;
import com.example.SkillsJobs.service.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl userService;

    @PostMapping("/sing-up")
    public ResponseEntity<UserCreateResponseDTO> createUser(@Valid @RequestBody UserRequestDTO requestDTO){
        return new ResponseEntity<>(userService.createUser(requestDTO), HttpStatus.CREATED);
    }

}

package com.example.SkillsJobs.controller;

import com.example.SkillsJobs.dto.SkillRequestDTO;
import com.example.SkillsJobs.dto.SkillResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @PostMapping("/add")
    public ResponseEntity<List<SkillResponseDTO>> addSkills(@RequestBody SkillRequestDTO request){
        return null;
    }
}

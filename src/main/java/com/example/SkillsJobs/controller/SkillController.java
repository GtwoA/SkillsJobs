package com.example.SkillsJobs.controller;

import com.example.SkillsJobs.dto.OnlySkillRequestDTO;
import com.example.SkillsJobs.dto.OnlySkillResponseDTO;
import com.example.SkillsJobs.service.SkillServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillServiceImpl skillService;

    @GetMapping("/get")
    public ResponseEntity<OnlySkillResponseDTO> getAllSkill(@RequestParam String substring) {
        return new ResponseEntity<>(
                skillService.getAllSkillBySubstring(new OnlySkillRequestDTO(substring)),
                HttpStatus.OK
        );
    }

}

package com.example.SkillsJobs.exception;

import org.springframework.boot.web.error.Error;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import com.example.SkillsJobs.dto.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handle(UserNotFoundException ex) {

        ErrorResponseDTO response = new ErrorResponseDTO(
                LocalDateTime.now(),
                404,
                "Not Found",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(InvalidBalanceException.class)
    public ResponseEntity<ErrorResponseDTO> handler(InvalidBalanceException ex){

        ErrorResponseDTO responseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                400,
                "Bad Request",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseDTO);
    }

    @ExceptionHandler(SkillNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handler(SkillNotFoundException ex){

        ErrorResponseDTO responseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                404,
                "Not Found",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseDTO);
    }
}

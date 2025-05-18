package com.akiacevedo.life_line_back_end.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DayControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidCreatedDay() {
        return ResponseEntity.badRequest().body("Invalid arguments");
    }
}

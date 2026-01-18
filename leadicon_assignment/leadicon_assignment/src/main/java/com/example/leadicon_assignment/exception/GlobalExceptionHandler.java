package com.example.leadicon_assignment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuleEvaluationException.class)
    public ResponseEntity<String> handleRuleException(RuleEvaluationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

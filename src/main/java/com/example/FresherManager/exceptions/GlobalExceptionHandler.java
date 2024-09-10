package com.example.FresherManager.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FresherManagerException.class)
    public ResponseEntity<ErrorMessage> handleExceptionA(ErrorMessage e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return ResponseEntity.status(400).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        log.error("Have an exception: {}", e.getMessage());
        return ResponseEntity.status(500).body("Unknow error");
    }
}

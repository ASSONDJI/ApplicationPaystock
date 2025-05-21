package com.example.Category_Service.Exception;

import com.example.Category_Service.Model.ErrorEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
   public  class GlobalExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorEntity> cat(CategoryNotFoundException ex){
        LocalDateTime now = LocalDateTime.now();
        ErrorEntity error = new ErrorEntity(now, ex.getMessage(), "API", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error) ;
    }
}
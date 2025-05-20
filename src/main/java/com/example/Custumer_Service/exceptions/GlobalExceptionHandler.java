package com.example.Custumer_Service.exceptions;

import com.example.Custumer_Service.models.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustumerNotFoundException.class)
    public ResponseEntity<ErrorEntity> handleCustumerNotFound(CustumerNotFoundException exception) {
        ErrorEntity error = ErrorEntity.builder()
                .localDateTime(LocalDateTime.now())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}

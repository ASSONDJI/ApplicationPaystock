package com.example.Custumer_Service.exceptions;

import com.example.Custumer_Service.models.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, "Ressource introuvable", ex.getMessage());
    }

    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "L'identifiant fourni n'est pas valide : " + ex.getValue();
        return buildResponse(HttpStatus.BAD_REQUEST, "Type d'argument invalide", message);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + " : " + e.getDefaultMessage())
                .findFirst()
                .orElse("Champs invalides");
        return buildResponse(HttpStatus.BAD_REQUEST, "Erreur de validation", errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        String message = "Le client dont vous voulez modifier n'existe pas : " ;
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur interne", message);
    }
    private ResponseEntity<Object> buildResponse(HttpStatus status, String error, String message) {
        Map<String, Object> body = Map.of(
                "message", message
        );
        return new ResponseEntity<>(body, status);

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

package com.example.Category_Service.Model;

import jakarta.persistence.Transient;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public class ErrorEntity {
    private LocalDateTime localDateTime;

    private  String message;

    @Transient
    private  String errorAuthor;
    private int httpStatus;

    public ErrorEntity(LocalDateTime now, String message, String api, int value) {

    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorAuthor() {
        return errorAuthor;
    }

    public void setErrorAuthor(String errorAuthor) {
        this.errorAuthor = errorAuthor;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }



}

package com.example.Cart_Service.model;

import lombok.Builder;
import lombok.Data;

import java.beans.Transient;
import java.time.LocalDateTime;

public record ErrorEntity(
        LocalDateTime localDateTime,
                          String message,
                          @Transient
                          String errorAuthor,
                          int httpStatus){

    @Builder
    public static ErrorEntity of(LocalDateTime localDateTime, String message, String errorAuthor, int httpStatus) {
        return new ErrorEntity(localDateTime, message, errorAuthor, httpStatus);
    }

}

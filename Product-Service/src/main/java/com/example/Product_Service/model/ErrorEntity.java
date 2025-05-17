package com.example.Product_Service.model;

import lombok.Builder;

import java.beans.Transient;
import java.time.LocalDateTime;

@Builder
public record ErrorEntity(
        LocalDateTime localDateTime,
        String message,
        @Transient
        String errorAuthor,
        int httpStatus) {
}
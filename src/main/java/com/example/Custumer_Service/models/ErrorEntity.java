package com.example.Custumer_Service.models;

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

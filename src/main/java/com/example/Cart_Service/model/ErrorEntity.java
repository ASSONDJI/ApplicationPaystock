package com.example.Cart_Service.model;

import lombok.Builder;
import lombok.Data;

import java.beans.Transient;
import java.time.LocalDateTime;

@Builder
public record ErrorEntity(
        LocalDateTime localDateTime,
                          String message,
                          @Transient
                          String errorAuthor,
                          int httpStatus){

}

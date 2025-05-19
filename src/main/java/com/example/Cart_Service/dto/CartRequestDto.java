package com.example.Cart_Service.dto;

import java.util.Date;

public record CartRequestDto(
        int id_Customer,
        Date dateCreation
) {
}

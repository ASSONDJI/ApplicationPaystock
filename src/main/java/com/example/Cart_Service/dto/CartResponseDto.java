package com.example.Cart_Service.dto;

import java.util.Date;

public record CartResponseDto(
        int id_Cart,
        int id_Customer,
        Date dateCreation
) {
}

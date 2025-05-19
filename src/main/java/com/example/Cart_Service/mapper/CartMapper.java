package com.example.Cart_Service.mapper;

import com.example.Cart_Service.dto.CartRequestDto;
import com.example.Cart_Service.dto.CartResponseDto;
import com.example.Cart_Service.model.CartModel;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public CartModel toEntity (CartRequestDto dto){
        if (dto==null) return null;

        CartModel entity = new CartModel();
        entity.setId_Customer(dto.id_Customer());
        entity.setDateCreation(dto.dateCreation());
        return entity;
    }

    public CartResponseDto toDto(CartModel entity){
        if(entity==null)return null;

        return new CartResponseDto(
                entity.getId_Cart(),
                entity.getId_Customer(),
                entity.getDateCreation()
        );
    }

    }

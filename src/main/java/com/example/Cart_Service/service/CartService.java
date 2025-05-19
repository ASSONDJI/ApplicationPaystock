package com.example.Cart_Service.service;

import com.example.Cart_Service.dto.CartRequestDto;
import com.example.Cart_Service.dto.CartResponseDto;
import com.example.Cart_Service.model.CartModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    public CartResponseDto saveCart(CartRequestDto cartRequestDto);

    public List<CartResponseDto> getCart();

    public CartResponseDto updateCart(int id, CartRequestDto cartRequestDto);

    public Boolean deleteCart(int id);

}

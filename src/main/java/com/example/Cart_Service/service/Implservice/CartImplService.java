package com.example.Cart_Service.service.Implservice;

import com.example.Cart_Service.dto.CartRequestDto;
import com.example.Cart_Service.dto.CartResponseDto;
import com.example.Cart_Service.exception.CartNotFoundException;
import com.example.Cart_Service.mapper.CartMapper;
import com.example.Cart_Service.model.CartModel;
import com.example.Cart_Service.repository.CartRepository;
import com.example.Cart_Service.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartImplService implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartImplService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartResponseDto saveCart(CartRequestDto cartRequestDto) {
        try {
            CartModel entity =cartMapper.toEntity(cartRequestDto);
            CartModel saved = cartRepository.save(entity);
            return cartMapper.toDto(saved);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<CartResponseDto> getCart() {
        try {
        List<CartModel>carts =this.cartRepository.findAll();
        return carts.stream()
                .map(cartMapper::toDto)
                .toList();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CartResponseDto updateCart(int id, CartRequestDto cartRequestDto) {
        Optional<CartModel> foundCart=this.cartRepository.findById(id);
        if (foundCart.isPresent()){
            CartModel updateCart =cartMapper.toEntity(cartRequestDto);
            updateCart.setId_Cart(id);
            CartModel savedCart=cartRepository.save(updateCart);
            return cartMapper.toDto(savedCart);
        }
        throw new CartNotFoundException(id);
    }

    @Override
    public Boolean deleteCart(int id) {
        Optional<CartModel>foundCart=this.cartRepository.findById(id);
        if (foundCart.isPresent()){
            CartModel u =foundCart.get();
            this.cartRepository.delete(u);
            return true;
        }
        throw new CartNotFoundException(id);
    }
}

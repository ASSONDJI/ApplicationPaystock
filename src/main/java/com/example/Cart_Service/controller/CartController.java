package com.example.Cart_Service.controller;

import com.example.Cart_Service.dto.CartRequestDto;
import com.example.Cart_Service.dto.CartResponseDto;
import com.example.Cart_Service.exception.CartNotFoundException;
import com.example.Cart_Service.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/save")
    public ResponseEntity<CartResponseDto> saveCart(@RequestBody CartRequestDto cartRequestDto){
       CartResponseDto savedCart=cartService.saveCart(cartRequestDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    @GetMapping
    public ResponseEntity<List<CartResponseDto>> getCart() {
        List<CartResponseDto> carts =this.cartService.getCart();
        return ResponseEntity.ok(carts);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartResponseDto> updateCart(@PathVariable("id") int id,@RequestBody CartRequestDto cartRequestDto){
        try {
            CartResponseDto updateCart =cartService.updateCart(id,cartRequestDto);
            return ResponseEntity.ok(updateCart);
        }catch (CartNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCart(int id){
        Boolean foundDelete=this.cartService.deleteCart(id);
        if (foundDelete){
             ResponseEntity.status(HttpStatus.OK).body(foundDelete);
             return true;
        }
        return false;
    }
}

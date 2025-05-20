package com.example.Order_Service.controllers;

import com.example.Order_Service.dto.OrderDTO;
import com.example.Order_Service.mappers.OrderMapper;
import com.example.Order_Service.models.Order;
import com.example.Order_Service.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*") // Pour permettre les appels CORS (frontend)
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ✅ Obtenir toutes les commandes
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderDTO> dtos = orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // ✅ Obtenir une commande par ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(OrderMapper.toDTO(order));
    }

    // ✅ Créer une commande
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody @Valid OrderDTO dto) {
        Order order = OrderMapper.toEntity(dto); // ⬅️ conversion DTO ➜ Entity
        Order created = orderService.createOrder(order);
        return ResponseEntity.ok(OrderMapper.toDTO(created));
    }

    // ✅ Modifier une commande
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDTO dto) {
        Order order = OrderMapper.toEntity(dto); // ⬅️ conversion DTO ➜ Entity
        Order updated = orderService.updateOrder(id, order);
        return ResponseEntity.ok(OrderMapper.toDTO(updated));
    }

    // ✅ Supprimer une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

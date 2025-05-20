package com.example.Order_Service.services;

import com.example.Order_Service.models.OrderItem;
import org.springframework.stereotype.Service;
import com.example.Order_Service.repositories.OrderItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem saveItem(OrderItem item) {
        return orderItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}

package com.example.Order_Service.services;

import com.example.Order_Service.dto.OrderDTO;
import com.example.Order_Service.exceptions.OrderNotFoundException;
import com.example.Order_Service.mappers.OrderMapper;
import com.example.Order_Service.models.Order;
import com.example.Order_Service.models.OrderItem;
import com.example.Order_Service.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order createOrder(Order order) {
        calculateTotalPrice(order);
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order newOrder) {
        Order existingOrder = getOrderById(id);

        existingOrder.setClientName(newOrder.getClientName());
        existingOrder.setOrderDate(newOrder.getOrderDate());
        existingOrder.setStatus(newOrder.getStatus());

        // Mise à jour sécurisée des items
        existingOrder.getItems().clear();
        for (OrderItem item : newOrder.getItems()) {
            item.setOrder(existingOrder); // rattachement
            existingOrder.getItems().add(item);
        }

        calculateTotalPrice(existingOrder);
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }

    private void calculateTotalPrice(Order order) {
        double total = order.getItems().stream()
                .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                .sum();
        order.setTotalPrice(total);
    }
}

package com.example.Order_Service.mappers;

import com.example.Order_Service.dto.OrderDTO;
import com.example.Order_Service.dto.OrderItemResponseDTO;
import com.example.Order_Service.models.Order;
import com.example.Order_Service.models.OrderItem;

import java.util.List;
import java.util.stream.Collectors;
import com.example.Order_Service.dto.OrderItemDTO;


public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setClientName(order.getClientName());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setTotalPrice(order.getTotalPrice());

        List<OrderItemResponseDTO> itemDTOs = order.getItems().stream().map(item -> {
            OrderItemResponseDTO itemDTO = new OrderItemResponseDTO();
            itemDTO.setProductId(item.getProductId());
            itemDTO.setProductName(item.getProductName());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setUnitPrice(item.getUnitPrice());
            return itemDTO;
        }).collect(Collectors.toList());


        dto.setItems(itemDTOs);
        return dto;
    }

    public static Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setClientName(dto.getClientName());
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());

        List<OrderItem> items = dto.getItems().stream().map(itemDTO -> {
            OrderItem item = new OrderItem();
            item.setProductId(itemDTO.getProductId());
            item.setProductName(itemDTO.getProductName());
            item.setQuantity(itemDTO.getQuantity());
            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setOrder(order); // Rattachement de chaque item à la commande
            return item;
        }).collect(Collectors.toList());

        order.setItems(items);
        return order;
    }
}

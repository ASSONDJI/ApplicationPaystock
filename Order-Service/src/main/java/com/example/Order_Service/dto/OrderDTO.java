package com.example.Order_Service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.example.Order_Service.dto.OrderItemDTO;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {
        private Long id;

        @NotBlank(message = "Le nom du client est obligatoire")
        private String clientName;

        @NotNull(message = "La date de commande est obligatoire")
        private LocalDate orderDate;

        @NotBlank(message = "Le statut est obligatoire")
        private String status;

        private double totalPrice;

        @Valid
        @NotNull(message = "Les produits sont obligatoires")
        private List<OrderItemResponseDTO> items;  // ✅ Bien aligné avec le Mapper

        // Getters et Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getClientName() { return clientName; }
        public void setClientName(String clientName) { this.clientName = clientName; }

        public LocalDate getOrderDate() { return orderDate; }
        public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public double getTotalPrice() { return totalPrice; }
        public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

        public List<OrderItemResponseDTO> getItems() { return items; }
        public void setItems(List<OrderItemResponseDTO> items) { this.items = items; }

}

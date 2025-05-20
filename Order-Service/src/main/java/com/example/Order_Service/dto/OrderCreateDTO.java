package com.example.Order_Service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class OrderCreateDTO {
    @NotBlank(message = "Le nom du client est obligatoire")
    private String clientName;

    @NotNull(message = "La date est obligatoire")
    private LocalDate orderDate;

    @NotBlank(message = "Le statut est requis")
    private String status;

    @NotEmpty(message = "La commande doit contenir au moins un produit")
    private List<OrderItemCreateDTO> items;

    // Getters & Setters

    public String getClientName() {
        return clientName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItemCreateDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemCreateDTO> items) {
        this.items = items;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

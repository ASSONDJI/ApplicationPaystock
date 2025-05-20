package com.example.Order_Service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "productId ne doit pas être nul")
    private Long productId;

    @NotBlank(message = "productName est obligatoire")
    private String productName;

    @Min(value = 1, message = "La quantité doit être ≥ 1")
    private int quantity;

    @Min(value = 0, message = "Le prix unitaire doit être ≥ 0")
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id") // clé étrangère
    @JsonIgnore
    private Order order;

    // ✅ Getters et Setters
    public Long getId() { return id; }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getUnitPrice() { return unitPrice; }

    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }
}

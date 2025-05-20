package com.example.Order_Service.models;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du client est obligatoire")
    private String clientName;
    @NotNull(message = "La date de commande est obligatoire")
    private LocalDate orderDate;

    private double totalPrice;

    @NotBlank(message = "Le statut est requis")
    private String status; // EN_COURS, PAYÉ, ANNULÉ


    @Valid
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> items;


    public Order() {}

    public Order(String clientName, LocalDate orderDate, double totalPrice, String status) {
        this.clientName = clientName;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public LocalDate getOrderDate() { return orderDate; }

    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public List<OrderItem> getItems() { return items; }

    public void setItems(List<OrderItem> items) {
        this.items = new ArrayList<>();
        double total = 0.0;

        for (OrderItem item : items) {
            item.setOrder(this); // Rattache chaque item à la commande
            this.items.add(item);
            total += item.getUnitPrice() * item.getQuantity(); // Calcule le sous-total
        }

        this.totalPrice = total; // Affectation automatique du total
    }



}

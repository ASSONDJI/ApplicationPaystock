package com.example.Product_Service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="PRODUCT")



public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "PURCHASINGPRICE")
    private int purchasingprice;

    @Column(name = "UNITPRICE")
    private int unitPrice;

    @Column(name = "SELLINGPRICE")
    private int sellingPrice;

    @Column(name = "QUANTITY")
    private int quantity;

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPurchasingprice() {
        return purchasingprice;
    }

    public void setPurchasingprice(int purchasingprice) {
        this.purchasingprice = purchasingprice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package com.example.Product_Service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id_Product;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "PURCHASINGPRICE")
    private int purchasingprice;

    @Column(name = "UNITPRICE")
    private String unitPrice;

    @Column(name = "SELLINGPRICE")
    private String sellingPrice;

    @Column(name = "QUANTITY")
    private String quantity;

    public int getId_Product() {
        return id_Product;
    }

    public void setId_Product(int id_Product) {
        this.id_Product = id_Product;
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

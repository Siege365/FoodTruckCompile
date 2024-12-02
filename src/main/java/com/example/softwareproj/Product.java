package com.example.softwareproj;
public class Product {
    private String productName;
    private double price;
    private int stock;
    private String category;
    private String status;

    public Product(String productName, double price, int stock, String category, String status) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }
}

package com.example.softwareproj.CustomerSideRelated;

public class FoodItem {
    private String name;
    private double price;
    private int quantity;
    private String imagePath; // Path to the image

    // Constructor
    public FoodItem(String name, double price, int quantity, String imagePath) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public double getTotal() {
        return price * quantity;
    }
}

package com.example.softwareproj;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleIntegerProperty productId;
    private final SimpleStringProperty productName;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty stock;
    private final SimpleStringProperty category;
    private final SimpleStringProperty status;
    private final SimpleStringProperty imageUrl;

    public Product(int productId, String productName, double price, int stock, String category, String status, String imageUrl) {
        this.productId = new SimpleIntegerProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.category = new SimpleStringProperty(category);
        this.status = new SimpleStringProperty(status);
        this.imageUrl = new SimpleStringProperty(imageUrl);
    }

    public int getProductId() {
        return productId.get();
    }
    public String getProductName() {
        return productName.get();
    }

    public double getPrice() {
        return price.get();
    }

    public int getStock() {
        return stock.get();
    }

    public String getCategory() {
        return category.get();
    }
    public String getImageUrl() {
        return imageUrl.get();
    }
    public String getStatus() {
        return status.get();
    }
}

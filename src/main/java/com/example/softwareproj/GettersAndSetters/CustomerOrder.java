package com.example.softwareproj.GettersAndSetters;

public class CustomerOrder {
    private int orderID;
    private String customerName;
    private String customerNumber;
    private String customerAddress;
    private String customerOrderType;
    private String customerPaymentType;
    private String customerOrderDate;
    private int amountOfProducts;
    private String foodItems;
    private double subTotal;
    private double shippingCost;
    private double handlingFee;
    private int totalAmount;
    private String orderStatus;

    // Constructor
    public CustomerOrder(int orderID, String customerName, String customerNumber, String customerAddress,
                         String customerOrderType, String customerPaymentType, String customerOrderDate,
                         int amountOfProducts,String foodItems ,double subTotal,double shippingCost,double handlingFee,int totalAmount, String orderStatus) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.customerOrderType = customerOrderType;
        this.customerPaymentType = customerPaymentType;
        this.customerOrderDate = customerOrderDate;
        this.amountOfProducts = amountOfProducts;
        this.foodItems = foodItems;
        this.subTotal = subTotal;
        this.shippingCost = shippingCost;
        this.handlingFee = handlingFee;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerOrderType() {
        return customerOrderType;
    }

    public void setCustomerOrderType(String customerOrderType) {
        this.customerOrderType = customerOrderType;
    }

    public String getCustomerPaymentType() {
        return customerPaymentType;
    }

    public void setCustomerPaymentType(String customerPaymentType) {
        this.customerPaymentType = customerPaymentType;
    }

    public String getCustomerOrderDate() {
        return customerOrderDate;
    }

    public void setCustomerOrderDate(String customerOrderDate) {
        this.customerOrderDate = customerOrderDate;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(int amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderID=" + orderID +
                ", customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerOrderType='" + customerOrderType + '\'' +
                ", customerPaymentType='" + customerPaymentType + '\'' +
                ", customerOrderDate='" + customerOrderDate + '\'' +
                ", amountOfProducts=" + amountOfProducts +
                ", totalAmount=" + totalAmount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

}

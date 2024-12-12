package com.example.softwareproj.GettersAndSetters;

public class FeedBack {

    private int customerID; // Customer ID should be an int
    private String customerName;
    private String typeOfFeedback;
    private String titleOfConcern;
    private String feedbackDescription;

    // Constructor
    public FeedBack(int customerID, String customerName, String typeOfFeedback, String titleOfConcern, String feedbackDescription) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.typeOfFeedback = typeOfFeedback;
        this.titleOfConcern = titleOfConcern;
        this.feedbackDescription = feedbackDescription;
    }

    // Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTypeOfFeedback() {
        return typeOfFeedback;
    }

    public void setTypeOfFeedback(String typeOfFeedback) {
        this.typeOfFeedback = typeOfFeedback;
    }

    public String getTitleOfConcern() {
        return titleOfConcern;
    }

    public void setTitleOfConcern(String titleOfConcern) {
        this.titleOfConcern = titleOfConcern;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }
}

package com.example.borgerkongbyz5210273;

public class Food {

    private int foodID;
    private String foodName;
    private double foodPrice;
    private String foodSummary;
    private int imageDrawableId;
    private int quantity;

    public Food(int foodID, int imageDrawableId, String foodName, double foodPrice, String foodSummary, int quant) {
        this.foodID = foodID;
        this.imageDrawableId = imageDrawableId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodSummary = foodSummary;
        this.quantity = quant;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodSummary() {
        return this.foodSummary;
    }

    public void setFoodSummary(String foodSummary) {
        this.foodSummary = foodSummary;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quant) {
        this.quantity = quant;
    }


}

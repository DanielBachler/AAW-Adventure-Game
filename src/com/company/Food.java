package com.company;

public class Food extends Item {
    private double changeAmount;

    //Constructor
    public Food(String name, double amount) {
        this.changeAmount = amount;
        this.setName(name);
    }

    //changeAmount setter and getter
    public void setChangeAmount(double amount) {
        changeAmount = amount;
    }

    public double getChangeAmount() {
        return this.changeAmount;
    }
}

package com.company;

import java.util.ArrayList;

//The player class, stores information about the player
public class Player {
    //com.company.Player inventory
    public ArrayList<Item> inventory = new ArrayList<Item>();
    //Player name
    private String playerName;
    //Player current height (ft)
    private double playerHeight;


    //Getter and setter for name
    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }


    //Getter and setter for height
    public void setPlayerHeight(double input) {
        playerHeight = input;
    }

    public double getPlayerHeight() {
        return playerHeight;
    }

}

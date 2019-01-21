package com.company;
/**
 * Daniel Bachler
 * Choose your own adventure game for LIT-169 Assignment 1
 * A simple text based choose your own adventure game based roughly on the
 * original Alice in Wonderland novel by Lewis Carroll
 */

import java.util.Random;
import java.util.Scanner;

//Driving class, runs the game
public class Main {
    //The random for height generation and other features
    private static Random randy = new Random();
    //The scanner for user input
    private static Scanner userInput = new Scanner(System.in);
    //Array of food items available
    private static Food[] foodItems = {new Food("Muffin", 1), new Food( "Cupcake", -1),new Food( "Cake", 1), new Food("Soup", -1), new Food("Tea", 1), new Food("Mystery liquid", -1)};

    public static void main(String[] args) {
        //Creates player object
        Player player = new Player();
        //Intro and gets player name
        System.out.println("Welcome to the Alice in Wonderland choose your own adventure game!\nWhats your name?");
        String userName = userInput.nextLine();
        //Gets player height
        System.out.println("How tall are you? (ft) Ex. 6.3");
        float height = userInput.nextFloat();
        //Fixes control flow
        userInput.nextLine();
        //Assigns player height
        player.setPlayerHeight(height);
        //Starts game
        System.out.println("The game starts now " + userName + "!");
        //Assigns player name
        player.setPlayerName(userName);
        game(player);
    }

    //The game itself
    private static void game(Player p) {
        //Main branch
        System.out.println("You find yourself in a strange room, theres a table laden with various foods and drinks");
        //Option
        System.out.println("(1) Eat or drink something from the table\n(2) Take food or drink from the table");
        String choice1 = userInput.nextLine();
        //Branch one
        if(cleanInput(choice1) == 1) {
            System.out.println("You choose to consume an item off the table");
            Food temp = foodItems[randy.nextInt(foodItems.length-1)];
            System.out.println("You picked a " + temp.getName() + " off the table");
            changePlayerHeight(p, temp);
        } else if(cleanInput(choice1) == 2) {
            //Temporary new food
            Food temp;
            //Gets the food itself from master list
            temp = foodItems[randy.nextInt(foodItems.length-1)];
            //Tells player what they picked up
            System.out.printf("You pickup a %s and put it into your bag", temp.getName());
            //Adds item to player inventory
            p.inventory.add(temp);
        }
    }

    //Cleans the input to just an integer
    private static int cleanInput(String input) {
        if(input.contains("1")) {
            return 1;
        } else if(input.contains("2")) {
            return 2;
        } else {
            return 0;
        }
    }

    //Grows or shrinks the player
    private static void changePlayerHeight(Player p, Food selected) {
        //Changes with the given food item
        boolean grow = (selected.getChangeAmount() > 0);
        p.setPlayerHeight(p.getPlayerHeight() + selected.getChangeAmount());
        //Gets and displays new character height
        System.out.printf("Your character %s!\nYour new height is %.2f(ft)\n", (grow? "grew" : "shrunk"), p.getPlayerHeight());
    }
}

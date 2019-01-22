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
    private static Food[] foodItems = {new Food("Muffin", 1), new Food( "Cupcake", -10),new Food( "Cake", 5), new Food("Soup", -1), new Food("Tea", 1), new Food("Mystery liquid", -1)};

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
        //Old code from first prototype
        /*//Main branch
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
        }*/

        //Calling of chapter methods
        chapter1(p);
        chapter2(p);
        chapter3(p);
        chapter4(p);
        chapter5(p);
        chapter6(p);
        chapter7(p);
        chapter8(p);
        chapter9(p);
        chapter10(p);
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

    //Each chapter is its own method.  This is to keep the game method from becoming too cluttered.
    //Chapter 1 method
    private static void chapter1(Player p) {
        //1
        System.out.println("You are out playing in the woods and see a curious looking white rabbit go down a rabbit hole.\nDo you follow it?\n(1) Yes\n(2) No");
        //Gets the choice
        int choice = cleanInput(userInput.nextLine());
        //2
        if(choice == 1) {
            System.out.println("Your crawl down into the rabbit whole after the mysterious white rabbit");
        } else { //3
            System.out.println("You decide to leave the rabbit alone and continue on your way.  As you walk you look up into the trees to observe the singing birds.\n" +
                    "Not looking where your going you trip over a branch and fall into a rabbit whole!");
        }
        //4
        System.out.println("After you fall you find yourself in a strange room.\n(1) Sit and pout about your new situation\n(2) Get up and explore this new room");
        //Choice
        choice = cleanInput(userInput.nextLine());
        if(choice == 1) {
            boolean pouting = true;
            while(pouting) {
                System.out.println("You sit and pout while feeling bad about yourself\nContinue pouting?\n(1) Yes\n(2) No");
                choice = cleanInput(userInput.nextLine());
                if(choice == 2) {
                    pouting = false;
                }
            }
        }
        System.out.println("You begin to explore the room, and you find a table with many foods and a key on top");
        System.out.println("Do you grab the key (1) or eat some food (2)?");
        choice = cleanInput(userInput.nextLine());
        if(choice == 1){
            System.out.println("You grab the key off the table, and look around for where it belongs.\nThe food on the table seems to be calling to you though and you cannot help yourself" +
                    " you eat a slice of cake and feel a strange feeling all inside your person");
            p.inventory.add(new Key("Small Key"));
        } else {
            System.out.println("You eat a slice of cake and grap a cupcake to eat next.");
        }
        changePlayerHeight(p, foodItems[2]);
        System.out.println("Not fully understanding whats going on you begin to cry in frustration.\nThen you remember the cupcake and decide it cant hurt to eat it");
        changePlayerHeight(p, foodItems[1]);
        System.out.println("You have finished part 1");
    }

    //Chapter 2 method
    private static void chapter2(Player p) {

    }

    //Chapter 3 method
    private static void chapter3(Player p) {

    }

    //Chapter 4 method
    private static void chapter4(Player p) {

    }

    //Chapter 5 method
    private static void chapter5(Player p) {

    }

    //Chapter 6 method
    private static void chapter6(Player p) {

    }

    //Chapter 7 method
    private static void chapter7(Player p) {

    }

    //Chapter 8 method
    private static void chapter8(Player p) {

    }

    //Chapter 9 method
    private static void chapter9(Player p) {

    }

    //Chapter 10 method
    private static void chapter10(Player p) {

    }
}

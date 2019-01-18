package com.company;

import java.util.Scanner;

//Driving class, runs the game
public class Main {

    public static void main(String[] args) {
        //Creates player object
        Player player = new Player();
        //Intro and gets player name
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the Alice in Wonderland choose your own adventure game!\nWhats your name?");
        String userName = userInput.nextLine();
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

    }

    //Cleans the input to just an integer
    private static int cleanInput(String input) {

        //Place holder
        return 0;
    }
}

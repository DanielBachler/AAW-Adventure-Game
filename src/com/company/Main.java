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
        //1
        System.out.println("As you walk along you come across a house. You can see a tea party going on with a Hatter, a Hare, and a Dormouse. As you approach the table they begin shouting \"No room! No room\"");
        System.out.println("(1) Sit down anyway\n(2) Leave");

        int choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //2
            System.out.println("You ignore their cries and sit at the table anyway. They give you a side-glance but start to ignore you. Eventually, the Hatter suddenly asks \"How is a raven like a writing desk?\"");
            System.out.println("(1) \"I don't know\"\n(2) \"What kind of question is that?\"\n(3) Leave");

            choice = cleanInput(userInput.nextLine());

            if (choice ==1) {
                //3
                System.out.println("\"Well that's just as well\" responds the Hatter, \"as I don't know either! Would you like a cup of tea?\"");
            }else if (choice == 2) {
                //4
                System.out.println("\"It's a riddle I've heard that I can't quite figure out\" responds the Hatter, \"Would you like some tea?\"");
            } else if (choice == 3) {
                //12
                System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                return;
            }
            System.out.println("(1) Accept the tea\n(2) Decline the tea\n(3) Leave the tea party");

            choice = cleanInput(userInput.nextLine());

            if (choice == 1) {
                //6
                System.out.println("As the Hatter pours you a drink, he suddenly exclaims \"Oh! Do you know Time\"");
            } else if (choice == 2) {
                //5
                System.out.println("Quite ignoring you, the Hatter begins pouring tea into your teacup. As he does this, he suddenly exclaims \"Do you know Time?\"");
            } else if (choice == 3) {
                //12
                System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                return;
            }
            System.out.println("(1) \"I have no idea what time it is\"\n(2) \"I would assume it's tea time\"\n(3) Leave the tea party");

            choice = cleanInput(userInput.nextLine());

            if (choice == 1) {
                //7
                System.out.println("\"I'll say you don't!\" exclaims the Hatter, \"Otherwise you'd know Time is a \"he\" and not an \"it.\"\nHe and I got into an argument once, and now he's frozen time for me so that now it's always tea time!\"");
            } else if (choice == 2) {
                //8
                System.out.println("\"Well of course it's tea time, it's always tea time!\" cries the Hatter, \"Ever since I argued with Time himself he's frozen time for me right now at tea time!\"");
            } else if (choice == 3) {
                //12
                System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                return;
            }
            System.out.println("(1) \"I'd say that's quite ridiculous\"\n(2) \"Oh, how unfortunate!\"\n(3) Leave the tea party");

            choice = cleanInput(userInput.nextLine());

            if (choice == 1) {
                //13
                System.out.println("\"Well,\" scoffs the Hatter, \"I should say it's quite rude to barge in on people's tea parties and then disagree with them. Be off with you at once\"\nYou decide it best not to argue, so you leave the tea party, and continue on your way");
                return;
            } else if (choice == 2) {
                //9
                System.out.println("\"Unfortunate indeed\" says the Hatter, \"Now, how about a story from our esteemed Dormouse?\"\nWith that, the Dormouse begins a story, a long one with many pompous airs, but interesting nonetheless");
            } else if (choice == 3) {
                //12
                System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                return;
            }
            System.out.println("(1) Tell the Dormouse about your amazing cat\n(2) Keep listening to the story\n(3) Leave this ridiculous situation");

            choice = cleanInput(userInput.nextLine());

            if (choice == 1) {
                //14
                System.out.println("At the mention of the word \"cat\" the Dormouse begins to squeak and thrash wildly. The Hatter and the Hare begin frantically trying to calm him as plates and dishes crash all around. You decide it best to be on your way, so you leave the table and start walking");
                return;
            } else if (choice == 2) {
                //10
                System.out.println("The Dormouse finishes his story with a flourish and begins to doze off. The Hatter and the Hare start chattering together as they continue drinking their tea. The Hare offers you another cup as well");
            } else if (choice == 3) {
                //12
                System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                return;
            }
            System.out.println("(1) Accept the tea\n(2) Thank them and leave\n(3) Just leave");

            choice = cleanInput(userInput.nextLine());

            if (choice == 1) {
                //11
                do {
                    System.out.println("The Hare pours you a glass, then resumes chatting with the Hatter. Eventually you empty you cup and the Hare offers you another");
                    System.out.println("(1) Accept the tea\n(2) Thank them and leave\n(3) Just leave");

                    choice = cleanInput(userInput.nextLine());

                    if (choice == 3) {
                        //12
                        System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                        return;
                    }
                } while (choice == 1);
            } else if (choice == 3) {
                //12
                System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");
                return;
            }

            //15
            System.out.println("You thank the Hatter, Hare, and the sleeping Dormouse for allowing your company, then continue on your way");
            return;
        }

        //12
        System.out.println("You decide that this tea party seems quite ridiculous and is not at all a place you'd like to remain. So you leave the area and continue walking");

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

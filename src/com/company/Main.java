package com.company;
/**
 * Daniel Bachler and Jase Rost
 * Choose your own adventure game for LIT-169 Assignment 1
 * A simple text based choose your own adventure game based roughly on the
 * original Alice in Wonderland novel by Lewis Carroll
 */

import java.util.Scanner;

//Driving class, runs the game
public class Main {
    //The scanner for user input
    private static Scanner userInput = new Scanner(System.in);
    //Array of food items available
    private static Food[] foodItems = {new Food("Muffin", 1), new Food( "Cupcake", -10),new Food( "Cake", 5), new Food("Soup", -1), new Food("Tea", 1), new Food("Mystery liquid", 20)};

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
        } else if(input.contains("3")){
            return 3;
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
        //1
        System.out.println("You awaken to find yourself on a small island in what seems to be a large lake.\n" +
                "Tha last thing you remember is being quite upset and passing out while crying.\n" +
                "You see a distant shore with come creatures upon it and begin swimming towards them\n" +
                "As you approach you must decide how you want to handle these creatures\n" +
                "(1) Ask them for help drying off\n" +
                "(2) WHY ARE THESE ANIMALS SPEAKING ENGLISH");
        int choice = cleanInput(userInput.nextLine());
        if(choice == 1) { //Choice 1 p1, goto 2
            System.out.println("You ask the animals for some help drying yourself off.");
        } else { //Choice 1, p2, goto 3
            System.out.println("The animals seem to ignore you shouting at them.  You yell \"Why are you ignoring me!\"");
        }
        //3
        System.out.println("A mouse who seems to be the leader of the little group yell out loudly\n" +
                "\"How about we have a caucus race?\"\n" +
                ((choice == 1)? "It will help you dry off the mouse says to you\n" : "") +
                "Do you decide to: \nJoin in their race (1)\nSit out by yourself? (2)");
        choice = cleanInput(userInput.nextLine());
        if(choice == 1){ //choice #2 p1, goto 5
            //5
            System.out.println("You join the caucus race, as you sprint around without a destination like the other animals you feel yourself begin to dry off from the wind.");
        } else { //choice #2 p2, goto 4
            //4
            System.out.println("You sit off to the side cold and wet as the animals run around the area seemingly having the time of their lives");
        }
        //Prize demand from 4 and 5
        System.out.println("After the race ends the animals surround you and begin to demand a prize for their efforts.\n" +
                "Do you:\n(1) Give them some sweets you have in your pockets?\n(2) Or do you refuse to give them anything because the whole situation is ridiculous");
        choice = cleanInput(userInput.nextLine());
        int choiceExtend;
        if(choice == 1) { //Choice 3 p1, goto 7
            System.out.println("You give into the animals demands and pull enough candy from your pocket that each creature present gets one piece");
            choiceExtend = 1;
        } else { //Choice 3 p2, goto 6
            System.out.println("You refuse to give the animals a prize because it is a ridiculous situation\n" +
                    "This causes the animals to begin loudly complaining, demanding that you give them a prize.\n" + //6
                    "Do you:\n" +
                    "(1) Give in?\n" +
                    "(2) Stand firm");
            choice = cleanInput(userInput.nextLine());
            if(choice == 1) {//Choice 4 p1, goto 7
                System.out.println("You decide to give into the animals demands, and give them some sweets from your pockets");
                choiceExtend = 1;
            } else {//Choice 4 p2, goto 8
                System.out.println("You stand firm in your decision to not give into the animals.");
                choiceExtend = 2;
            }
        }
        if(choiceExtend == 1) { //7
            System.out.println("You listen as the animals begin telling stories about their lives and other things\n" +
                    "Do you:\n(1) Mention your pet cat?\n(2) Listen quietly");
            choice = cleanInput(userInput.nextLine());
            if(choice == 1) { //Choice 5 p1, goto 9
                System.out.println("The animals become angry with you and depart in various directions");
            } else { //Choice 5 p2, goto 10
                System.out.println("The animals finish their stories and begin to disperse to their various homes");
            }
        } else { //8
            System.out.println("The animals are upset with you and depart in various directions");
        }
        System.out.println("Part 2 complete");
    }

    //Chapter 4 method
    private static void chapter4(Player p) {
        //1
        System.out.println("You are walking along and see the white rabbit again.  He approaches you and says \n" +
                "\"Greetings again " + p.getPlayerName() + " could you go retrieve some things for the duchess?\"\n" +
                "(1) Agree to go get the items\n(2) Refuse to get the items");
        int choice = cleanInput(userInput.nextLine());
        if(choice == 1) { //2
            System.out.println("You walk to the rabbit's house to retrieve the items he asked for.\n" +
                    "Along with the items you see a small bottle containing a fluid you don't recognize.\n" +
                    "Do you: \n" +
                    "(1) Just grab the items?\n(2) Drink the mystery fluid?\n");
            choice = cleanInput(userInput.nextLine());
            if(choice == 1) {
                //Grab items and add to inv, chapter ends
                System.out.println("You pickup the stuff for the duchess only and leave the house to find the rabbit.");
                Item duchessStuff = new Item();
                duchessStuff.setName("The Duchess's Items");
                p.inventory.add(duchessStuff);
            } else if(choice == 2){
                //3
                System.out.println("You pickup and drink the mystery fluid.");
                changePlayerHeight(p, foodItems[5]);
                System.out.println("You begin to panic due to your new massive size, from outside you hear\n" +
                        "\"Hey, Billy!  Why don't ya go down the chimney to see whats going on inside.\"\n" +
                        "Do you want to:\n(1) Kick Billy as he comes down?\n(2) Let Billy come in.\n");
                choice = cleanInput(userInput.nextLine());
                if(choice == 1) {
                    //5
                    System.out.println("You decide to kick Billy as he comes down the chimney.\n" +
                            "Billy is launched out of the chimney and the animals outside get angry with you.\n" +
                            "They begin to pelt you with stones that for some reason shrink you back to your normal height.");
                    p.setPlayerHeight(p.getPlayerHeight() - foodItems[5].getChangeAmount());
                } else if(choice == 2){
                    //4
                    System.out.println("Billy arrives in the room, he runs to the kitchen to get a slice of shrinking cake.\n" +
                            "He gives you the cake and you shrink back to your normal height.");
                    p.setPlayerHeight(p.getPlayerHeight() - foodItems[5].getChangeAmount());
                }
            }
        } else {
            //Refusal, ends chapter
            System.out.println("You refuse the rabbit's demands and move on.");
        }
        System.out.println("End of part 3");
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

        //1
        System.out.println("You keep walking until you come to a garden where strange men who look like playing cards are painting white roses on a rose bush red");

        System.out.println("(1) Leave them to it\n(2) Ask them what they're doing");

        int choice = cleanInput(userInput.nextLine());

        if (choice == 2) {
            //2
            System.out.println("\"It's awful Miss!\" cries one of the gardeners. \"We was supposed to plant red roses for the Queen, but it turns out we planted white! If the queen finds out, she'll have our heads!\"");
            System.out.println("Suddenly, the you hear trumpets sounding nearby, and a procession approaches, with a King and Queen clearly visible at the center.");
            System.out.println("The gardeners begin scrambling, but as the Queen approaches she looks down at them, \"I see what's going on here. Off with their heads!\"");
            System.out.println("As the gardeners begin to cry, she turns to you and looks you over. \"Do you play croquet?\" she asks");
        } else if (choice == 2) {
            //3
            System.out.println("The gardeners continue painting furiously. Suddenly, the you hear trumpets sounding nearby, and a procession approaches, with a King and Queen clearly visible at the center.");
            System.out.println("The gardeners begin scrambling, but as the Queen approaches she looks down at them, \"I see what's going on here. Off with their heads!\"");
            System.out.println("As the gardeners begin to cry, she turns to you and looks you over. \"Do you play croquet?\" she asks");
        }
        System.out.println("(1) Yes ma'am, I do\n(2) And what business is that of yours?\"");

        choice = cleanInput(userInput.nextLine());

        if (choice == 2) {
            //4
            System.out.println("The Queen's face turns the deepest shade of red you've ever seen. \"Off with her head!\" she cries, shaking her fists wildly in the air");
            System.out.println("The King puts a hand on her shoulder \"She's just a child,\" he tells her.");
            System.out.println("\"Very well,\" the Queen says as she begins to calm down. She turns back to you, \"I will forgive this one transgression, but you will now play croquet with us or it really will be off with you head!\"");
            System.out.println("As you begin to fall in line with the procession, the gardeners whisper to you, \"Please, you have to help us, or we'll lose our heads!\"");
        } else if (choice == 1) {
            //5
            System.out.println("The Queen looks pleased. \"Very good, then you shall join us in our game. Come now, or it will be off with your head!\" she cries");
            System.out.println("As you begin to fall in line with the procession, the gardeners whisper to you, \"Please, you have to help us, or we'll lose our heads!\"");
        }
        System.out.println("(1) Let them deal with their own problems\n(2) Help them hide");

        choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //6
            System.out.println("You inform the gardeners that it would not be in your best interests to go against the Queen's will. As you walk off with the procession, you glimpse the gardeners being led off by the guards");
            System.out.println("As you get to the croquet grounds, you find that the game really is quite mad. As you use a croquet that is a flamingo to hit a ball that is a hedgehog, though an arch that his a bent over card-man, you realize this isn't really how you expected this day to go.");
            System.out.println("As the game continues on, you eventually hear a great commotion, and look to see what it is. You look to see a large crowd surrounding the Cheshire cat, with most of its body disappeared except for its head, and the queen shouting \"Off with its head1\" repeatedly");
            System.out.println("However, the executioner is refusing, saying that a creature with no body can't have its head cut off. The king, on the other hand, is saying that, if it has a head, it must be beheadable");
            System.out.println("They turn to you to settle the debate.");
        } else if (choice == 2) {
            //7
            System.out.println("You take pity on the gardeners and quickly help them hide in some potted plants while the procession is resituating itself. As you walk off with the procession, you see the guards giving up their search and hurrying to catch up");
            System.out.println("As you get to the croquet grounds, you find that the game really is quite mad. As you use a croquet that is a flamingo to hit a ball that is a hedgehog, though an arch that his a bent over card-man, you realize this isn't really how you expected this day to go.");
            System.out.println("As the game continues on, you eventually hear a great commotion, and look to see what it is. You look to see a large crowd surrounding the Cheshire cat, with most of its body disappeared except for its head, and the queen shouting \"Off with its head1\" repeatedly");
            System.out.println("However, the executioner is refusing, saying that a creature with no body can't have its head cut off. The king, on the other hand, is saying that, if it has a head, it must be beheadable");
            System.out.println("They turn to you to settle the debate.");
        }
        System.out.println("(1) Agree with the king\n(2) Agree with the Executioner\n(3) Suggest they call for the cat's owner");

        choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //8
            System.out.println("\"Aha!\" cries the king, \"Continue with the execution.\" However, the execution still refuses, now insisting that the cat's owner must decide instead of you.");
            System.out.println("\"Very well\" the king sighs, then calls to the guards, \"Release the Duchess from prison!\"");
        } else if (choice == 2) {
            //9
            System.out.println("\"He! I told you so.\" laughed the executioner. The king, however, would not accept defeat, now insisting that that cat's owner settle the debate instead");
            System.out.println("The king calls to the guards, \"Release the Duchess from prison!\"");
        } else if (choice == 3) {
            //10
            System.out.println("The king and executioner look at each other and shrug. The king calls to the guards, \"Release the Duchess from prison!\"");
        }
    }

    //Chapter 9 method
    private static void chapter9(Player p) {
        //1
        System.out.println("As the guards bring up the Duchess, the Queen's frenzy suddenly stops as she stares at the Duchess, her fury quite evident. She shouts \"Either you or your head will be off this instant!\" and the Duchess runs away as fast as she can");
        System.out.println("Seeing now that the debate will never be solved, the group begins to go back to the game. The Queen however, now looking quite cheeful, makes her way to you and asks \"Have you ever met the Gryphon?\"");

        System.out.println("(1) No ma'am, but I should like to\n(2) What the heck is a Gryphon?");

        int choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //3
        } else if (choice == 2) {
            //2
        }
        System.out.println("(1) The Queen really is a piece of work, isn't she?\n(2) Who is this Mock Turtle");

        choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //4
        } else if (choice == 5) {
            //5
        }
        System.out.println("(1) And why are you called the Mock Turtle?\n(2) Try to wait it out");

        choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //7
        } else if (choice == 2) {
            //6
        }
    }

    //Chapter 10 method
    private static void chapter10(Player p) {
        //1
        System.out.println("You are lead to a courtroom. Inside, you see the Knave of Hearts on trial for stealing raspberry tarts.");
        System.out.println("The trial begins, with the jury taking notes all the while. You notice that the pencil of the juror Bill is quite squeaky and annoyting");

        System.out.println("(1) Take the pencil away\n(2) Suffer through the noise");

        int choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //2
        } else if (choice == 2) {
            //3
        }
        System.out.println("(1) Well I can't help it, so deal with it!\n(2) I'm terribly sorry, but I can't seem to help it");

        choice = cleanInput(userInput.nextLine());

        System.out.println("The Dormouse harrumphs quite loudly. \"Well it isn't proper\" he says as he pointedly gets up and moves to another seat in the courtroom");
        System.out.println("The trial continues a while longer, when suddenly you are called up to testify!");

        System.out.println("(1) Make your way to the front through the crowd\n(2) Make your way to the front around the crowd");

        choice = cleanInput(userInput.nextLine());

        if (choice == 1) {
            //5
        } else if (choice == 2) {
            //6
        }
        System.out.println("(1) Refuse\n(2) Comply");

        if (choice == 1) {
            //8
        } else if (choice == 2) {
            //7
        }
    }
}

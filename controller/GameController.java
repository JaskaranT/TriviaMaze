package controller;

import model.Door;
import model.TriviaMaze;
import view.Display;

import java.io.*;
import java.util.Scanner;

public class GameController {

    private static Scanner input = new Scanner(System.in);
    private static Display myDisplay;
    private static TriviaMaze myMaze;

    private static final File GAME = new File("TriviaGameSaveFile.txt");

    public static void main(String [] theArgs){

        initialization();
    }

    private static void initialization(){

        Display.printTitle();
        Display.printLaunchMenu();
        runGame();
        boolean alive = true;

        while (alive) {
            if(!myMaze.isPath()) {
                Display.printGameLost();
                alive = false;
            }

            if(myMaze.isGameWon()) {
                Display.printGameWon();
                alive = false;
            }

            if (alive) {
                newGame();
            }

            if(!alive) {
                initialization();
            }
        }

    }





    private static void gameSetup() {
        myMaze = new TriviaMaze();
        myDisplay = new Display(myMaze);
    }




private static void runGame() {
    // Load Game / Start New Game
    boolean gameStarted = false;
    String userGameStartInput;
    while (!gameStarted) {
        userGameStartInput =input.nextLine();
        if (userGameStartInput.equalsIgnoreCase("1")) {
            //Initialize the maze and display
            gameStarted = true;
            gameSetup();

        } else if (userGameStartInput.equalsIgnoreCase("2")) {
            //Initialize the maze and display
           gameSetup();
            //Load from beginning
            if (loadGame()) {
                gameStarted = true;
            } else {
                Display.printLaunchMenu();
            }
        } else if (userGameStartInput.equalsIgnoreCase("3")) {
            Display.displayMoveControls();
        } else {
            Display.userActionWarning();
        }
    }
}


    private static void newGame() {
        printGame();
        nextAction();
    }

    private static void printGame() {
        Display.displayMaze();
        Display.displayRoom();
    }

    private static void nextAction() {
        boolean inputGood = false;
        String userAction = "";
        Display.printPrompt();

        while (!inputGood) {
            userAction = input.nextLine();
            if (userAction.toLowerCase().matches("north|south|east|west")) {
                inputGood = true;
                executeAction(userAction);
            } else if (userAction.toLowerCase().matches("help")) {
                inputGood = true;
                help();
            } else if (userAction.toLowerCase().matches("file")) {
                inputGood = true;
                file();
            } else if (userAction.toLowerCase().matches("Cheat")) {

                inputGood = true;
                Display.displayCheat();
                myMaze.teleportCheat();
                Display.printGameWon();
            } else if (!userAction.toLowerCase().matches("")) {
                Display.userActionWarning();
            }
        }
    }

    private static void executeAction(final String theDirection) {
        Door localDoor = myMaze.getCurrentRoom().getDoor(theDirection);
        if (myMaze.move(theDirection)) {
            if (localDoor.isDoorLocked()) {
                localDoor.getQuestion();
                String userAnswer = input.nextLine().toLowerCase();
                if (userAnswer.matches("cheat")) {
                    Display.displayCheat();
                } else {
                    attemptUnlock(userAnswer, localDoor);
                }

                if (localDoor.isDoorForeverLocked()) {
                    boolean locked = true;
                    localDoor.setMyForeverLocked(locked);
                    Display.printWrongAnswer();

                } else {
                    Display.printCorrectAnswer();
                   myMaze.movePlayer(theDirection);
                }
            } else {
                myMaze.movePlayer(theDirection);
            }
        }
    }




    private static void attemptUnlock(final String theAnswer, final Door theDoor) {
        theDoor.unlock(theAnswer);
    }



    private static boolean loadGame() {
        //Display prompt
        boolean success = false;
        try {
            FileInputStream file = new FileInputStream(GAME);
            if (GAME.length() != 0) {
                ObjectInputStream in = new ObjectInputStream(file);
                myMaze = (TriviaMaze) in.readObject();
                myDisplay = new Display(myMaze);
                //display load successful
                System.out.println("success");
                success = true;
            } else {
                //Display load fail;
                System.out.println("failed ");

            }
        } catch (IOException e) {
            System.out.println("No Save file exits");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return success;
    }

    private static void saveGame() {
        try {
            FileOutputStream file = new FileOutputStream(GAME);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(myMaze);
            out.close();
            file.close();
            System.out.println("success");
        } catch (IOException e) {
            System.out.println("Can't save");
        }
    }

    /**
     * This method activates the cheat
     * and prints the game won art.
     */


    private static void help() {
        Display.printHelp();;
        boolean inputGood = false;
        String helpAction;
        while (!inputGood) {
            Display.printPrompt();
            helpAction = input.nextLine();
            if (helpAction.toLowerCase().matches("about")) {
                inputGood = true;
                Display.printAbout();
                Display.prompt();
                input.nextLine();
            } else if (helpAction.toLowerCase().matches("instructions")) {
                inputGood = true;
                Display.displayIntro();
                Display.prompt();
                input.nextLine();
            } else if (helpAction.toLowerCase().matches("cheats")) {
                inputGood = true;
                Display.displayCheat();
                Display.prompt();
                input.nextLine();

            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void file() {
        Display.displayFile();
        boolean inputGood = false;
        String fileAction;

        while (!inputGood) {
            Display.printPrompt();
            fileAction = input.nextLine();

            if(fileAction.equals("2")){
                inputGood = true;
                input.close();
                System.exit(0);
            }

            else if (fileAction.equals("1")) {
                inputGood = true;
                saveGame();
            }
        }
    }



}



package controller;

import model.Door;
import model.TriviaMaze;
import view.Display;

import java.io.*;
import java.util.Scanner;

public class GameController {

  private static final File GAME = new File("TriviaGameSaveFile.txt");

  private static final Scanner myIn = new Scanner(System.in);
  private static Display myDisplay;
  private static TriviaMaze myMaze;

  public static void main (String []theArgs) {
    initialization();
    triviaMazeLoop();
 /*

    String door = String.format("""
                             ____
                             |%s|
                        ____ ---- ____
                        |%s|      |%s|
                        ---- ____ ----
                             |%s| 
                             ----
                                """, "OP", "LK", "LF", "WL");
    System.out.print(door);
    */
  }
//create new Maze and display. Print out Intro.
  private static void initialization() {
    myMaze = new TriviaMaze();
    myDisplay = new Display(myMaze);
    myDisplay.StartIntro();
  }

  // The Game Loop that will keep looping until the player has won or lost
  private static void triviaMazeLoop() {
    // ask user to select a file
    System.out.println("new or load");
    startupGame();
    boolean active = true;              //boolean to track if game is still active/playable
    while (active) {
      //if there is no way for the player to navigate through the maze then the player loses.
      if (!(myMaze.possibleRoute())) {
        myDisplay.displayPlayerLost();
        active = false;
      }
      // if the player reaches the end of the maze, then the player wins.
      if (myMaze.isGameWon()) {
        myDisplay.displayPlayerWon();
        active =  false;
      }
      // loop game if it's still active/playable.
      if (active) {
        triviaGame();
      }
    }
  }

  private static void startupGame () {
    boolean success = false;
    String userIn;
    while (!success) {
      userIn = myIn.nextLine();
      if (userIn.equalsIgnoreCase("new")) {
        success = true;
      } else if (userIn.equalsIgnoreCase("load")) {
        if (loadGame()) {
          success = true;
        } else {
          System.out.println("new or load");
        }
      }
    }
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
  //updates room, displays maze/room and asks for player's next move.
  private static void triviaGame() {
    myDisplay.displayMaze();
    myDisplay.displayRoom();   //Still need work to display room
    playersNextMove();
  }

  //gets player's next move. Checks if input is valid to send to next method to process movement.
  //Still needs work
  private static void playersNextMove(){
    myDisplay.displayDirection();
    boolean validIn = false;
    String playersMove;
    // will keep asking player to input a valid response until a valid response is inputted.
    while (!validIn) {
      playersMove = myIn.nextLine();
      if (playersMove.toLowerCase().matches("north|west|south|east")) {
        playerMovement(playersMove);
        validIn = true;
      }else if (playersMove.toLowerCase().matches("menu")) {
        gameMenu();
        validIn = true;
      } else if (playersMove.toLowerCase().matches("help")) {
        gameHelpMenu();
        validIn = true;
      }
      else {
        myDisplay.displayWrongIn();
      }
    }
  }

  private static void gameMenu () {
    boolean validIn = false;
    myDisplay.displayFileMenu();
    String playersIn = myIn.nextLine();
    while (!validIn) {
      if (playersIn.toLowerCase().matches("save")) {
        saveGame();
        validIn = true;
      } else if (playersIn.toLowerCase().matches("load")) {
        loadGame();
        validIn = true;
      } else if (playersIn.toLowerCase().matches("exit")) {
        myIn.close();
        System.exit(0);
      } else {
        myDisplay.displayWrongIn();
      }
    }

  }

  private static void gameHelpMenu () {
    boolean validIn = false;
    myDisplay.displayHelpMenu();
    String playersIn = myIn.nextLine();
    while (!validIn) {
      if (playersIn.toLowerCase().matches("instr")) {
        myDisplay.displayInstruction();
        validIn = true;
      } else if (playersIn.toLowerCase().matches("about")) {
        myDisplay.GameInfo();
        validIn = true;
      } else {
        myDisplay.displayWrongIn();
      }

    }

  }

  // Takes the player's input to moves player in that direction if it's possible
  private static void playerMovement (final String theDirection) {
    Door currentDoor = myMaze.getRoomLocation().getDoor(theDirection); //door that the player wants to go through
    //first checks if the door is not a wall and not locked forever
    if (myMaze.canMove(currentDoor)) {
      //checks that the door is locked
      if (currentDoor.isLocked()) {
        //displays question for user and takes the input from user to match with answer
        myDisplay.displayQuestion(currentDoor.getQuestion());
        String PlayersAnswer = myIn.nextLine();
        currentDoor.answer(PlayersAnswer);
        // checks if the door is locked forever in the case of the player getting the question wrong
        if (currentDoor.isLockedForever()) {
          myDisplay.displayIncorrect();
          myDisplay.displayAnswer(currentDoor.getAnswer());

        } else {   // moves player to room if the door is not locked forever
          myMaze.MovePlayer(theDirection);
          myDisplay.displayCorrect();
        }
      } else { // moves player to room if the room had already been visited
        myMaze.MovePlayer(theDirection);
        myDisplay.displayVisited();
      }
    } else { //indicates that user is trying to move to an invalid location. Either wall or Locked forever door
      myDisplay.displayWrongDirection();
    }
  }

}

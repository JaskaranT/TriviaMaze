package controller;

import model.Door;
import model.TriviaMaze;
import view.Display;

import java.util.Scanner;

public class GameController {

  private static final Scanner myIn = new Scanner(System.in);
  private static Display myDisplay;
  private static TriviaMaze myMaze;

  public static void main (String []theArgs) {
    initialization();
    triviaMazeLoop();

  }
//create new Maze and display. Print out Intro.
  private static void initialization() {
    myMaze = new TriviaMaze();
    myDisplay = new Display(myMaze);
    myDisplay.StartIntro();
  }

  // The Game Loop that will keep looping until the player has won or lost
  private static void triviaMazeLoop() {
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
  //updates room, displays maze/room and asks for player's next move.
  private static void triviaGame() {
   // myMaze.getRoomLocation().setVisited();
    myDisplay.displayMaze();
    myDisplay.displayRoom();   //Still need work to display room
    playersNextMove();
  }

  //gets player's next move. Checks if input is valid to send to next method to process movement.
  //Still needs work
  private static void playersNextMove(){
    myDisplay.displayDirection();
    boolean validIn = false;
    String playersMove = "";
    // will keep asking player to input a valid response until a valid response is inputted.
    while (!validIn) {
      playersMove = myIn.nextLine();
      if (playersMove.toLowerCase().matches("north|west|south|east")) {
        validIn = true;
      }
      else {
        myDisplay.displayWrongIn();
      }
    }
    playerMovement(playersMove);
  }

  // Takes the player's input to moves player in that direction if it's possible
  private static void playerMovement (String theDirection) {
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

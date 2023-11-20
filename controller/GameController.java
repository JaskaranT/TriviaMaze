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
    Initialization();
    TriviaMazeLoop();

  }

  private static void Initialization() {
    myMaze = new TriviaMaze();
    myDisplay = new Display(myMaze);
    myDisplay.StartIntro();
  }

  private static void TriviaMazeLoop() {
    boolean active = true;
    while (active) {
      if (!PossibleRoute()) {
        myDisplay.displayPlayerLost();
        active = false;
      }
      if (myMaze.isGameWon()) {
        myDisplay.displayPlayerWon();
        active =  false;
      }
      if (active) {
        TriviaGame();
      }
    }
  }
  private static void TriviaGame() {
    myMaze.getRoomLocation().setVisited();
    myDisplay.displayMaze();
    myDisplay.displayRoom();
    PlayersNextMove();
  }

  private static void PlayersNextMove(){
    myDisplay.displayDirection();
    boolean validIn = false;
    String playersMove = "";
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
  private static void playerMovement (String theDirection) {
    int direction = 101;
    switch (theDirection.toLowerCase()) {
      case "north" -> direction = 0;
      case "west" -> direction = 1;
      case "south" -> direction = 2;
      case "east" -> direction = 3;
    }
    Door currentDoor = myMaze.getRoomLocation().getDoor(direction);
    if (myMaze.canMove(direction)) {
      if (currentDoor.isLocked() && !(myMaze.checkVisited(theDirection))) {
        myDisplay.displayQuestion(currentDoor.getQuestion());
        String PlayersAnswer = myIn.nextLine();
        currentDoor.answer(PlayersAnswer);
        if (currentDoor.isLockedForever()) {
          myDisplay.displayIncorrect();
          myDisplay.displayAnswer(currentDoor.getAnswer());

        } else {
          myMaze.MovePlayer(theDirection);
          myDisplay.displayCorrect();
        }
      } else {
        myMaze.MovePlayer(theDirection);
        myDisplay.displayVisited();
      }
    } else {
      myDisplay.displayWrongDirection();
    }


  }

  // Method that will traverse through the array to check if
  // there's a route that player can take to get to the end.
  private static boolean PossibleRoute () {
    return true;
  }

}

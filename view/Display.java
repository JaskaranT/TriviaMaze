package view;

import model.TriviaMaze;

public class Display {
  private final TriviaMaze myMaze;
  public Display(TriviaMaze theMaze) {
    myMaze = theMaze;
  }

  public void displayMaze() {
    System.out.print(myMaze.toString());
  }

  public void displayRoom () {
    System.out.print(myMaze.getRoomLocation().toString());
  }
  public void StartIntro() {
    System.out.println("WELCOME TO TRIVIA MAZE");
    GameInfo();
  }
  public void GameInfo () {
    System.out.println("In this game you will Travel through rooms answering questions where you main goal");
    System.out.println("will be to reach the exit");
    System.out.println("Everytime you get a correct answer, that room will remain unlock but be careful because");
    System.out.println( "one wrong answer will lock that room forever.");
  }

  public void displayInstruction() {
    System.out.println("Instructions: ");
    System.out.println("In this game you will be placed in the start location.");
    System.out.println("You will then need to choose room that's adjacent to we you are currently at.");
    System.out.println("There are four options for moving. NORTH, WEST, EAST, SOUTH");
    System.out.println("You will type one and will approach the door as long as its not a wall,");
    System.out.println(" or locked forever door. Once you approach it you will be prompt to answer a question.");
    System.out.println("If you answer is correct you will proceed to the room, if its incorrect, the door will lock");
    System.out.println(" forever meaning you can go through there anymore so you will need to find another way.");
    System.out.println("if you lock yourself and there's no where to go then its game over.");
  }
  public void displayQuestion(String theQuestion) {
    System.out.println(theQuestion);
  }

  public void displayAnswer(String theAnswer) {
    System.out.println("The correct answer was " + theAnswer);
  }

  public void displayPlayerWon() {
    System.out.println("CONGRATULATIONS! YOU WON!");
  }

  public void displayPlayerLost() {
    System.out.println("Sorry, there are no more doors to unlock. You Have Lost...");
  }

  public void displayCorrect() {
    System.out.println("CORRECT! You may proceed");
  }

  public void displayIncorrect() {
    System.out.println("INCORRECT! Door is now locked forever");
  }

  public void displayDirection() {
    System.out.println("|NORTH || WEST || SOUTH|| EAST |");
    System.out.println("Type a direction.");
  }

  public void displayWrongIn() {
    System.out.println("Wrong Input Try Again.");
  }
  public void displayWrongDirection() {
    System.out.println("Can't go that Direction. Try again.");
  }

  public void displayVisited() {
    System.out.println("You already visited this room welcome back");
  }

  public void displayFileMenu() {
    System.out.println("Type one of the following:");
    System.out.println("\"Save\" to save game");
    System.out.println("\"Load\" to load game");
    System.out.println("\"Exit\" to exit game");
  }
  public void displayHelpMenu() {
    System.out.println("Type one of the following:");
    System.out.println("\"About\" for information about the game");
    System.out.println("\"Instr\" for game Instructions");
  }

}

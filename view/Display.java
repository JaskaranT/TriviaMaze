package view;

import model.TriviaMaze;

public class Display {
  private TriviaMaze myMaze;
  public Display(TriviaMaze theMaze) {
    myMaze = theMaze;
  }

  public void displayMaze() {
    System.out.print(myMaze.toString);
  }

  public void displayRoom () {
    System.out.print(myMaze.getRoomLocation().toString());
  }
  public void StartIntro() {
    System.out.println("WELCOME TO TRIVIA MAZE");
    GameInfo();
  }
  public void GameInfo () {
    System.out.println("In this game you will Travel through rooms answering questions where you main goal" +
            "will be to reach the exit");
    System.out.println("Everytime you get a correct answer, that room will remain unlock but be careful because one " +
            "wrong answer will lock that room forever.");
  }

  public void displayInstruction() {
    //instructions are yet to be decided.
  }
  public void displayQuestion(String theQuestion) {
    System.out.print(theQuestion);
  }

  public void displayAnswer(String theAnswer) {
    System.out.print(theAnswer);
  }

  public void displayPlayerWon() {
    System.out.println("CONGRATULATIONS! YOU WON!");
  }

  public void displayPlayerLost() {
    System.out.println("Sorry, there are no more doors to unlock. You Have Lost...");
  }

  public void displayFileMenu() {

  }
  public void displayHelpMenu() {

  }

}

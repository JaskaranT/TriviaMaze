package view;

import model.TriviaMaze;

public class Display {
  private final TriviaMaze myMaze;
  public Display(TriviaMaze theMaze) {
    myMaze = theMaze;
  }

  public void displayMaze() {
    System.out.println("\t\t\t  MAZE");
    System.out.print("\t\t________________");
    System.out.print(myMaze.toString());
    System.out.println("\t\t----------------");
    System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
  }

  public void displayRoom () {
    System.out.print(myMaze.getRoomDisplay());
  }

  public void DisplayGameType() {
    System.out.println("""


            NEW - 𝐏𝐥𝐚𝐲 𝐍𝐞𝐰 𝐆𝐚𝐦𝐞                   LOAD - 𝐋𝐨𝐚𝐝 𝐆𝐚𝐦𝐞""");

  }

  public void displayTitle() {
    System.out.println("""


            ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
            ─██████████████─████████████████───██████████─██████──██████─██████████─██████████████────██████──────────██████─██████████████─██████████████████─██████████████─
            ─██░░░░░░░░░░██─██░░░░░░░░░░░░██───██░░░░░░██─██░░██──██░░██─██░░░░░░██─██░░░░░░░░░░██────██░░██████████████░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─
            ─██████░░██████─██░░████████░░██───████░░████─██░░██──██░░██─████░░████─██░░██████░░██────██░░░░░░░░░░░░░░░░░░██─██░░██████░░██─████████████░░░░██─██░░██████████─
            ─────██░░██─────██░░██────██░░██─────██░░██───██░░██──██░░██───██░░██───██░░██──██░░██────██░░██████░░██████░░██─██░░██──██░░██─────────████░░████─██░░██─────────
            ─────██░░██─────██░░████████░░██─────██░░██───██░░██──██░░██───██░░██───██░░██████░░██────██░░██──██░░██──██░░██─██░░██████░░██───────████░░████───██░░██████████─
            ─────██░░██─────██░░░░░░░░░░░░██─────██░░██───██░░██──██░░██───██░░██───██░░░░░░░░░░██────██░░██──██░░██──██░░██─██░░░░░░░░░░██─────████░░████─────██░░░░░░░░░░██─
            ─────██░░██─────██░░██████░░████─────██░░██───██░░██──██░░██───██░░██───██░░██████░░██────██░░██──██████──██░░██─██░░██████░░██───████░░████───────██░░██████████─
            ─────██░░██─────██░░██──██░░██───────██░░██───██░░░░██░░░░██───██░░██───██░░██──██░░██────██░░██──────────██░░██─██░░██──██░░██─████░░████─────────██░░██─────────
            ─────██░░██─────██░░██──██░░██████─████░░████─████░░░░░░████─████░░████─██░░██──██░░██────██░░██──────────██░░██─██░░██──██░░██─██░░░░████████████─██░░██████████─
            ─────██░░██─────██░░██──██░░░░░░██─██░░░░░░██───████░░████───██░░░░░░██─██░░██──██░░██────██░░██──────────██░░██─██░░██──██░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─
            ─────██████─────██████──██████████─██████████─────██████─────██████████─██████──██████────██████──────────██████─██████──██████─██████████████████─██████████████─
            ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────""");
  }
  public void StartIntro() {
    System.out.println("WELCOME TO TRIVIA MAZE");
    GameInfo();
  }
  public void GameInfo () {
    System.out.println("In this game you will be placed in the start location.");
    System.out.println("You will then need to choose room that's adjacent to we you are currently at.");
    System.out.println("There are four options for moving. NORTH, WEST, EAST, SOUTH.");
    System.out.println("You will type one and will approach the door as long as its not a wall,");
    System.out.println("or locked forever door. Once you approach it you will be prompt to answer a question.");
    System.out.println("If you answer is correct you will proceed to the room, if its incorrect, the door will lock");
    System.out.println("forever meaning you can't go through there anymore so you will need to find another way.");
    System.out.println("If you lock yourself out and there's no where to go then its game over.");
  }

  public void displayInstruction() {
    System.out.println("Instructions: ");
    System.out.println("To move to a different room, you can type:");
    System.out.println("\"North\" to move up");
    System.out.println("\"South\" to move down");
    System.out.println("\"East\" to move right");
    System.out.println("\"West\" to move left");
    System.out.println();
    System.out.println("In the MAZE display:");
    System.out.println("|ST| means the room where you started");
    System.out.println("|RM| means a room");
    System.out.println("|ED| means the end room to win");
    System.out.println();
    System.out.println("In the Room display:");
    System.out.println("|XX| means you can't go through either because it's a wall or door is locked forever");
    System.out.println("|OP| means you can access that door since it was unlocked");
    System.out.println("|LK| means the door is locked but is accessible if Question is answered correctly");
    System.out.println();
    System.out.println("There are three types of questions:");
    System.out.println("Short Answer - You must type the answer");
    System.out.println("Multiple Choice - You must type either A, B, or C");
    System.out.println("True or False - You must type either True or False");
    System.out.println();
  }
  public void displayQuestion(final String theQuestion) {
    System.out.println(theQuestion);
  }

  public void displayAnswer(final String theAnswer) {
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
    System.out.println("Options: |MENU| - |HELP| ");
    System.out.println("Type an option or direction");
    System.out.println();
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

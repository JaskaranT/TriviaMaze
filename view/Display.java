package view;

import model.Question;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {
    public static void printHomePage() {
        System.out.println("Welcome User to the TRIVIA MAZE!");
        System.out.println("Remember during the game: ");
        System.out.println("Press '+' for menu screen in the game.");
        System.out.println("'O' represents the rooms you have unlocked.");
        System.out.println("'X' represents the room that are locked.");
        System.out.println("'*' represents the room you are in.");
        System.out.println();
        System.out.println("Please select an option: ");
        System.out.println(
                " New Game (select 1)      Load Game (select 2)      Help Screen (select 3)      Quit(select 4)");
    }

    /**
     * Gets the valid user input when the user is on "Home Page." Valid inputs at
     * home page are --> [1,2,3,4]
     *
     * @return String: user input
     */
    public static String getInputFromHomePage() {
        String homePageInput = SC.next();
        final Set<String> homePageChoices = new HashSet<>(Arrays.asList("1", "2", "3", "4"));

        while (!homePageChoices.contains(homePageInput)) {
            System.out.println("Invalid input, try again.");
            homePageInput = SC.next();
        }
        return homePageInput;
    }

    /**
     * Print the main menu.
     */
    public static void printMainMenu() {
        System.out.println("--------- Main Menu ---------");
        System.out.println("Save Game (select 1)");
        System.out.println("Go to Home Page (select 2)");
        System.out.println("Close Main Menu (select 3)");
        System.out.println("Help (select 4)");
        System.out.println("Quit Game (select 5)");
        System.out.println("-----------------------------");
    }

    /**
     * Get a valid input from the main menu. Currently the valid inputs are -->
     * [1,2,3,4,5]
     *
     * @return String: user input
     */
    public static String getInputFromMainMenu() {
        String mainMenuInput = SC.next();
        // System.out.println(mainMenuInput);
        final Set<String> mainMenuChoices = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5"));

        while (!mainMenuChoices.contains(mainMenuInput)) {
            System.out.println("Invalid input, try again.");
            mainMenuInput = SC.next();
        }
        return mainMenuInput;
    }

    /**
     * Prints the state of the maze and the current user.
     *
     * @param maze
     */
    public static void printTheCurrentMazeInfo(final Maze maze) {
        System.out.println(maze);
        System.out.println("You are curently in " + maze.getRowIndex() + " row and " + maze.getColIndex() + " column.");
        System.out.println("Please select one of the given door(s):");
        System.out.println(maze.getCurrentAvailableDoors());
    }

    /**
     * Returns a valid input from the user. A user can enter either a given
     * direction or can choose to quit the game or choose main menu or can use one
     * of the valid cheats.
     *
     * @param maze
     * @return String: User input
     */
    public static char getUserDirection(final Maze maze) {
        final Set<Character> availableChoices = new HashSet<>();
        for (char ch : maze.getCurrentAvailableDoors()) {
            // convert the character to string
            availableChoices.add(ch);
        }
        availableChoices.add(MAIN_MENU_OPTION);
        availableChoices.add(QUIT_OPTION);
        availableChoices.add(CHEAT_ONE);
        availableChoices.add(CHEAT_TWO);

        char directionInput = Character.toUpperCase(SC.next().charAt(0));
        while (!availableChoices.contains(directionInput)) {
            System.out.println("Invalid input, try again!");
            directionInput = Character.toUpperCase(SC.next().charAt(0));
        }
        return directionInput;
    }

    /**
     * Returns an Answer from the user
     *
     * @return String: Answer
     */
    public static String getUserAnswer() {
        System.out.println("Your Answer:");
        final String answer = SC.next();
        return answer.toLowerCase();
    }

    /**
     * Return the file name entered by the user
     *
     * @return String: Filename
     */
    public static String getFileName() {
        // System.out.print("Press Q to quit or ");
        System.out.println("Please enter the name of the file: ");
        final String filename = SC.next();
        return filename;
    }

    /**
     * Prints the final verdict of the game.
     *
     * @param result
     */
    public static void printResult(final boolean result) {
        if (result) {
            System.out.println("You Won!!");
        } else {
            System.out.println("You Lost!!");
        }
    }

/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package controller;

import java.awt.*;

/**
 * The Main class is the entry point of the application.
 * It initializes the GameController and starts the game.
 *
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/15/2023
 */
public final class MainController {

    /**
     * Private constructor to prevent instantiation of the Main class.
     */
    private MainController() {
        //no usage
    }

    /**
     * The main method is the entry point of the application.
     * It invokes the GameController in the Event Dispatch Thread (EDT).
     *
     * @param theArgs Command-line arguments (not used in this application).
     */
    public static void main (final String... theArgs) {
        EventQueue.invokeLater(GameController::new);
    }
}
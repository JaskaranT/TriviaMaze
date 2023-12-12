package model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenImage {

    public static void main(String[] args) {
        // Your game logic here

        // When the player wins:
        showWinningImage("images/door.png");
    }

    private static void showWinningImage(String imagePath) {
        if (Desktop.isDesktopSupported()) {
            try {
                // Open the image file with the default image viewer
                File imageFile = new File(imagePath);
                Desktop.getDesktop().open(imageFile);
            } catch (IOException e) {
                // Handle the situation where the image can't be opened (e.g., file not found or no permission)
                System.err.println("Unable to open image file: " + e.getMessage());
            }
        } else {
            System.err.println("Desktop is not supported. Cannot open the image file.");
        }
    }
}

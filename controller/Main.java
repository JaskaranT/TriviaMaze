package controller;


import java.awt.*;

public class Main {

    private Main() {

    }

    public static void main (String... theArgs) {
        EventQueue.invokeLater(GameController::new);
    }
}
package controller;

import model.Door;
import model.TriviaMaze;
import view.Display;

import java.io.*;
import java.util.Scanner;

public class GameController {

    private static Display myDisplay;
    private static TriviaMaze myMaze;

    public static void main(String [] theArgs){
        initialization();
    }

    private static void initialization(){
        myMaze = new TriviaMaze();
        myDisplay = new Display(myMaze);

        myDisplay.displayMaze();
    }
}

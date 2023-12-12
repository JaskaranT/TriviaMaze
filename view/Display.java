package view;

import model.PlaySound;
import model.Question;
import model.TriviaMaze;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Display {


   private static TriviaMaze myMaze;

    /**
     * Sound files are constant
     */
    private static final File WRONG_ANSWER_SOUND = new File("wrong-answer-sound-effect.wav");

    private static final File CORRECT_ANSWER_SOUND = new File("Correct.wav");

    private static final File GAME_LOST_SOUND = new File("gamelostsound.wav");

    private static final File GAME_WON_SOUND = new File("gamewon.wav");

   public static void main(String [] args) {
       displayMoveControls();
   }

    public static void displayMaze() {
        System.out.print(myMaze.toString());
    }

    public static void printPrompt() {
       System.out.println("Choose: ");
    }

    public static void printLaunchMenu() {
       System.out.println("\n\n\n\n𝟏 - 𝐏𝐥𝐚𝐲 𝐍𝐞𝐰 𝐆𝐚𝐦𝐞                   "    +"𝟐 - 𝐋𝐨𝐚𝐝 𝐆𝐚𝐦𝐞                  " + "𝟑 - 𝐇𝐞𝐥𝐩"
             );

    }


    public static void displayIntro() {
        System.out.println("🆆🅴🅻🅲🅾🅼🅴 🆃🅾 🆃🅷🅴 🆃🆁🅸🆅🅸🅰 🅼🅰🆉🅴❗");
        System.out.println("𝗜𝗻𝘀𝘁𝗿𝘂𝗰𝘁𝗶𝗼𝗻𝘀:");
        System.out.println("In this game you will be placed in the start location.");
        System.out.println("You will then need to choose room that's adjacent to we you are currently at.");
        System.out.println("There are four options for moving. NORTH, WEST, EAST, SOUTH");
        System.out.println("You will type one and will approach the door as long as its not a wall,");
        System.out.println(" or locked forever door. Once you approach it you will be prompt to answer a question.");
        System.out.println("If you answer is correct you will proceed to the room, if its incorrect, the door will lock");
        System.out.println(" forever meaning you can go through there anymore so you will need to find another way.");
        System.out.println("if you lock yourself and there's no where to go then its game over.");
    }

    public static void printMainMenu() {
        System.out.println("\n" +
                "███╗░░░███╗░█████╗░██╗███╗░░██╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██\n"+
                "████╗░████║██╔══██╗██║████╗░██║  ████╗░████║██╔════╝████╗░██║██║░░░██║\n"+
                "██╔████╔██║███████║██║██╔██╗██║  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║\n"+
                "██║╚██╔╝██║██╔══██║██║██║╚████║  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║\n"+
                "██║░╚═╝░██║██║░░██║██║██║░╚███║  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝\n"+
                "╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚══╝  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░");
        System.out.println(

                " Quit  (Press 1)                 File (Press 2)" );
    }

    public static void printHelp() {

    }

    public static void displayMoveControls() {
       System.out.println( "█▀▀ █▀▀█ █▀▀▄ ▀▀█▀▀ █▀▀█ █▀▀█ █── █▀▀ \n" +
                           "█── █──█ █──█ ──█── █▄▄▀ █──█ █── ▀▀█ \n" +
                           "▀▀▀ ▀▀▀▀ ▀──▀ ──▀── ▀─▀▀ ▀▀▀▀ ▀▀▀ ▀▀▀\n");
       System.out.println("Type which direction you would like to move:\n ");
        System.out.println( "𝖭𝖮𝖱𝖳𝖧\n𝖶𝖤𝖲𝖳\n𝖲𝖮𝖴𝖳𝖧\n𝖤𝖠𝖲𝖳" );
    }

    public static void printTitle() {
        System.out.println("\n" +

                "\n" +
                "──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n" +
                "─██████████████─████████████████───██████████─██████──██████─██████████─██████████████────██████──────────██████─██████████████─██████████████████─██████████████─\n" +
                "─██░░░░░░░░░░██─██░░░░░░░░░░░░██───██░░░░░░██─██░░██──██░░██─██░░░░░░██─██░░░░░░░░░░██────██░░██████████████░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─\n" +
                "─██████░░██████─██░░████████░░██───████░░████─██░░██──██░░██─████░░████─██░░██████░░██────██░░░░░░░░░░░░░░░░░░██─██░░██████░░██─████████████░░░░██─██░░██████████─\n" +
                "─────██░░██─────██░░██────██░░██─────██░░██───██░░██──██░░██───██░░██───██░░██──██░░██────██░░██████░░██████░░██─██░░██──██░░██─────────████░░████─██░░██─────────\n" +
                "─────██░░██─────██░░████████░░██─────██░░██───██░░██──██░░██───██░░██───██░░██████░░██────██░░██──██░░██──██░░██─██░░██████░░██───────████░░████───██░░██████████─\n" +
                "─────██░░██─────██░░░░░░░░░░░░██─────██░░██───██░░██──██░░██───██░░██───██░░░░░░░░░░██────██░░██──██░░██──██░░██─██░░░░░░░░░░██─────████░░████─────██░░░░░░░░░░██─\n" +
                "─────██░░██─────██░░██████░░████─────██░░██───██░░██──██░░██───██░░██───██░░██████░░██────██░░██──██████──██░░██─██░░██████░░██───████░░████───────██░░██████████─\n" +
                "─────██░░██─────██░░██──██░░██───────██░░██───██░░░░██░░░░██───██░░██───██░░██──██░░██────██░░██──────────██░░██─██░░██──██░░██─████░░████─────────██░░██─────────\n" +
                "─────██░░██─────██░░██──██░░██████─████░░████─████░░░░░░████─████░░████─██░░██──██░░██────██░░██──────────██░░██─██░░██──██░░██─██░░░░████████████─██░░██████████─\n" +
                "─────██░░██─────██░░██──██░░░░░░██─██░░░░░░██───████░░████───██░░░░░░██─██░░██──██░░██────██░░██──────────██░░██─██░░██──██░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─\n" +
                "─────██████─────██████──██████████─██████████─────██████─────██████████─██████──██████────██████──────────██████─██████──██████─██████████████████─██████████████─\n" +
                "──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public static void printWrongAnswer() {
       System.out.println("Incorrect!");
       PlaySound.playSound(WRONG_ANSWER_SOUND);
    }

    public static void printCorrectAnswer() {
       System.out.println("Correct!");
       PlaySound.playSound(CORRECT_ANSWER_SOUND);
    }

    public static void userActionWarning() {
       System.out.println("Incorrect input!, Try Again : ");
    }

    public static void printGameWon() {
        System.out.println("\n" +

                "██╗░░░██╗░█████╗░██╗░░░██╗  ░██╗░░░░░░░██╗░█████╗░███╗░░██╗\n"+
                "╚██╗░██╔╝██╔══██╗██║░░░██║  ░██║░░██╗░░██║██╔══██╗████╗░██║\n"+
                "░╚████╔╝░██║░░██║██║░░░██║  ░╚██╗████╗██╔╝██║░░██║██╔██╗██║\n"+
                "░░╚██╔╝░░██║░░██║██║░░░██║  ░░████╔═████║░██║░░██║██║╚████║\n"+
                "░░░██║░░░╚█████╔╝╚██████╔╝  ░░╚██╔╝░╚██╔╝░╚█████╔╝██║░╚███║\n"+
                "░░░╚═╝░░░░╚════╝░░╚═════╝░  ░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚══╝");
        PlaySound.playSound(GAME_WON_SOUND);

    }

    public static void printGameLost() {
        System.out.println("\n" +



                "─────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n" +
                "─████████──████████─██████████████─██████──██████────██████─────────██████████████─██████████████─██████████████─\n"+
                "─██░░░░██──██░░░░██─██░░░░░░░░░░██─██░░██──██░░██────██░░██─────────██░░░░░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─\n"+
                "─████░░██──██░░████─██░░██████░░██─██░░██──██░░██────██░░██─────────██░░██████░░██─██░░██████████─██████░░██████─\n"+
                "───██░░░░██░░░░██───██░░██──██░░██─██░░██──██░░██────██░░██─────────██░░██──██░░██─██░░██─────────────██░░██─────\n"+
                "───████░░░░░░████───██░░██──██░░██─██░░██──██░░██────██░░██─────────██░░██──██░░██─██░░██████████─────██░░██─────\n"+
                "─────████░░████─────██░░██──██░░██─██░░██──██░░██────██░░██─────────██░░██──██░░██─██░░░░░░░░░░██─────██░░██─────\n"+
                "───────██░░██───────██░░██──██░░██─██░░██──██░░██────██░░██─────────██░░██──██░░██─██████████░░██─────██░░██─────\n"+
                "───────██░░██───────██░░██──██░░██─██░░██──██░░██────██░░██─────────██░░██──██░░██─────────██░░██─────██░░██─────\n"+
                "───────██░░██───────██░░██████░░██─██░░██████░░██────██░░██████████─██░░██████░░██─██████████░░██─────██░░██─────\n"+
                "───────██░░██───────██░░░░░░░░░░██─██░░░░░░░░░░██────██░░░░░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─────██░░██─────\n"+
                "───────██████───────██████████████─██████████████────██████████████─██████████████─██████████████─────██████─────\n"+
                "─────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        PlaySound.playSound(GAME_LOST_SOUND);

    }

    public static void displayCheat() {
       System.out.println("Cheats: " +
               "\nMove to end(Type Cheat)");
    }




}
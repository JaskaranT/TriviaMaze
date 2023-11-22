package controller;

import model.*;

import java.util.List;
import java.util.Scanner;

public class GameController {

    private TriviaMaze triviaMaze;
    private Player player;
    private Scanner scanner;

    public GameController() {
        triviaMaze = new TriviaMaze();
        player = new Player(triviaMaze.getEntrance());
        scanner = new Scanner(System.in);
    }

    public GameController(Player player) {
        this.player = player;
    }

    public void startGame() {
        System.out.println("Welcome to Trivia Maze!");

        while (true) {
            displayMenu();
            displayGameInfo();

            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    handleMove();
                    break;
                case 2:
                    handleAnswerQuestion();
                    break;
                case 3:
                    handleSaveGame();
                    break;
                case 4:
                    handleLoadGame();
                    break;
                case 5:
                    System.out.println("Thanks for playing! Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (triviaMaze.isGameWon()) {
                System.out.println("Congratulations! You've won the game!");
                break;
            }
        }
    }

    private void displayGameInfo() {
        System.out.println("Current Room: " + player.getCurrentRoom().getRoomName());
        System.out.println("Questions Answered Correctly: " + player.getCorrectAnswers());
        System.out.println("-------------------------------");
        // Add more information based on your game's requirements
    }

    private int getMenuChoice() {
        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private void displayMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("1. Move to a new room");
        System.out.println("2. Answer a question");
        System.out.println("3. Save game");
        System.out.println("4. Load game");
        System.out.println("5. Exit");
    }


     public void displayAvailableDoors() {
        Room currentRoom = player.getCurrentRoom();
        List<Door> doors = currentRoom.getAvailableDoors(); 

        System.out.println("Available Doors:");
        for (int i = 0; i < doors.size(); i++) {
            System.out.println(i + ". " + doors.get(i).getQuestion()); 
        }
    }



    public void handleMove() {
        System.out.println("Available doors:");
        displayAvailableDoors(); // Assuming you have a method to display available doors

        // Get user input for the selected door
        System.out.print("Enter the door number to move through: ");
        int doorNumber = scanner.nextInt();

        // Call the moveThroughDoor method and check if the move was successful
        boolean moveSuccessful = player.moveThroughDoor(doorNumber);
        if (moveSuccessful) {
            System.out.println("Move successful!");
        } else {
            System.out.println("Move unsuccessful. Please try again.");
        }
    }
    
    

    private void handleAnswerQuestion() {
        Room currentRoom = player.getCurrentRoom();
        List<Door> availableDoors = currentRoom.getAvailableDoors();
    
        if (availableDoors.isEmpty()) {
            System.out.println("No available doors to answer questions. Check your options.");
            return;
        }
    
        System.out.println("Available Doors:");
        for (int i = 0; i < availableDoors.size(); i++) {
            System.out.println(i + ". " + availableDoors.get(i).getQuestion());
        }
    
        System.out.print("Enter the door number to answer the question: ");
        int doorNumber = scanner.nextInt();
    
        if (doorNumber >= 0 && doorNumber < availableDoors.size()) {
            Door selectedDoor = availableDoors.get(doorNumber);
    
            System.out.println("Current Question: " + selectedDoor.getQuestion());
            System.out.print("Enter your answer: ");
    
            String userAnswer = scanner.next();
    
            player.answerQuestion(userAnswer, selectedDoor);
    
            System.out.println("Answer submitted. Proceeding to the next room.");
        } else {
            System.out.println("Invalid door number. Please choose a valid door.");
        }
    }
    
    
    

    private void handleSaveGame() {
        SaveState saveState = new SaveState(triviaMaze, player);
    
        SerializationUtil.serialize(saveState, "savegame.ser");
    
        System.out.println("Game saved successfully!");
    }
    
    

    private void handleLoadGame() {
        SaveState saveState = SerializationUtil.deserialize("savegame.ser");
    
        triviaMaze.restoreState(saveState.getTriviaMazeState());
        player.restoreState(saveState.getPlayerState());
    
        System.out.println("Game loaded successfully!");
    }
    
    

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}

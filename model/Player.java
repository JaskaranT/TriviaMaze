package model;

public class Player {
    private Room currentRoom; // Track the current room where the player is located.
    private int correctAnswers; // Track the number of correctly answered questions.

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.correctAnswers = 0;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void move(Room newRoom) {
        // Implement a method to move the player to a new room.
        // Update the 'currentRoom' attribute.
    }

    public void answerQuestion(boolean isCorrect) {
        // Implement a method to track the player's answers.
        if (isCorrect) {
            correctAnswers++;
        }
    }

    public boolean hasWon() {
        // Implement a method to check if the player has won the game.
        // You can define the win conditions here.
        return false; // Placeholder
    }
}

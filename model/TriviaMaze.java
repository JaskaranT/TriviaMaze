package model;

import java.io.Serial;
import java.io.Serializable;

/**
 * The TriviaMaze class represents a trivia-based maze game.
 */
public class TriviaMaze implements Serializable {
    @Serial
    private static final long serialVersionUID = -5203829590803086033L;
    /**
     * The current X coordinate of the player in the maze.
     */
    private int myX;

    /**
     * The current Y coordinate of the player in the maze.
     */
    private int myY;

    /**
     * The 2D array representing rooms in the maze.
     */
    private final TriviaRoom[][] myRooms;

    /**
     * The size of the maze.
     */
    private static final int MAZE_SIZE = 4;

    /**
     * The current door that the player is facing.
     */
    private TriviaDoor myCurrentDoor;

    /**
     * Constructs a TriviaMaze and initializes the maze by generating rooms and doors.
     */
    public TriviaMaze() {
        myX = 0;
        myY = 0;
        myRooms = new TriviaRoom[MAZE_SIZE][MAZE_SIZE];
        generateMaze();
    }

    /**
     * Generates the maze by creating rooms and doors for each location.
     */
    private void generateMaze() {
        for (int x = 0; x < MAZE_SIZE; x++) {
            for (int y = 0; y < MAZE_SIZE; y++) {
                TriviaDoor north = null;
                TriviaDoor west = null;
                TriviaDoor east = new TriviaDoor();
                TriviaDoor south = new TriviaDoor();
                if (x > 0) {
                    north = myRooms[x - 1][y].getDoor("south");
                }
                if (y > 0) {
                    west = myRooms[x][y - 1].getDoor("east");
                }
                myRooms[x][y] = new TriviaRoom(x, y, north, west, south, east);
            }
        }
    }

    /**
     * Checks if the game is won by reaching the exit.
     *
     * @return true if the game is won, false otherwise.
     */
    public boolean isGameWon() {
        return myX == MAZE_SIZE - 1 && myY == MAZE_SIZE - 1;
    }

    /**
     * Sets the current door based on the given direction.
     *
     * @param theDirection The direction of the door.
     */
    public void setCurrentDoor(final String theDirection) {
        myCurrentDoor = myRooms[myX][myY].getDoor(theDirection);
    }

    /**
     * Checks if the player can move in the current direction.
     *
     * @param theDoor The door in the current direction.
     * @return true if the player can move, false otherwise.
     */
    private boolean canMove(final TriviaDoor theDoor) {
        return theDoor != null && !theDoor.isLockedForever();
    }

    /**
     * Checks if the player can move in the current direction.
     *
     * @return true if the player can move, false otherwise.
     */
    public boolean canMove() {
        return myCurrentDoor != null && !myCurrentDoor.isLockedForever();
    }

    /**
     * Checks if the current door is locked.
     *
     * @return true if the door is locked, false otherwise.
     */
    public boolean checkLocked() {
        return myCurrentDoor.isLocked();
    }

    /**
     * Checks if the current door is locked forever.
     *
     * @return true if the door is locked forever, false otherwise.
     */
    public boolean checkLockedForever() {
        return myCurrentDoor.isLockedForever();
    }

    /**
     * Gets the question of the current door.
     *
     * @return The question of the current door.
     */
    public String getDoorQuestion() {
        return myCurrentDoor.getQuestion();
    }

    /**
     * Gets the answer of the current door.
     *
     * @return The answer of the current door.
     */
    public String getDoorAnswer() {
        return myCurrentDoor.getAnswer();
    }

    /**
     * Checks the player's answer for the current door.
     *
     * @param theAnswer The player's answer.
     */
    public void checkPlayerAnswer(final String theAnswer) {
        myCurrentDoor.answer(theAnswer);
    }

    /**
     * Gets the display of the current room.
     *
     * @return The display of the current room.
     */
    public String getRoomDisplay() {
        return myRooms[myX][myY].toString();
    }

    /**
     * Moves the player in the specified direction.
     *
     * @param theDirection The direction to move the player.
     */
    public void movePlayer(final String theDirection) {
        switch (theDirection) {
            case "north" -> myX--;
            case "west" -> myY--;
            case "south" -> myX++;
            case "east" -> myY++;
        }
    }

    /**
     * Checks if there is a possible route to the exit.
     *
     * @return true if there is a possible route, false otherwise.
     */
    public boolean possibleRoute() {
        // Clear all visited rooms
        for (TriviaRoom[] rooms : myRooms) {
            for (TriviaRoom room : rooms) {
                room.markVisited(false);
            }
        }
        return move(myX, myY);
    }

    /**
     * Recursively checks for a possible route to the exit.
     *
     * @param theX The current X coordinate.
     * @param theY The current Y coordinate.
     * @return true if there is a possible route, false otherwise.
     */
    private boolean move(final int theX, final int theY) {
        boolean success = false;
        if (validMove(theX, theY)) {
            myRooms[theX][theY].markVisited(true);
            if (atExit(theX, theY)) {
                return true;
            }
            if (canMove(myRooms[theX][theY].getDoor("north"))) {
                success = move(theX - 1, theY); // North
            }
            if (!success && canMove(myRooms[theX][theY].getDoor("west"))) {
                success = move(theX, theY - 1); // West
            }
            if (!success && canMove(myRooms[theX][theY].getDoor("south"))) {
                success = move(theX + 1, theY); // East
            }
            if (!success && canMove(myRooms[theX][theY].getDoor("east"))) {
                success = move(theX, theY + 1); // South
            }
        }
        return success;
    }

    /**
     * Checks if the player is at the exit.
     *
     * @param theX The current X coordinate.
     * @param theY The current Y coordinate.
     * @return true if the player is at the exit, false otherwise.
     */
    private boolean atExit(final int theX, final int theY) {
        return theX == myRooms.length - 1 && theY == myRooms[theX].length - 1;
    }

    /**
     * Checks if the move to the specified coordinates is valid.
     *
     * @param theRow The row coordinate.
     * @param theCol The column coordinate.
     * @return true if the move is valid, false otherwise.
     */
    private boolean validMove(final int theRow, final int theCol) {
        return theRow >= 0 && theRow < MAZE_SIZE && theCol >= 0 && theCol < MAZE_SIZE
                && !(myRooms[theRow][theCol].visited());
    }

    /**
     * Overrides the default toString method to represent the current
     * state of the maze.
     *
     * @return A string representation of the TriviaMaze.
     */
    @Override
    public String toString() {
        StringBuilder triviaMaze = new StringBuilder();
        for (int i = 0; i < MAZE_SIZE; i++) {
            triviaMaze.append("\n\t\t");
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (i == 0 && j == 0 && !(myX == i && myY == j)) {
                    triviaMaze.append("|ST|");
                } else if (myX == i && myY == j) {
                    triviaMaze.append("|PL|");
                } else if (i == MAZE_SIZE - 1 && j == MAZE_SIZE - 1) {
                    triviaMaze.append("|ED|");
                } else {
                    triviaMaze.append("|RM|");
                }
            }
        }
        triviaMaze.append('\n');
        return triviaMaze.toString();
    }
}
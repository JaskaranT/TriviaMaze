package model;

import java.io.Serializable;

/**
 * @author Michael Castro
 * @author Jaskaran Toor
 * @author Tu Phan
 * @version 12/12/2023
 *
 * This is the trivia maze class that holds all logic for the maze.
 */

public class TriviaMaze implements Serializable {
    /**
     * Players x - coordinate.
     */
    private int myX;
    /**
     * Players y - coordinate.
     */
    private int myY;
    /**
     * 2d array of rooms for the maze.
     */
    private final Room[][] myRooms;
    /**
     * Constant for the size of the maze.
     */
    private static final int MY_SIZE = 4;
    /**
     * Door that holds information on current door.
     */
    private Door myCurrentDoor;

    /**
     * Constructor that builds the maze and
     * puts player at top left of maze.
     */
    public TriviaMaze() {
        myX = 0;
        myY = 0;
        myRooms = new Room [MY_SIZE][MY_SIZE];
        generateMaze();
    }

    /**
     * Generates the size and layout of the maze.
     */
    public void generateMaze() {

        for (int x = 0; x < myRooms.length; x++) {
            for (int y = 0; y < myRooms[x].length; y++) {
                Door north = null;
                Door west = null;
                Door east = new Door();
                Door south = new Door();
                if (x > 0) {
                    north = myRooms[x - 1][y].getDoor("south");
                }
                if (y > 0) {
                    west = myRooms[x][y - 1].getDoor("east");
                }
                myRooms[x][y] = new Room(x, y, north, west, south, east);
            }
        }
    }

    public Room[][] getMaze() {
        return myRooms;
    }

    /**
     * Checks if user is at the end of the maze.
     * @return user location.
     */
    public boolean isGameWon() {
        return myX == MY_SIZE - 1 && myY == MY_SIZE - 1;
    }

    /**
     * Sets the current door the player is at.
     * @param theDirection
     */
    public void setCurrentDoor(final String theDirection) {
        myCurrentDoor = myRooms[myX][myY].getDoor(theDirection);
    }

    /**
     * checks if user can move to the desired direction.
     * @param theDoor
     * @return boolean theDoor
     */
    private boolean canMove(final Door theDoor) {
        return theDoor != null && !theDoor.isLockedForever();
    }

    /**
     * checks if user can move in the desired direction
     * @return boolean myCurrentDoor
     */
    public boolean canMove() {
        return myCurrentDoor != null && !myCurrentDoor.isLockedForever();
    }

    /**
     * Checks if current door is locked
     * @return boolean
     */
    public boolean checkLocked() {
        return myCurrentDoor.isLocked();
    }

    /**
     * Checks if current door is locked forever.
     * @return boolean
     */
    public boolean checkLockedForever() {
        return myCurrentDoor.isLockedForever();
    }

    /**
     * Gets the question at the current door.
     * @return String quesiton.
     */
    public String getDoorQuestion() {
        return myCurrentDoor.getQuestion();
    }

    /**
     * Gets the answer at the current door.
     * @return String answer
     */
    public String getDoorAnswer() {
        return myCurrentDoor.getAnswer();
    }

    /**
     * Compares the users answer with the correct answer
     * @param theAnswer
     */
    public void checkPlayerAnswer(String theAnswer) {
        myCurrentDoor.answer(theAnswer);
    }

    /**
     * Displays the room and all 4 doors in the room.
     * @return String
     */
    public String getRoomDisplay() {
        return myRooms[myX][myY].toString();
    }

    /**
     * gets the players x and y coordinates.
     * @return array of players x and y.
     */
    public int[] getLocation() {
        int[] location = {myX, myY};
                return location;
    }

    /**
     * Sets the user location.
     * @param theX
     * @param theY
     */
    public void setLocation(int theX, int theY){
        myY = theY;
        myX = theX;
    }

    /**
     * Moves the players x and y coordinates based on the users
     * input.
     * @param theDirection
     */
    public void MovePlayer (final String theDirection) {
        switch (theDirection) {
            case "north" -> myX--;
            case "west" -> myY--;
            case "south" -> myX++;
            case "east" -> myY++;
        }
    }

    /**
     * Checks if there is a possible route remaining
     * to the end of the maze.
     * @return boolean
     */
    public boolean possibleRoute() {
        //clear all visited rooms
        for (Room[] rooms : myRooms) {
            for (Room room : rooms) {
                room.markVisited(false);
            }
        }
        return move(myX, myY);

    }

    /**
     * Recursive method that takes players coordinates and
     * checks if the players desired direction is valid.
     * @param theX
     * @param theY
     * @return boolean
     */
    private boolean move(final int theX, final int theY) {
        boolean success = false;
        if (validMove(theX, theY)) {
            myRooms[theX][theY].markVisited(true);
            if (atExit(theX, theY)) {
                return true;
            }
            if (canMove(myRooms[theX][theY].getDoor("north"))) {
                success = move(theX - 1, theY); //North
            }
            if (!success && canMove(myRooms[theX][theY].getDoor("west"))) {
                success = move(theX, theY - 1); //West
            }
            if (!success && canMove(myRooms[theX][theY].getDoor("south"))) {
                success = move(theX + 1, theY); //East
            }
            if (!success && canMove(myRooms[theX][theY].getDoor("east"))) {
                success = move(theX, theY + 1); //south
            }
        }
        return success;
    }

    /**
     * Checks if player has won the game.
     * @param theX
     * @param theY
     * @return boolean
     */
    private boolean atExit(final int theX, final int theY) {
        return theX == myRooms.length - 1 && theY == myRooms[theX].length - 1;
    }

    /**
     * Checks if the players move is valid and in bounds of the maze size.
     * @param theRow
     * @param theCol
     * @return boolean
     */
    private boolean validMove(final int theRow, final int theCol) {
        return theRow >= 0 && theRow < 4 && theCol >= 0 && theCol < 4 && !(myRooms[theRow][theCol].visited());
    }

    /**
     * ToString method that outputs the contents of the maze.
     * @return String
     */
    public String toString() {
        StringBuilder triviaMaze = new StringBuilder();
        for (int i = 0; i < myRooms.length; i++) {
            triviaMaze.append("\n\t\t");
            for (int j = 0; j < myRooms[0].length; j++) {
                if ((i == 0 && j == 0) && !(myX == i && myY == j)) {
                    triviaMaze.append("|ST|");
                }
                else if (myX == i && myY == j) {
                    triviaMaze.append("|PL|");
                }
                else if (i == myRooms.length - 1 && j == myRooms[0].length - 1) {
                    triviaMaze.append("|ED|");
                }
                else {
                    triviaMaze.append("|RM|");
                }
            }
        }
        triviaMaze.append("\n");
        return triviaMaze.toString();
    }
}
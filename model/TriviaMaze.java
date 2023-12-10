package model;

import java.awt.*;
import java.util.Scanner;

public class TriviaMaze {

    private Room[][] myRooms;

    private Player myPlayer;

    private static final int MY_SIZE = 4;

    private final Scanner input = new Scanner(System.in);

    public TriviaMaze() {
        myRooms = new Room[MY_SIZE][MY_SIZE];
        myPlayer = new Player();
    }

    private void buildMaze() {
        // Create rooms
        for (int i = 0; i < myRooms.length; i++) {
            for(int j = 0; j < myRooms[i].length; j++) {
                myRooms[i][j] = new Room();
            }
        }


        for(int i = 0; i < myRooms.length; i++) {
            myRooms[0][i].getDoor("north").setWall(true);
            myRooms[i][0].getDoor("west").setWall(true);
            myRooms[myRooms.length-1][i].getDoor("south").setWall(true);
            myRooms[i][myRooms[0].length-1].getDoor("east").setWall(true);
        }

        for(int i = 0; i < myRooms.length; i++) {
            for(int j = 0; j < myRooms.length - 1; j++) {
                myRooms[j+1][i].setNorth(myRooms[j][i].getDoor("south"));
                myRooms[i][j].setEast(myRooms[i][j+1].getDoor("west"));
            }
        }
    }

    public void movePlayer(final String theDirection) {
        if(theDirection.toLowerCase().equals("north")) {
            myPlayer.moveNorth();
        }
        else if(theDirection.toLowerCase().equals("south")) {
            myPlayer.moveSouth();
        }
        else if(theDirection.toLowerCase().equals("west")) {
            myPlayer.moveWest();
        }
        else if(theDirection.toLowerCase().equals("east")) {
            myPlayer.moveEast();
        }
    }
    public boolean move(final String theDirection) {
        boolean movable = false;
        final Room currentRoom = getCurrentRoom();
        final Door currentDoor = currentRoom.getDoor(theDirection);

        // Check if there is a wall in the direction
        if (currentDoor.getWall()) {
            System.out.println("Oops! You hit a wall.");
            return false;
        }

        // When the door is not locked or the question has not been answered
        if (!currentDoor.isDoorLocked()|| !currentDoor.getAnswered()) {
            System.out.println(currentDoor.getQuestion());
            final String answer = input.nextLine();
            final boolean result = currentDoor.getQuestion().checkAnswer(answer);

            // If the question has been answered correctly
            if (result) {
                movable = true;
                currentDoor.setDoorLocked(false);
                currentDoor.setQuestionAnswered(true);
                System.out.println("You got it!");
                movePlayer(theDirection);
            } else {
                // Lock the door if the question has been answered incorrectly
                currentDoor.setDoorLocked(true);
                currentDoor.setMyForeverLocked(true);
                System.out.println("Oops! The " + theDirection + " door has been locked!");
            }
        } else if (currentDoor.isDoorLocked() && currentDoor.getAnswered()) {
            // If the door is locked and the question has been answered
            System.out.println("Oops! The " + theDirection + " door is locked!");
        } else if (!currentDoor.isDoorLocked() && currentDoor.getAnswered()) {
            // If the door is open and the question has been answered
            movable = true;
            System.out.println("Moving " + theDirection);
            movePlayer(theDirection);
        }

        return movable;
    }


    public int[] getLocation() {
        int [] arr = {myPlayer.getX(), myPlayer.getY()};
        return arr;
    }

    public void setLocation(final int theX, final int theY) {
        myPlayer.setX(theX);
        myPlayer.setY(theY);
    }

    public Room getCurrentRoom() {
        return myRooms[myPlayer.getX()][myPlayer.getY()];
    }
    public boolean endPossible(int theRow, int theColumn) {
        boolean result = false;
        if (theRow == myRooms.length - 1 && theColumn == myRooms[0].length - 1) {
            return true;
        }
        if (myRooms[theRow][theColumn].isVisited()) {
            return false;
        }

        myRooms[theRow][theColumn].setMyVisited(true);

        result = canEnterRoom("north", theRow, theColumn) && endPossible(theRow - 1, theColumn);
        if(!result) {
            result = canEnterRoom("south", theRow, theColumn)
                    && endPossible(theRow + 1, theColumn);
        }
        if(!result) {
            result = canEnterRoom("west", theRow, theColumn)
                    && endPossible(theRow, theColumn - 1);
        }
        if(!result) {
            result = canEnterRoom("east", theRow, theColumn)
                    && endPossible(theRow, theColumn + 1);
        }
        return result;
    }


    public boolean canEnterRoom(String theDoor, int theRow, int theColumn) {
        Room currentRoom = myRooms[theRow][theColumn];
        return !currentRoom.getDoor(theDoor).getWall()
                && !currentRoom.getDoor(theDoor).isDoorLocked();
    }


    public boolean isPath() {
        boolean result = endPossible(myPlayer.getX(),myPlayer.getY());

        for(int i = 0; i < myRooms.length; i++) {
            for(int j = 0; j < myRooms.length; j++) {
                myRooms[i][j].setMyVisited(false);
            }
        }
        return result;
    }

    public boolean isGameWon() {
        return myPlayer.getX() == MY_SIZE - 1 && myPlayer.getY() == MY_SIZE - 1;
    }

    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        for (int i = 0; i < myRooms.length; i++) {
            mazeString.append("\n");
            // Loop through all elements of current row
            for (int j = 0; j < myRooms[i].length; j++) {
                if (i == myPlayer.getX() && j == myPlayer.getY()) {
                    mazeString.append("[PLYR]");
                } else if (i == MY_SIZE - 1 && j == MY_SIZE - 1) {
                    mazeString.append("[FNSH]");
                } else if (i == 0 && j == 0) {
                    mazeString.append("[STRT]");
                } else {
                    mazeString.append("[ROOM]");

                }
            }
        }
        return mazeString.toString();
    }
/**
    public void undeadAllRooms() {
        for (Room[] rooms : myRooms) {
            for (Room room : rooms) {
                room.undeadRoom();
            }
        }
    }**/

}




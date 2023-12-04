package model;

import java.io.Serializable;

public class TriviaMaze implements Serializable {
    private int myX;

    private int myY;

    private final Room[][] myRooms;

    private static final int MY_SIZE = 4;


    public TriviaMaze() {
        myX = 0;
        myY = 0;
        myRooms = new Room [MY_SIZE][MY_SIZE];
        generateMaze();
    }

    private void generateMaze() {

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

    public boolean isGameWon() {
        return myX == MY_SIZE - 1 && myY == MY_SIZE - 1;
    }


    public Room getRoomLocation() {
        return myRooms[myX][myY];
    }

    public boolean canMove(Door theDoor) {
        return theDoor != null && !theDoor.isLockedForever();
    }

    public void MovePlayer (String theDirection) {
        switch (theDirection) {
            case "north" -> myX--;
            case "west" -> myY--;
            case "south" -> myX++;
            case "east" -> myY++;
        }
    }

    public boolean possibleRoute() {
        //clear all visited rooms
        for (Room[] rooms : myRooms) {
            for (Room room : rooms) {
                room.markVisited(false);
            }
        }
        return move(myX, myY);

    }
    private boolean move(int theX, int theY) {
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
    private boolean atExit(int theX, int theY) {
        return theX == myRooms.length - 1 && theY == myRooms[theX].length - 1;
    }

    private boolean validMove(int theRow, int theCol) {
        return theRow >= 0 && theRow < 4 && theCol >= 0 && theCol < 4 && !(myRooms[theRow][theCol].visited());
    }

    public String toString() {
        StringBuilder triviaMaze = new StringBuilder();
        for (int i = 0; i < myRooms.length; i++) {
            triviaMaze.append("\n");
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
        triviaMaze.append("\n\n");
        return triviaMaze.toString();
    }
}

package model;

import java.awt.*;

public class TriviaMaze {

    private Room[][] myRooms;

    private Player myPlayer;

    private  int myLastRow;
    private int myLastColumn;

    private Room myCurrentRoom;

    private boolean myGameActive;



    public TriviaMaze() {
        myRooms= new Room[4][4];
        myPlayer = new Player();

        buildMaze();
    }

    public void buildMaze() {
        for (int i = 0; i < myRooms.length; i++) {
            for(int j = 0; j < myRooms[0].length; j++) {
                myRooms[i][j] = new Room();
            }
        }
    }

    public void moveUser(final String theDirection) {
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


    public int getMyEndRow() {
        return myLastRow;
    }

    /**
     * Getter for the column of the final room
     * @return the end column
     */
    public int getMyEndColumn() {
        return myLastColumn;
    }

    public Room getMyCurrentRoom() {
        return myCurrentRoom;
    }

    public void Start() {
        myGameActive = true;
    }










}



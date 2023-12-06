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


    public boolean isPath() {
        boolean result = endPossible(myUser.getX(),myUser.getY());

        for(int i = 0; i < myMaze.length; i++) {
            for(int j = 0; j < myMaze.length; j++) {
                myMaze[i][j].setVisited(false);
            }
        }
        return result;
    }

    /**
     * Tells user if game is won.
     *
     * @return true if game is won, false otherwise.
     */
    public boolean isGameWon() {
        return myUser.getX() == myMaze.length-1 && myUser.getY() == myMaze[0].length-1;
    }
}

    public Room[][] getMaze() {
        return myMaze;
    }

    /**
     * Recursive method checks if there is a path to the end of the maze.
     *
     * @param theRow the row position of the user
     * @param theColumn the column position of the user
     * @return true if path exists, false otherwise
     */
    public boolean endPossible(int theRow, int theColumn) {
        boolean result = false;
        if (theRow == myMaze.length - 1 && theColumn == myMaze[0].length - 1) {
            return true;
        }
        if (myMaze[theRow][theColumn].getVisited()) {
            return false;
        }

        myMaze[theRow][theColumn].setVisited(true);

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

    /**
     * Determines if a room can be entered.
     *
     * @param theDoor the door which the user travles through.
     * @param theRow the x position in the maze.
     * @param theColumn the y position in the maze.
     * @return true if the user can enter a room and false otherwise.
     */
    public boolean canEnterRoom(String theDoor, int theRow, int theColumn) {
        Room currentRoom = myMaze[theRow][theColumn];
        return !currentRoom.getDoor(theDoor).getWall()
                && !currentRoom.getDoor(theDoor).getDoorLocked();
    }

    /**
     * Tells user if there is a path to the end.
     *
     * @return true if there is a path and false otherwise.
     */
    public boolean isPath() {
        boolean result = endPossible(myUser.getX(),myUser.getY());

        for(int i = 0; i < myMaze.length; i++) {
            for(int j = 0; j < myMaze.length; j++) {
                myMaze[i][j].setVisited(false);
            }
        }
        return result;
    }

    /**
     * Tells user if game is won.
     *
     * @return true if game is won, false otherwise.
     */
    public boolean isGameWon() {
        return myUser.getX() == myMaze.length-1 && myUser.getY() == myMaze[0].length-1;
    }
}








}



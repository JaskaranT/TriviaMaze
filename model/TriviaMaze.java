package model;

public class TriviaMaze {
    private int myX;

    private int myY;

    private final Room[][] myRooms;

    private final int size = 4;


    public TriviaMaze() {
        myX = 0;
        myY = 0;
        myRooms = new Room [size][size];
        generateMaze();
    }

    private void generateMaze() {
        for (int x = 0; x < myRooms.length; x++) {
            for (int y = 0; y < myRooms[x].length; y++) {
                myRooms[x][y] = new Room(x, y);
            }
        }
    }

    public boolean isGameWon() {
        return myX == size - 1 && myY == size -1;
    }


    public Room getRoomLocation() {
        return myRooms[myX][myY];
    }

    public boolean checkVisited(String theDirection) {
        int row = myX;
        int col = myY;
        switch (theDirection) {
            case "north" -> row--;
            case "west" -> col--;
            case "south" -> row++;
            case "east" -> col++;
        }
        return myRooms[row][col].visited();
    }

    public boolean canMove(int theDirection) {
        Door current = getRoomLocation().getDoor(theDirection);
        return current != null && !current.isLockedForever();
    }

    public void MovePlayer (String theDirection) {
        switch (theDirection) {
            case "north" -> myX--;
            case "west" -> myY--;
            case "south" -> myX++;
            case "east" -> myY++;
        }
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
        triviaMaze.append("\n");
        return triviaMaze.toString();
    }
}

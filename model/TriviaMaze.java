package model;

public class TriviaMaze {
    private int myX;

    private int myY;

    private Room[][] myRooms;

    private int size = 4;


    public TriviaMaze() {
        myX = 0;
        myY = 0;
        myRooms = new Room [size][size];
        generateMaze();
    }

    //Room class still needs to be finished to create a rooms with questions.
    public void generateMaze() {
        for (int x = 0; x < myRooms.length; x++) {
            for (int y = 0; y < myRooms[x].length; y++) {
                myRooms[x][y] = new Room();
            }
        }
    }

    public boolean isGameWon() {
        return myX == size - 1 && myY == size -1;
    }

    public Room getRoomLocation() {
        return myRooms[myX][myY];
    }

    public String toString() {
        StringBuilder triviaMaze = new StringBuilder();
        for (int i = 0; i < myRooms.length; i++) {
            triviaMaze.append("\n");
            for (int j = 0; j < myRooms[0].length; j++) {
                if (i == 0 && j == 0 ) {
                    triviaMaze.append("|ST|");
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

package model;

public class Room {

    private final Door[] myDoors;

    private boolean myHasVisited;

    private static int myDirection;

    private static final int MY_NORTH = 0;

    private static final int MY_WEST = 1;

    private static final int MY_SOUTH = 2;

    private static final int MY_EAST = 3;

// This will Iterate through the 2d array adding doors to the proper locations
    public Room(int theRow, int theCol) {
        myHasVisited = false;
        int MY_TOTAL_SIDES = 4;
        myDoors = new Door [MY_TOTAL_SIDES];
        if ((theRow >= 0 && theRow < myDoors.length) && theCol < myDoors.length - 1) {
            myDoors[MY_EAST] = new Door();
        }
        if ((theCol >= 0 && theCol < myDoors.length) && theRow < myDoors.length - 1) {
            myDoors[MY_SOUTH] = new Door();
        }
        if ((theCol > 0 && theCol < myDoors.length) && theRow < myDoors.length) {
            myDoors[MY_WEST] = new Door();
        }
        if ((theRow > 0 && theRow < myDoors.length) && theCol < myDoors.length) {
            myDoors[MY_NORTH] = new Door();
        }
    }

    public Door getDoor(String theDirection) {
        switch (theDirection.toLowerCase()) {
            case "north" -> myDirection = MY_NORTH;
            case "west" -> myDirection = MY_WEST;
            case "south" -> myDirection = MY_SOUTH;
            case "east" -> myDirection = MY_EAST;
        }

        return myDoors[myDirection];
    }

    public boolean visited() {
        return myHasVisited;
    }

    public void setVisited () {
        myHasVisited = true;
    }
    public String toString() {
        return null;
    }
}

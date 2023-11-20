package model;

public class Room {

    private final Door[] myDoors;

    private boolean myHasVisited;

    private static final int MY_NORTH = 0;

    private static final int MY_WEST = 1;

    private static final int MY_SOUTH = 2;

    private static final int MY_EAST = 3;


    public Room(int theX, int theY) {
        myHasVisited = false;
        int MY_TOTAL_SIDES = 4;
        myDoors = new Door [MY_TOTAL_SIDES];
        if ((theX >= 0 && theX < myDoors.length ) && theY < myDoors.length) {
            myDoors[MY_EAST] = new Door();
        }
        if ((theY >= 0 && theY < myDoors.length) && theX < myDoors.length) {
            myDoors[MY_SOUTH] = new Door();
        }
        if ((theY > 0 && theY < myDoors.length) && theX < myDoors.length) {
            myDoors[MY_WEST] = new Door();
        }
        if ((theX > 0 && theX < myDoors.length) && theY < myDoors.length) {
            myDoors[MY_NORTH] = new Door();
        }
    }

    public Door getDoor(int theDirection) {
        return myDoors[theDirection];
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

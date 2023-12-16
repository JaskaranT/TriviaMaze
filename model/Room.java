package model;

import java.io.Serializable;

/**
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/12/2023
 *
 * This is the room class that holds 4 doors per room
 */

public class Room implements Serializable {
    /**
     * Array of the 4 doors in the room.
     */
    private final Door[] myDoors;
    /**
     * boolean to see if player has visited the room.
     */
    private boolean myHasVisited;
    /**
     * Value for all 4 doors
     */
    private int myDirection;

    /**
     * Constant for North door.
     */
    private static final int MY_NORTH = 0;
    /**
     * Constant for West door.
     */
    private static final int MY_WEST = 1;
    /**
     * Constant for South door.
     */
    private static final int MY_SOUTH = 2;
    /**
     * Constant for East door.
     */
    private static final int MY_EAST = 3;

    /**
     * Constructor that adds all 4 doors in the
     * rooms at the proper locations.
     * @param theRow
     * @param theCol
     * @param theNorth
     * @param theWest
     * @param theSouth
     * @param theEast
     */
    public Room(final int theRow, final int theCol, final Door theNorth, final Door theWest,
                final Door theSouth, final Door theEast) {
        myHasVisited = false;
        int MY_TOTAL_SIDES = 4;
        myDoors = new Door [MY_TOTAL_SIDES];
        if ((theRow >= 0 && theRow < myDoors.length) && theCol < myDoors.length - 1) {
            myDoors[MY_EAST] = theEast;
        }
        if ((theCol >= 0 && theCol < myDoors.length) && theRow < myDoors.length - 1) {
            myDoors[MY_SOUTH] = theSouth;
        }
        if ((theCol > 0 && theCol < myDoors.length) && theRow < myDoors.length) {
            myDoors[MY_WEST] = theWest;
        }
        if ((theRow > 0 && theRow < myDoors.length) && theCol < myDoors.length) {
            myDoors[MY_NORTH] = theNorth;
        }
    }

    /**
     * gets the users input for the door and assigns it to the corresponding
     * value for that door.
     * @param theDirection
     * @return Door
     */
    public Door getDoor(final String theDirection) {
        switch (theDirection.toLowerCase()) {
            case "north" -> myDirection = MY_NORTH;
            case "west" -> myDirection = MY_WEST;
            case "south" -> myDirection = MY_SOUTH;
            case "east" -> myDirection = MY_EAST;
        }

        return myDoors[myDirection];
    }

    /**
     * Checks if user has visited the room.
     * @return boolean
     */
    public boolean visited() {
        return myHasVisited;
    }

    /**
     * Sets the value for if the room has been visited.
     * @param theVisit
     */
    public void markVisited (final boolean theVisit) {
        myHasVisited = theVisit;
    }

    /**
     * toString representation of the current room that displays information
     * of all 4 doors in the room.
     * @return String
     */
    public String toString(){
        String[] door = new String[4];
        for (int i = 0; i < myDoors.length; i++) {
            if ((myDoors[i] == null)) {
                door[i] = "XX";
            } else if (myDoors[i].isLocked() && !(myDoors[i].isLockedForever())) {
                door[i] = "LK";
            } else if (myDoors[i].isLockedForever()) {
                door[i] = "XX";
            } else {
                door[i] = "OP";
            }
        }
        return String.format("""
                             ROOM
                ______________________________
                            (NORTH)
                             ____
                             |%s|
                        ____ ---- ____
                (WEST)  |%s|  PL  |%s|  (EAST)
                        ---- ____ ----
                             |%s|
                             ----
                            (SOUTH)
                ------------------------------
                """, door[0], door[1], door[3],door[2]);
    }
}
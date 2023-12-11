package model;

import java.io.Serializable;

public class Room implements Serializable {

    private final Door[] myDoors;

    private boolean myHasVisited;

    private int myDirection;

    private static final int MY_NORTH = 0;

    private static final int MY_WEST = 1;

    private static final int MY_SOUTH = 2;

    private static final int MY_EAST = 3;

// This will Iterate through the 2d array adding doors to the proper locations
    public Room(int theRow, int theCol, Door theNorth, Door theWest, Door theSouth, Door theEast) {
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

    public void markVisited (boolean theVisit) {
        myHasVisited = theVisit;
    }

    /*Could improve
    public String toString() {
        StringBuilder room = new StringBuilder();
      for (Door myDoor : myDoors) {
        if (myDoor == null) {
          room.append("| WALL |");
        } else if (myDoor.isLocked() && !(myDoor.isLockedForever())) {
          room.append("|LOCK|");
        } else if (myDoor.isLockedForever()) {
          room.append("|OPEN|");
        } else {
          room.append("|UNLOCK|");
        }
      }
        room.append("\n");
        return room.toString();
    }

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
                            (NORTH)
                             ____
                             |%s|
                        ____ ---- ____
                (WEST)  |%s|  PL  |%s|  (EAST)
                        ---- ____ ----
                             |%s|
                             ----
                            (SOUTH)
                                """, door[0], door[1], door[3],door[2]);
    }
}

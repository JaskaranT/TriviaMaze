/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Locale;
/**
 * The TriviaRoom class represents a room in a trivia-based game with
 * doors in four directions.
 *
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/15/2023
 */
public class TriviaRoom implements Serializable {

    @Serial
    private static final long serialVersionUID = 3618247385774783411L;

    /**
     * Array of TriviaDoors representing doors in the north, west,
     * south, and east directions.
     */
    private final TriviaDoor[] myDoors;

    /**
     * A boolean indicating whether the room has been visited.
     */
    private boolean myHasVisited;

    /**
     * A static int that hold the north location.
     */
    private static final int NORTH = 0;

    /**
     * A static int that hold the west location.
     */
    private static final int WEST = 1;

    /**
     * A static int that hold the south location.
     */
    private static final int SOUTH = 2;

    /**
     * A static int that hold the east location.
     */
    private static final int EAST = 3;

    /**
     * Constructs a TriviaRoom with doors in the specified directions.
     *
     * @param theRow   The row index of the room.
     * @param theCol   The column index of the room.
     * @param theNorth TriviaDoor representing the door in the north direction.
     * @param theWest  TriviaDoor representing the door in the west direction.
     * @param theSouth TriviaDoor representing the door in the south direction.
     * @param theEast  TriviaDoor representing the door in the east direction.
     */
    public TriviaRoom(final int theRow, final int theCol, final TriviaDoor theNorth, final TriviaDoor theWest,
                      final TriviaDoor theSouth, final TriviaDoor theEast) {
        myHasVisited = false;
        myDoors = new TriviaDoor[4];
        if (theRow >= 0 && theRow < myDoors.length && theCol < myDoors.length - 1) {
            myDoors[EAST] = theEast;
        }
        if (theCol >= 0 && theCol < myDoors.length && theRow < myDoors.length - 1) {
            myDoors[SOUTH] = theSouth;
        }
        if (theCol > 0 && theCol < myDoors.length && theRow < myDoors.length) {
            myDoors[WEST] = theWest;
        }
        if (theRow > 0 && theRow < myDoors.length && theCol < myDoors.length) {
            myDoors[NORTH] = theNorth;
        }
    }
    /**
     * Gets the TriviaDoor in the specified direction.
     *
     * @param theDirection The direction of the door (north, west, south, east).
     * @return The TriviaDoor in the specified direction.
     */
    public TriviaDoor getDoor(final String theDirection) {
        return switch (theDirection.toLowerCase(Locale.ENGLISH)) {
            case "north" -> myDoors[NORTH];
            case "west" -> myDoors[WEST];
            case "south" -> myDoors[SOUTH];
            case "east" -> myDoors[EAST];
            default -> null;
        };
    }

    /**
     * Checks if the room has been visited.
     *
     * @return true if the room has been visited, false otherwise.
     */
    public boolean visited() {
        return myHasVisited;
    }

    /**
     * Marks the room as visited or unvisited.
     *
     * @param theVisit true to mark the room as visited, false to mark
     * it as unvisited.
     */
    public void markVisited (final boolean theVisit) {
        myHasVisited = theVisit;
    }

    /**
     * Generates a string representation of the room showing the state of
     * doors in each direction.
     *
     * @return The string representation of the room.
     */
    public String toString() {
      String[] door = new String[4];
      for (int i = 0; i < myDoors.length; i++) {
        if (myDoors[i] == null) {
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

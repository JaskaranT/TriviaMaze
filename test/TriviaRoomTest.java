/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package test;

import model.TriviaDoor;
import model.TriviaRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaskaran Toor
 * @author Tu Phan
 * @author Michael Castro
 *
 * Test for room class.
 */

class TriviaRoomTest {

    private TriviaRoom room;
    private TriviaDoor northDoor, southDoor, eastDoor, westDoor;

    @BeforeEach
    void setUp() {
        // Initialize doors
        northDoor = new TriviaDoor();
        southDoor = new TriviaDoor();
        eastDoor = new TriviaDoor();
        westDoor = new TriviaDoor();

        // Create a room with doors on all sides
        room = new TriviaRoom(1, 1, northDoor, westDoor, southDoor, eastDoor);
    }

    @Test
    void testDoorAssignment() {
        assertSame(northDoor, room.getDoor("north"));
        assertSame(southDoor, room.getDoor("south"));
        assertSame(eastDoor, room.getDoor("east"));
        assertSame(westDoor, room.getDoor("west"));
    }

    @Test
    void testInitialVisitedStatus() {
        assertFalse(room.visited());
    }

    @Test
    void testMarkVisited() {
        room.markVisited(true);
        assertTrue(room.visited());
    }

    @Test
    void testToString() {
        String roomString = room.toString();
        assertNotNull(roomString);

    }
}
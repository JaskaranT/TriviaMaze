package Tests;

import model.Door;
import model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room;
    private Door northDoor, southDoor, eastDoor, westDoor;

    @BeforeEach
    void setUp() {
        // Initialize doors
        northDoor = new Door();
        southDoor = new Door();
        eastDoor = new Door();
        westDoor = new Door();

        // Create a room with doors on all sides
        room = new Room(1, 1, northDoor, westDoor, southDoor, eastDoor);
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

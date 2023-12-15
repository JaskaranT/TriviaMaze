package Tests;

import model.Door;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    private Door door;

    @BeforeEach
    void setUp() {
        door = new Door();
    }

    @Test
    void testInitialLockState() {
        assertTrue(door.isLocked());
        assertFalse(door.isLockedForever());
    }

    @Test
    void testUnlockDoor() {

        String correctAnswer = door.getAnswer();
        door.answer(correctAnswer);
        assertFalse(door.isLocked());
    }

    @Test
    void testLockDoorForever() {
        door.answer("wrong answer");
        assertTrue(door.isLockedForever());
    }

}

package test;

import model.TriviaDoor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriviaDoorTest {

    private TriviaDoor door;

    @BeforeEach
    void setUp() {
        door = new TriviaDoor();
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
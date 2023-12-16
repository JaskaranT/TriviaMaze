package Tests;

import model.Door;
import model.Questions.Question_Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaskaran Toor
 * @author Tu Phan
 * @author Michael Castro
 *
 * Test for door.
 */

class DoorTest {

    private Door door;

    private Question_Answer question_answer;

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

    @Test
    void setLockForever() {
        door.setMyDoorLockForever(true);
        assertTrue(door.isLockedForever());
    }


}

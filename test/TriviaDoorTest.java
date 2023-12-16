/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package test;

import model.TriviaDoor;
import model.question.AbstractQuestionAnswer;
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

class TriviaDoorTest {

    private TriviaDoor door;

    private AbstractQuestionAnswer question_answer;

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

    @Test
    void setLockForever() {
        door.setMyDoorLockForever(true);
        assertTrue(door.isLockedForever());
    }


}
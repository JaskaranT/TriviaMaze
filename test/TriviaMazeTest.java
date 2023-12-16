package test;

import model.TriviaMaze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriviaMazeTest {

    private TriviaMaze triviaMaze;

    @BeforeEach
    void setUp() {
        triviaMaze = new TriviaMaze();
    }

    @Test
    void testIsGameWonInitially() {
        assertFalse(triviaMaze.isGameWon());
    }

    @Test
    void testMovePlayer() {
        triviaMaze.movePlayer("south");

        assertNotEquals("|PL|", triviaMaze.getRoomDisplay());
    }

    @Test
    void testSetCurrentDoor() {
        triviaMaze.setCurrentDoor("east");
        assertNotNull(triviaMaze.getDoorQuestion());
        assertNotNull(triviaMaze.getDoorAnswer());
    }

    @Test
    void testCheckPlayerAnswer() {
        triviaMaze.setCurrentDoor("east");
        String correctAnswer = triviaMaze.getDoorAnswer();
        triviaMaze.checkPlayerAnswer(correctAnswer);
        assertFalse(triviaMaze.checkLocked());
    }

    @Test
    void testPossibleRoute() {
        assertTrue(triviaMaze.possibleRoute());
    }
}
package Tests;

import model.Room;
import model.TriviaMaze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaskaran Toor
 * @author Tu Phan
 * @author Michael Castro
 *
 * Test class for maze.
 */

class MazeTest {

    private TriviaMaze triviaMaze;

    private Room[][] maze;

    @BeforeEach
    void setUp() {
        triviaMaze = new TriviaMaze();
        maze = triviaMaze.getMaze();
    }

    @Test
    void testInitialPlayerPosition() {
        assertEquals(0, triviaMaze.getLocation()[0]);
        assertEquals(0, triviaMaze.getLocation()[0] );

    }

    @Test
    void testIsGameWonInitially() {
        assertFalse(triviaMaze.isGameWon());
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

    @Test
    void testMazeGeneration() {
        triviaMaze.generateMaze();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                assertNotNull(maze[i][j]);
            }
        }

    }
    @Test
    void testMoveNorth() {
        triviaMaze.MovePlayer("north");
        assertEquals(-1, triviaMaze.getLocation()[0]);
        assertEquals(0,triviaMaze.getLocation()[1]);

    }

    @Test
    void testMoveSouth() {
        triviaMaze.MovePlayer("south");
        assertEquals(1, triviaMaze.getLocation()[0]);
        assertEquals(0, triviaMaze.getLocation()[1]);
    }
    @Test
    void testMoveWest() {
        triviaMaze.MovePlayer("west");
        assertEquals(0, triviaMaze.getLocation()[0]);
        assertEquals(-1, triviaMaze.getLocation()[1]);
    }
    @Test
    void testMoveEast() {
        triviaMaze.MovePlayer("east");
        assertEquals(0, triviaMaze.getLocation()[0]);
        assertEquals(1, triviaMaze.getLocation()[1]);
    }
    @Test
    void testGameWon() {
        triviaMaze.setLocation(triviaMaze.getMaze().length - 1, triviaMaze.getMaze()[0].length - 1);
        assertEquals(true, triviaMaze.isGameWon());
    }

    @Test
    void testGameLost() {
        lockCriticalDoors(triviaMaze);

        assertEquals(true, triviaMaze.possibleRoute());
    }

    private void lockCriticalDoors(TriviaMaze maze) {

        Room[][] rooms = maze.getMaze();
        rooms[0][0].getDoor("south").setMyDoorLockForever(true); // Lock south door of (0,0)
        rooms[0][1].getDoor("east").setMyDoorLockForever(true);  // Lock east door of (0,1)

    }
}

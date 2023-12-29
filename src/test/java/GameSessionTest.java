package com.iensu.montyhall;

import java.util.List;

import org.example.Door;
import org.example.GameSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class GameSessionTest {

    public GameSessionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDoorsShouldReturnAListOfSizeNumDoors()
    {
        int numDoors = 10;
        GameSession gameSession = new GameSession(numDoors);
        List<Door> doors = gameSession.getDoors();
        assertEquals(numDoors, doors.size());
    }

    @Test
    public void modifyingADoorListShouldOnlyAffectThatInstance()
    {
        int numDoors = 10;
        GameSession gameSession = new GameSession(10);

        List<Door> modifiedDoors = gameSession.getDoors();
        List<Door> unmodifiedDoors = gameSession.getDoors();

        modifiedDoors.remove(0);
        assertEquals(numDoors, unmodifiedDoors.size());
        assertEquals(numDoors - 1, modifiedDoors.size());
    }

    @Test
    public void winningDoorIdShouldBeGTE0andLTnumDoors()
    {
        int numDoors = 10;

        int numTests = 100;
        for(int i = 0; i < numTests; i++)
        {
            GameSession s = new GameSession(numDoors);
            int id = s.getWinningDoorId();
            assertThat(id, greaterThanOrEqualTo(0));
            assertThat(id, lessThan(numDoors));
        }
    }


}
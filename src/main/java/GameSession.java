package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A Monty Hall game session, consisting of a list of {@link Door}s and the
 * winning door id.
 *
 * @author jens.ostlund
 */
public class GameSession
{
    private final List<org.example.Door> doors;
    private final int winningDoorId;

    public GameSession(int numDoors)
    {
        Random random = new Random();

        winningDoorId = random.nextInt(numDoors);

        doors = IntStream.range(0, numDoors)
                .mapToObj(id -> new org.example.Door(id))
                .collect(Collectors.toList());
    }

    public int getWinningDoorId()
    {
        return this.winningDoorId;
    }

    public List<org.example.Door> getDoors()
    {
        return new ArrayList(this.doors);
    }
}

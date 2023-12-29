package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.IntStream;

/**
 * Main Monty Hall simulation class.
 * <p>
 * Provides static methods for running simulations based on the specified
 * strategies and returning the number of winning sessions for each strategy.
 *
 * @author jens.ostlund
 */
public class MontyHall
{

    public static Map<String, Long> runSimulations(int numDoors, int iterations, Game.Strategy[] strategies)
    {
        List<org.example.GameSession> sessions = IntStream.range(0, iterations)
                .mapToObj(_i -> new org.example.GameSession(numDoors))
                .collect(toList());

        return Arrays.stream(strategies).parallel()
                .collect(
                        toMap(strategy -> strategy.toString(), strategy -> numberOfWins(sessions, strategy))
                );
    }

    public static Map<String, Long> runSimulations(int numDoors, int iterations)
    {
        return runSimulations(numDoors, iterations, org.example.Game.Strategy.values());
    }

    private static long numberOfWins(List<org.example.GameSession> sessions, org.example.Game.Strategy strategy)
    {
        return sessions.stream()
                .map(session -> new org.example.Game(session, strategy))
                .filter(game -> game.playerWon())
                .count();
    }
}
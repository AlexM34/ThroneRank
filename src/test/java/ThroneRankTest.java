import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThroneRankTest {
    private static Player PlayerA = new Player("A");
    private static Player PlayerB = new Player("B");
    private static Player PlayerC = new Player("C");
    private static Player PlayerD = new Player("D");
    private static Player PlayerE = new Player("E");
    private static Player PlayerF = new Player("F");
    private static final Map<Player, Integer> POINTS = Map.of(
            PlayerA, 14,
            PlayerB, 2,
            PlayerC, 6,
            PlayerD, 8,
            PlayerE, 4,
            PlayerF, 10
    );

    private static final Game GAME1 = new Game(POINTS);
    private static final List<Game> GAMES = new ArrayList<>(Collections.singletonList(GAME1));
    private static final List<Player> PLAYERS = Arrays.asList(PlayerA, PlayerB, PlayerC, PlayerD, PlayerE, PlayerF);

    @Test
    void updateEloAllBeginners() {
        ThroneRank.updateElo(GAME1);
        assertEquals(1570, PlayerA.getElo());
        assertEquals(1450, PlayerB.getElo());
        assertEquals(1490, PlayerC.getElo());
        assertEquals(1510, PlayerD.getElo());
        assertEquals(1470, PlayerE.getElo());
        assertEquals(1530, PlayerF.getElo());
    }

    @Test
    void getExpectedPointsSameElo() {
        assertEquals(7.0, ThroneRank.getExpectedPoints(1500, 1500));
    }

    @Test
    void getExpectedPointsHigherElo() {
        assertEquals(10.9, ThroneRank.getExpectedPoints(1700, 1500), 0.5);
    }

    @Test
    void getExpectedPointsLowerElo() {
        assertEquals(4.8, ThroneRank.getExpectedPoints(1600, 1700), 0.5);
    }
}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        assert PlayerA.getElo() == 1570;
        assert PlayerB.getElo() == 1450;
        assert PlayerC.getElo() == 1490;
        assert PlayerD.getElo() == 1510;
        assert PlayerE.getElo() == 1470;
        assert PlayerF.getElo() == 1530;
    }

}
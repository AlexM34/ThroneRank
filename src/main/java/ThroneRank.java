import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ThroneRank {
    private static final List<Game> GAMES = new ArrayList<>();
    private static final List<Player> PLAYERS = new ArrayList<>();

    public static void main(final String[] args) {
        extractGames();
        GAMES.forEach(ThroneRank::updateElo);
        printRanking();
    }

    private static void extractGames() {}

    static void updateElo(final Game game) {
        final int average = game.getAverageElo();
        for (final Map.Entry<Player, Integer> entry : game.getPoints().entrySet()) {
            final Player player = entry.getKey();
            final float points = entry.getValue();
            final double expected = getExpectedPoints(player.getElo(), average);
            player.changeElo((int) (points - expected) * 10);
        }
    }

    static double getExpectedPoints(final int elo, final int average) {
        final int averageOpponents = (average * 6 - elo) / 5;
        final double pow = Math.pow(13, (double) (averageOpponents - elo) / 400);
        return 1 + 12 / (1 + pow);
    }

    private static void printRanking() {
        PLAYERS.sort(Collections.reverseOrder(Comparator.comparingInt(Player::getElo)));
        int rank = 1;
        for (final Player player : PLAYERS) {
            System.out.println(rank++ + ". " + player.getNickname() + " " + player.getElo());
        }
    }
}

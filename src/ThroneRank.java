import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ThroneRank {
    private static final List<Game> GAMES = new ArrayList<>();
    private static final List<Player> PLAYERS = new ArrayList<>();

    public static void main(final String[] args) {
        extractGames();
        for (final Game game : GAMES) updateElo(game);
        printElo();
    }

    private static void extractGames() {}

    private static void updateElo(final Game game) {}

    private static void printElo() {
        PLAYERS.sort(Comparator.comparingInt(Player::getElo));
        int rank = 1;
        for (final Player player : PLAYERS) {
            System.out.println(rank++ + ". " + player.getNickname() + " " + player.getElo());
        }
    }
}

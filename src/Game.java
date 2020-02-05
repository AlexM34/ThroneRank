import java.util.Map;

public class Game {
    private Map<Player, Integer> points;

    public Game(final Map<Player, Integer> points) {
        this.points = points;
    }

    Map<Player, Integer> getPoints() {
        return points;
    }

    int getAverageElo() {
        int average = 0;
        for (final Player player : points.keySet()) {
            average += player.getElo();
        }

        return average / points.size();
    }
}

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Player {
    private String nickname;
    private Map<House, Performance> housePerformance;
    private int elo;

    public Player(final String nickname) {
        this.nickname = nickname;
        this.housePerformance = Arrays.stream(House.values()).collect(
                Collectors.toMap(Function.identity(), h -> new Performance()));
        this.elo = 1500;
    }

    String getNickname() {
        return nickname;
    }

    Map<House, Performance> getHousePerformance() {
        return housePerformance;
    }

    int getElo() {
        return elo;
    }
}

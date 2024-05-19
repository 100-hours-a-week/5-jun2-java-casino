package casino.domain.game;

import casino.domain.participant.Player;
import casino.domain.type.GameType;

public class Game {
    private GameType gameType;
    private Player player;

    public Game(GameType gameType, Player player) {
        this.gameType = gameType;
        this.player = player;
    }
}

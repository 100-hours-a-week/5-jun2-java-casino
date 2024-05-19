package casino.domain.game;

import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;

public class RouletteGame extends Game {
    public RouletteGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }
}

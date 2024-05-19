package casino.domain.game;

import casino.domain.game.CardGame;
import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;

public class BaccaratGame extends CardGame {
    public BaccaratGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }
}

package casino.domain.game.blackjack;

import casino.domain.game.CardGame;
import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;

public class BlackjackGame extends CardGame {
    public BlackjackGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }
}

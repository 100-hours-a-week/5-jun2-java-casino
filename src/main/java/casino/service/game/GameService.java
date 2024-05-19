package casino.service.game;

import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.domain.type.GameType;

public interface GameService {
    public Game generateGame(GameType type, Player player);
    public void playSlotMachine(Game game, Player player);
    public void playRoulette(Game game,Player player);
    public void playBlackjack(Game game,Player player);
    public void playBaccarat(Game game,Player player);
}

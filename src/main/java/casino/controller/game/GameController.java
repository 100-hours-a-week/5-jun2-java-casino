package casino.controller.game;

import casino.domain.game.Game;
import casino.domain.participant.Player;

public interface GameController {
    public void process(Game game, Player player);
}

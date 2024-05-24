package casino.controller.game.impl;

import casino.controller.game.GameController;
import casino.domain.game.Game;
import casino.domain.participant.Player;

public class BlackjackController implements GameController {

    public BlackjackController() {
    }

    @Override
    public void process(Game game, Player player) {
        System.out.println("[추후 업데이트 예정 ^~^]");
    }
}

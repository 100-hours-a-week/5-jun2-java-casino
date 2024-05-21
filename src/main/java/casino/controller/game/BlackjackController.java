package casino.controller.game;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.request.Request;
import casino.response.GameResponse;
import casino.service.casino.CasinoMainService;

public class BlackjackController implements GameController {
    private final Request request;
    private final GameResponse gameResponse;
    private final CasinoMainService casinoMainService;

    public BlackjackController(CasinoConfig casinoConfig) {
        this.request = casinoConfig.request();
        this.gameResponse = casinoConfig.gameResponse();
        this.casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process(Game game, Player player) {

    }
}

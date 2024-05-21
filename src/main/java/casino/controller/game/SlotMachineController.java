package casino.controller.game;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.dto.SlotMachineGameResultDto;
import casino.request.Request;
import casino.response.GameResponse;
import casino.service.game.GameService;

public class SlotMachineController implements GameController {
    private final Request request;
    private final GameResponse gameResponse;
    private final GameService gameService;

    public SlotMachineController(CasinoConfig casinoConfig) {
        this.request = casinoConfig.request();
        this.gameResponse = casinoConfig.gameResponse();
        this.gameService = casinoConfig.gameService();
    }

    @Override
    public void process(Game game, Player player) {
        boolean playGame = request.getSlotMachinePayment();

        if (playGame && !game.isPlay()) {
            game.changeStatus();
        }
        if (!playGame) {
            return;
        }
        while (game.isPlay()) {
            SlotMachineGameResultDto result = gameService.playSlotMachine(game, player);
            gameResponse.printSlotMachineResult(result);

            boolean retry = request.getRetryGame();
            if (retry) {
                process(game, player);
            } else {
                game.changeStatus();
                return;
            }
        }
    }
}

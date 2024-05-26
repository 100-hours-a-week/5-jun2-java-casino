package casino.controller.game.impl;

import casino.controller.game.GameController;
import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.dto.SlotMachineGameResultDto;
import casino.request.SlotMachineRequest;
import casino.response.GameResponse;
import casino.service.game.GameService;

public class SlotMachineController implements GameController {
    private final SlotMachineRequest slotMachineRequest;
    private final GameResponse gameResponse;
    private final GameService gameService;

    public SlotMachineController(SlotMachineRequest slotMachineRequest, GameResponse gameResponse, GameService gameService) {
        this.slotMachineRequest = slotMachineRequest;
        this.gameResponse = gameResponse;
        this.gameService = gameService;
    }

    @Override
    public void process(Game game, Player player) {
        boolean playGame = this.slotMachineRequest.getSlotMachinePayment();

        if (playGame && !game.isPlay()) {
            game.changeStatus();
        }
        if (!playGame) {
            return;
        }
        while (game.isPlay()) {
            SlotMachineGameResultDto result = gameService.playSlotMachine(game, player);
            gameResponse.printSlotMachineResult(result);

            boolean retry = slotMachineRequest.getRetryGame();
            if (retry) {
                process(game, player);
            } else {
                game.changeStatus();
                return;
            }
        }
    }
}

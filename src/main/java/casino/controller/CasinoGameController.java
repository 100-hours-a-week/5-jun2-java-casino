package casino.controller;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.option.GameOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.dto.SlotMachineGameResultDto;
import casino.io.game.GameInputView;
import casino.io.game.GameOutputView;
import casino.service.casino.CasinoMainService;
import casino.service.game.GameService;
import java.util.Map;

public class CasinoGameController implements Controller {
    private final GameInputView gameInputView;
    private final GameOutputView gameOutputView;
    private final CasinoMainService casinoMainService;
    private final GameService gameService;

    public CasinoGameController(CasinoConfig casinoConfig) {
        this.gameInputView = casinoConfig.gameInputView();
        this.gameOutputView = casinoConfig.gameOutputView();
        this.casinoMainService = casinoConfig.casinoMainService();
        this.gameService = casinoConfig.gameService();
    }

    @Override
    public void process() {
        GameOption gameOption;

        do {
            gameOutputView.printBlankLine();
            gameOutputView.printGameOption();
            gameOption = gameInputView.readGameOption();
            playGame(gameOption);
        } while (gameOption.isContinue());
    }

    private void playGame(GameOption gameOption) {
        Player player = (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
        Game game = gameService.generateGame(gameOption.getType(), player);
        gameOutputView.printGameGreet(gameOption.getType());

        try {
            if (gameOption == GameOption.SLOT_MACHINE) {
                playSlotMachine(game, player);
            } else if (gameOption == GameOption.ROULETTE) {
                playRoulette(game, player);
            } else if (gameOption == GameOption.BLACKJACK) {
                playBlackjack(game, player);
            } else if (gameOption == GameOption.BACCARAT) {
                playBaccarat(game, player);
            }
        } catch (Exception e) {
            gameOutputView.printException(e.getMessage());
            return;
        }
    }

    private void playSlotMachine(Game game, Player player) {
        boolean playGame = gameInputView.readSlotMachinePayment();

        if (playGame && !game.isPlay()) {
            game.changeStatus();
        }
        if (!playGame) {
            return;
        }
        while (game.isPlay()) {
            SlotMachineGameResultDto result = gameService.playSlotMachine(game, player);
            gameOutputView.printSlotMachineResult(result);

            boolean retry = gameInputView.readRetryGame();
            if (retry) {
                playSlotMachine(game, player);
            } else {
                game.changeStatus();
                return;
            }
        }
    }

    private void playRoulette(Game game, Player player) {
        Map<ChipType, Integer> betChips = gameInputView.readBetChips(GameType.ROULETTE);
        if (!game.isPlay()) {
            game.changeStatus();
        }

        while (game.isPlay()) {
            player.validateChipsToPlay(betChips);
            game.changeStatus();
        }
    }

    private void playBlackjack(Game game, Player player) {
    }

    private void playBaccarat(Game game, Player player) {

    }
}

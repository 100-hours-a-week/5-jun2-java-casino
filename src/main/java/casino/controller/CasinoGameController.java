package casino.controller;

import casino.CasinoConfig;
import casino.domain.option.GameOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.io.game.GameInputView;
import casino.io.game.GameOutputView;
import casino.service.casino.CasinoMainService;

public class CasinoGameController implements Controller {
    private final GameInputView gameInputView;
    private final GameOutputView gameOutputView;
    private final CasinoMainService casinoMainService;

    public CasinoGameController(CasinoConfig casinoConfig) {
        this.gameInputView = casinoConfig.gameInputView();
        this.gameOutputView = casinoConfig.gameOutputView();
        this.casinoMainService = casinoConfig.casinoMainService();
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

        if (gameOption == GameOption.SLOT_MACHINE) {
            playSlotMachine(player);
        } else if (gameOption == GameOption.ROULETTE) {
            playRoulette(player);
        } else if (gameOption == GameOption.BLACKJACK) {
            playBlackjack(player);
        } else if (gameOption == GameOption.BACCARAT) {
            playBaccarat(player);
        }
    }

    private void playSlotMachine(Player player) {
    }

    private void playRoulette(Player player) {
    }

    private void playBlackjack(Player player) {
    }

    private void playBaccarat(Player player) {

    }
}

package casino.controller;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.option.GameOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.io.game.GameInputView;
import casino.io.game.GameOutputView;
import casino.service.casino.CasinoMainService;
import casino.service.game.GameService;

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

        if (gameOption == GameOption.SLOT_MACHINE) {
            playSlotMachine(game, player);
        } else if (gameOption == GameOption.ROULETTE) {
            playRoulette(game, player);
        } else if (gameOption == GameOption.BLACKJACK) {
            playBlackjack(game, player);
        } else if (gameOption == GameOption.BACCARAT) {
            playBaccarat(game, player);
        }
    }

    private void playSlotMachine(Game game, Player player) {
        while (game.isPlay()) {
            gameService.playSlotMachine(game, player);
        }
    }

    private void playRoulette(Game game, Player player) {
    }

    private void playBlackjack(Game game, Player player) {
    }

    private void playBaccarat(Game game, Player player) {

    }
}

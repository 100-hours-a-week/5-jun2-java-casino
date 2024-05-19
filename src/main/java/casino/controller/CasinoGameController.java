package casino.controller;

import casino.CasinoConfig;
import casino.domain.options.ExchangeOption;
import casino.domain.options.GameOption;
import casino.io.game.GameInputView;
import casino.io.game.GameOutputView;

public class CasinoGameController implements Controller {
    private final GameInputView gameInputView;
    private final GameOutputView gameOutputView;

    public CasinoGameController(CasinoConfig casinoConfig) {
        this.gameInputView = casinoConfig.gameInputView();
        this.gameOutputView = casinoConfig.gameOutputView();
    }

    @Override
    public void process() {
        GameOption gameOption;

        do {
            gameOutputView.printBlankLine();
            gameOutputView.printGameOption();
            gameOption = gameInputView.readGameOption();
        } while (gameOption.isContinue());
    }
}

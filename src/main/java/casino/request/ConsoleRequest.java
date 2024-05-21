package casino.request;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.option.ExchangeOption;
import casino.domain.option.GameOption;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import java.util.Map;

public class ConsoleRequest implements Request {
    private final CasinoInputView casinoInputView;
    private final ExchangeInputView exchangeInputView;
    private final GameInputView gameInputView;

    public ConsoleRequest(
            CasinoInputView casinoInputView,
            ExchangeInputView exchangeInputView,
            GameInputView gameInputView
    ) {
        this.casinoInputView = casinoInputView;
        this.exchangeInputView = exchangeInputView;
        this.gameInputView = gameInputView;
    }

    // CasinoController
    @Override
    public MainOption getMainOption() {
        return casinoInputView.readMainOption();
    }

    @Override
    public Player getPlayerInfo() {
        return casinoInputView.readPlayerInfo();
    }

    // CasinoExchangeController
    @Override
    public ExchangeOption getExchangeOption() {
        return exchangeInputView.readExchangeOption();
    }

    @Override
    public Map<ChipType, Integer> getExchangeChips() {
        return exchangeInputView.readExchangeChips();
    }

    // CasinoGameController
    @Override
    public GameOption getGameOption() {
        return gameInputView.readGameOption();
    }

    // Slot Machine
    @Override
    public boolean getSlotMachinePayment() {
        return gameInputView.readSlotMachinePayment();
    }

    @Override
    public boolean getRetryGame() {
        return gameInputView.readRetryGame();
    }

    // Roulette
    @Override
    public Map<ChipType, Integer> getBetChips(GameType gameType) {
        return gameInputView.readBetChips(gameType);
    }

    @Override
    public RouletteBetType getRouletteBetType() {
        return gameInputView.readRouletteBetType();
    }

    @Override
    public int getRouletteBetNumber(RouletteBetType betType) {
        return gameInputView.readRouletteBetNumber(betType);
    }

    @Override
    public int getRouletteBetOptionNumber(RouletteBetType betType) {
        return gameInputView.readRouletteBetOptionNumber(betType);
    }
}

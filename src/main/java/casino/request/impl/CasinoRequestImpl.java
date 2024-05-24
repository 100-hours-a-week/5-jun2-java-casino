package casino.request.impl;

import casino.domain.option.ExchangeOption;
import casino.domain.option.GameOption;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.request.view.CasinoInputView;
import casino.request.CasinoRequest;
import casino.request.view.ExchangeInputView;
import casino.request.view.GameInputView;

import java.util.Map;

public class CasinoRequestImpl implements CasinoRequest {
    private final CasinoInputView casinoInputView;
    private final ExchangeInputView exchangeInputView;
    private final GameInputView gameInputView;

    public CasinoRequestImpl(
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

}





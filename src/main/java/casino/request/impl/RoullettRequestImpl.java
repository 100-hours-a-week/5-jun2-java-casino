package casino.request.impl;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.request.view.GameInputView;
import casino.request.RouletteRequest;

import java.util.Map;
public class RoullettRequestImpl implements RouletteRequest {
    private final GameInputView gameInputView;

    public RoullettRequestImpl(GameInputView gameInputView) {
        this.gameInputView = gameInputView;
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
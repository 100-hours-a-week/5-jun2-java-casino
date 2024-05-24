package casino.request;

import casino.domain.option.ExchangeOption;
import casino.domain.option.GameOption;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;

import java.util.Map;

public interface CasinoRequest {
    // CasinoController
    MainOption getMainOption();

    Player getPlayerInfo();

    // CasinoExchangeController
    ExchangeOption getExchangeOption();

    Map<ChipType, Integer> getExchangeChips();

    // CasinoGameController
    GameOption getGameOption();

}
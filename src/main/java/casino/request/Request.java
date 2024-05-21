package casino.request;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.option.ExchangeOption;
import casino.domain.option.GameOption;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import java.util.Map;

// Request <- OptionRequest + 게임별 Request 인터페이스
public interface Request {
    // CasinoController
    MainOption getMainOption();
    Player getPlayerInfo();

    // CasinoExchangeController
    ExchangeOption getExchangeOption();
    Map<ChipType, Integer> getExchangeChips();

    // CasinoGameController
    GameOption getGameOption();

    // Slot Machine
    boolean getSlotMachinePayment();
    boolean getRetryGame();

    // Roulette
    Map<ChipType, Integer> getBetChips(GameType gameType);
    RouletteBetType getRouletteBetType();
    int getRouletteBetNumber(RouletteBetType betType);
    int getRouletteBetOptionNumber(RouletteBetType betType);
}

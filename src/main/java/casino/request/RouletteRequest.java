package casino.request;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;

import java.util.Map;

public interface RouletteRequest {
    // Roulette
    Map<ChipType, Integer> getBetChips(GameType gameType);

    RouletteBetType getRouletteBetType();

    int getRouletteBetNumber(RouletteBetType betType);

    int getRouletteBetOptionNumber(RouletteBetType betType);
}

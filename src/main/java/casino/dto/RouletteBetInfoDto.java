package casino.dto;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.type.ChipType;
import java.util.Map;

public record RouletteBetInfoDto (
        RouletteBetType betType,
        int betNumber,
        int optionNumber, Map<ChipType,
        Integer> betChips
    ) {
}

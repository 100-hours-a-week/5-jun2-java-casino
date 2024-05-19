package casino.dto;

import casino.domain.type.ChipType;
import java.util.Map;

public record AccountBalanceInfoDto(long cash, Map<ChipType, Integer> chips) {
}

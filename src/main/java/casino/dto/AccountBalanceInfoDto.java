package casino.dto;

import casino.domain.casino.ChipType;
import java.util.Map;

public record AccountBalanceInfoDto(long cash, Map<ChipType, Integer> chips) {
}

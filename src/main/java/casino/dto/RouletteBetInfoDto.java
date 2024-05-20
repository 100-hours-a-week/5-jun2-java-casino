package casino.dto;

import casino.domain.game.roulette.RouletteBetType;

public record RouletteBetInfoDto(RouletteBetType betType, int betNumber, int optionNumber) {
}

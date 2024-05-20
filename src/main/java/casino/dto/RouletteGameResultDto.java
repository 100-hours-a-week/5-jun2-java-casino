package casino.dto;

import casino.domain.game.roulette.RouletteBetType;

public record RouletteGameResultDto(int winningNumber, long totalWinningAmount, RouletteBetType betType) {
}

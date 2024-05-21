package casino.domain.game.roulette;

import static casino.domain.game.roulette.RouletteBetType.COLOR_BET;
import static casino.domain.game.roulette.RouletteBetType.COLUMN_BET;
import static casino.domain.game.roulette.RouletteBetType.DOZEN_BET;
import static casino.domain.game.roulette.RouletteBetType.EVEN_ODD_NUMBER_BET;
import static casino.domain.game.roulette.RouletteBetType.FIVE_NUMBER_BET;
import static casino.domain.game.roulette.RouletteBetType.HIGH_LOW_NUMBER_BET;
import static casino.domain.game.roulette.RouletteBetType.SPLIT_BET;
import static casino.domain.game.roulette.RouletteBetType.SQUARE_BET;
import static casino.domain.game.roulette.RouletteBetType.STRAIGHT_BET;
import static casino.domain.game.roulette.RouletteBetType.STREET_BET;
import static casino.domain.game.roulette.RouletteColorType.BLACK;
import static casino.domain.game.roulette.RouletteColorType.RED;
import static casino.domain.game.roulette.RouletteColorType.findColorByNumber;

import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import java.util.Map;
import java.util.Random;

public class RouletteGame extends Game {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 36;

    public RouletteGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }

    public int generateRouletteNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER;
    }

    public RouletteGameResultDto play(RouletteBetInfoDto info, Player player) {
        RouletteBetType betType = info.betType();
        Map<ChipType, Integer> betChips = info.betChips();
        int betNumber = info.betNumber();
        int winningNumber = generateRouletteNumber();

        // 룰렛 이용료 지불
        payPlayerChips(player, betChips);

        boolean isWin = checkIsWinGame(betType, winningNumber, betNumber);
        if (isWin) {
            giveWinningAmount(player, betChips, betType);
            long totalWinningAmount = calculateWinningAmount(betChips, betType);
            return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
        }
        return playRouletteWithOption(betType, winningNumber, info, player);
    }

    private static boolean checkIsWinGame(RouletteBetType betType, int winningNumber, int betNumber) {
        boolean isWin = false;

        if (betType == STRAIGHT_BET) {
            if (winningNumber == betNumber) {
                isWin = true;
            }
        } else if (betType == SPLIT_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1) {
                isWin = true;
            }
        } else if (betType == STREET_BET) {
            if (betNumber <= winningNumber && winningNumber <= betNumber + 2) {
                isWin = true;
            }
        } else if (betType == SQUARE_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1
                    || winningNumber == betNumber + 3 || winningNumber == betNumber + 4) {
                isWin = true;
            }
        } else if (betType == FIVE_NUMBER_BET) {
            if (0 <= winningNumber && winningNumber <= 3) {
                isWin = true;
            }
        }
        return isWin;
    }

    private void payPlayerChips(Player player, Map<ChipType, Integer> betChips) {
        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue();
            player.updateChipCount(false, type, chipCount);
        }
    }

    private void giveWinningAmount(Player player, Map<ChipType, Integer> betChips, RouletteBetType betType) {
        int dividendMultipleNumber = betType.getDividendMultiple();
        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue() * dividendMultipleNumber;
            player.updateChipCount(true, type, chipCount);
        }
    }

    private long calculateWinningAmount(Map<ChipType, Integer> betChips, RouletteBetType betType) {
        int dividendMultipleNumber = betType.getDividendMultiple();
        long totalWinningAmount = 0;

        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue() * dividendMultipleNumber;
            totalWinningAmount += (long) type.getKrw() * chipCount;
        }
        return totalWinningAmount;
    }

    private RouletteGameResultDto playRouletteWithOption(
            RouletteBetType betType,
            int winningNumber,
            RouletteBetInfoDto info,
            Player player) {
        Map<ChipType, Integer> betChips = info.betChips();
        int optionNumber = info.optionNumber();
        boolean isWin = false;

        switch (betType) {
            case COLUMN_BET:
                for (int number = optionNumber; number <= 36; number += 3) {
                    if (winningNumber == number) {
                        isWin = true;
                        break;
                    }
                }
                break;
            case DOZEN_BET:
                isWin = (optionNumber == 1 && (1 <= winningNumber && winningNumber <= 12))
                        || (optionNumber == 2 && (13 <= winningNumber && winningNumber <= 24))
                        || (optionNumber == 3 && (25 <= winningNumber && winningNumber <= 36));
                break;
            case HIGH_LOW_NUMBER_BET:
                isWin = (optionNumber == 1 && (1 <= winningNumber && winningNumber <= 18))
                        || (optionNumber == 2 && (19 <= winningNumber && winningNumber <= 36));
                break;
            case EVEN_ODD_NUMBER_BET:
                isWin = (optionNumber == 1 && winningNumber % 2 == 0)
                        || (optionNumber == 2 && winningNumber % 2 != 0);
                break;
            case COLOR_BET:
                RouletteColorType colorType = findColorByNumber(winningNumber);
                isWin = (optionNumber == 1 && colorType == BLACK)
                        || (optionNumber == 2 && colorType == RED);
                break;
        }

        if (isWin) {
            giveWinningAmount(player, betChips, betType);
        }

        long totalWinningAmount = isWin ? calculateWinningAmount(betChips, betType) : 0;
        return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
    }
}

package casino.service.game;

import static casino.domain.game.roulette.RouletteBetType.*;
import static casino.domain.game.roulette.RouletteColorType.*;
import static casino.domain.type.GameStatus.*;
import static casino.domain.type.GameType.*;

import casino.domain.game.baccarat.BaccaratGame;
import casino.domain.game.blackjack.BlackjackGame;
import casino.domain.game.Game;
import casino.domain.game.roulette.RouletteBetType;
import casino.domain.game.roulette.RouletteColorType;
import casino.domain.game.roulette.RouletteGame;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import casino.dto.SlotMachineGameResultDto;
import java.util.Map;


public class GameServiceImpl implements GameService {
    private static final int SLOT_MACHINE_PRICE = 5000;

    @Override
    public Game generateGame(GameType type, Player player) {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, STOP);
        } else if (type == ROULETTE) {
            return new RouletteGame(type, player, STOP);
        } else if (type == BLACKJACK) {
            return new BlackjackGame(type, player, STOP);
        } else {
            return new BaccaratGame(type, player, STOP);
        }
    }

    @Override
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player) {
        if (player.getCashBalance() < SLOT_MACHINE_PRICE) {
            throw new IllegalStateException("[ERROR] 현금이 부족합니다. (슬롯 머신 이용료 : 5,000원)");
        }

        // 슬롯 머신 이용료 지불
        player.updateCash(false, SLOT_MACHINE_PRICE);

        SlotMachineGame slotMachineGame = (SlotMachineGame) game;
        int[] numbersResult = slotMachineGame.generateRandomNumbers();
        SlotMachineResult result = slotMachineGame.calculateWinningResult(numbersResult);

        // 당첨되었다면 당첨금 지급
        if (result != SlotMachineResult.NONE) {
            player.updateCash(true, result.getWinningAmount());
        }
        return new SlotMachineGameResultDto(result, numbersResult);
    }

    @Override
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player) {
        RouletteBetType betType = info.betType();
        Map<ChipType, Integer> betChips = info.betChips();
        RouletteGame rouletteGame = (RouletteGame) game;
        int betNumber = info.betNumber();
        int winningNumber = rouletteGame.generateRouletteNumber();

        // 룰렛 이용료 지불
        payPlayerChips(player, betChips);

        // 사실 서비스 로직이 아니라 RouletteGame 에 도메인 로직으로 넣는게 맞지 않을까?
        if (betType == STRAIGHT_BET) {
            if (winningNumber == betNumber) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount);
            }
        } else if (betType == SPLIT_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount);
            }
        } else if (betType == STREET_BET) {
            if (betNumber <= winningNumber && winningNumber <= betNumber + 2) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount);
            }
        } else if (betType == SQUARE_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1
                    || winningNumber == betNumber + 3 || winningNumber == betNumber + 4) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount);
            }
        } else if (betType == FIVE_NUMBER_BET) {
            if (winningNumber == 1 || winningNumber == 2 || winningNumber == 3 || winningNumber == 0) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount);
            }
        }
        return playRouletteWithOption(betType, winningNumber, info, player);
    }

    @Override
    public void playBlackjack(Game game, Player player) {

    }

    @Override
    public void playBaccarat(Game game, Player player) {

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

    // 하드코딩 값 수정해야 함
    private RouletteGameResultDto playRouletteWithOption(
            RouletteBetType betType,
            int winningNumber,
            RouletteBetInfoDto info,
            Player player)
    {
        Map<ChipType, Integer> betChips = info.betChips();
        int optionNumber = info.optionNumber();
        boolean isWin = false;

        if (betType == COLUMN_BET) {
            for (int number = optionNumber; number <= 36; number += 3) {
                if (winningNumber == number) {
                    giveWinningAmount(player, betChips, betType);
                    long totalWinningAmount = calculateWinningAmount(betChips, betType);
                    return new RouletteGameResultDto(winningNumber, totalWinningAmount);
                }
            }
        } else if (betType == DOZEN_BET) {
            if (optionNumber == 1) {
                if (1 <= winningNumber && winningNumber <= 12) {
                    isWin = true;
                }
            } else if (optionNumber == 2) {
                if (13 <= winningNumber && winningNumber <= 25) {
                    isWin = true;
                }
            } else if (optionNumber == 3) {
                if (25 <= winningNumber && winningNumber <= 36) {
                    isWin = true;
                }
            }
        } else if (betType == HIGH_LOW_NUMBER_BET) {
            if (optionNumber == 1) {
                if (1 <= winningNumber && winningNumber <= 18) {
                    isWin = true;
                }
            } else {
                if (19 <= winningNumber && winningNumber <= 36) {
                    isWin = true;
                }
            }
        } else if (betType == EVEN_ODD_NUMBER_BET) {
            if (optionNumber == 1) {
                if (winningNumber % 2 == 0) {
                    isWin = true;
                }
            } else {
                if (winningNumber % 2 != 0) {
                    isWin = true;
                }
            }
        } else if (betType == COLOR_BET) {
            RouletteColorType colorType = findColorByNumber(winningNumber);
            if (optionNumber == 1 && colorType == BLACK) {
                isWin = true;
            } else if (optionNumber == 2 && colorType == RED){
                isWin = true;
            }
        }
        if (isWin) {
            giveWinningAmount(player, betChips, betType);
            long totalWinningAmount = calculateWinningAmount(betChips, betType);
            return new RouletteGameResultDto(winningNumber, totalWinningAmount);
        }
        return new RouletteGameResultDto(winningNumber, 0);
    }
}

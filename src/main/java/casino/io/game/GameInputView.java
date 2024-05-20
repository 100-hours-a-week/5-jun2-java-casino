package casino.io.game;

import static casino.domain.game.roulette.RouletteBetType.*;
import static casino.io.game.GameInputMessage.*;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.option.GameOption;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.utils.Util;
import casino.utils.validator.GameInputValidator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameInputView {
    private final Scanner scanner;

    public GameInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public GameOption readGameOption() {
        try {
            String option = readLine(REQUEST_GAME_MESSAGE.getMessage());
            GameInputValidator.validateGameOption(option);
            return GameOption.from(option);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameOption();
        }
    }

    public boolean readSlotMachinePayment() {
        try {
            String acceptPayment = readLine(REQUEST_SLOT_MACHINE_PAYMENT.getMessage());
            GameInputValidator.validateSlotMachineAccept(acceptPayment);
            if (acceptPayment.equals("Y") || acceptPayment.equals("y")) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readSlotMachinePayment();
        }
    }

    public Map<ChipType, Integer> readBetChips(GameType gameType) {
        try {
            String input = readLineChips(gameType.getName());
            GameInputValidator.validateRouletteChip(input);
            List<Integer> counts = Util.splitByComma(input);
            return ChipType.generateInfoByCounts(counts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBetChips(gameType);
        }
    }

    public RouletteBetType readRouletteBetType() {
        try {
            String input = readLine(REQUEST_ROULETTE_BET_TYPE.getMessage());
            GameInputValidator.validateRouletteBetType(input);
            return from(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRouletteBetType();
        }
    }

    public boolean readRetryGame() {
        try {
            String retry = readLine(REQUEST_RETRY_GAME.getMessage());
            GameInputValidator.validateRetry(retry);
            if (retry.equals("Y") || retry.equals("y")) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readSlotMachinePayment();
        }
    }

    public int readRouletteBetNumber(RouletteBetType betType) {
        try {
            if (betType == STRAIGHT_BET) {
                String input = readLine(REQUEST_ROULETTE_ONE_NUMBER.getMessage());
                GameInputValidator.validateOneRouletteNumber(input);
                return Integer.parseInt(input);
            } else if (betType == SPLIT_BET) {
                String input = readLine(REQUEST_ROULETTE_NOT_MULTIPLY_OF_3.getMessage());
                GameInputValidator.validateNotMultiplyOfThree(input);
                return Integer.parseInt(input);
            } else if (betType == SQUARE_BET) {
                String input = readLine(REQUEST_ROULETTE_NOT_MULTIPLY_OF_3.getMessage());
                GameInputValidator.validateNotMultiplyOfThree(input);
                return Integer.parseInt(input);
            } else if (betType == STREET_BET) {
                String input = readLine(REQUEST_ROULETTE_STREET_BET.getMessage());
                GameInputValidator.validateStreetBetNumber(input);
                return Integer.parseInt(input);
            } else {
                return 1;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRouletteBetNumber(betType);
        }
    }

    public int readRouletteBetOptionNumber(RouletteBetType betType) {
        try {
            if (betType == COLUMN_BET || betType == DOZEN_BET) {
                String input = readLine(REQUEST_THREE_OPTIONS.getMessage());
                GameInputValidator.validateThreeOptionNumbers(input);
                return Integer.parseInt(input);
            } else {
                String input = readLine(REQUEST_TWO_OPTIONS.getMessage());
                GameInputValidator.validateTwoOptionNumbers(input);
                return Integer.parseInt(input);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRouletteBetOptionNumber(betType);
        }
    }

    private String readLine(String message) {
        System.out.println(message);
        System.out.print(CONSOLE_SYMBOL.getMessage());
        return scanner.nextLine();
    }

    private String readLineChips(String game) {
        System.out.printf(REQUEST_ROULETTE_CHIP.getMessage() + "\n", game);
        System.out.print(CONSOLE_SYMBOL.getMessage());
        return scanner.nextLine();
    }
}

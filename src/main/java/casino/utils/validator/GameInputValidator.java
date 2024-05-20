package casino.utils.validator;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.option.GameOption;
import casino.domain.type.ChipType;
import casino.utils.Util;
import java.util.List;

public class GameInputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final List<String> acceptOption = List.of("Y", "y", "N", "n");
    private static final int MIN_ROULETTE_NUMBER = 0;
    private static final int MAX_ROULETTE_NUMBER = 36;

    public static void validateGameOption(String option) {
        try {
            GameOption.from(option);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void validateSlotMachineAccept(String input) {
        if (!acceptOption.contains(input)) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 올바르지 않은 입력입니다. 다시 입력해주세요.\n");
        }
    }

    public static void validateRetry(String input) {
        if (!acceptOption.contains(input)) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 올바르지 않은 입력입니다. 다시 입력해주세요.\n");
        }
    }

    public static void validateRouletteChip(String input) {
        validateChipsRegex(input);
        validateChipsRange(input);
    }

    public static void validateRouletteBetType(String input) {
        validateIsNumeric(input);
        validateIsValidOption(input);
    }

    public static void validateOneRouletteNumber(String input) {
        validateIsNumeric(input);
        validateIsValidRouletteNumberRange(input);
    }

    public static void validateNotMultiplyOfThree(String input) {
        validateIsNumeric(input);
        validateIsValidRouletteNumberRange(input);
        validateIsNotMultiplyOfThree(input);
    }

    public static void validateStreetBetNumber(String input) {
        validateIsNumeric(input);
        validateIsValidRouletteNumberRange(input);
        if (Integer.parseInt(input) % 3 != 1) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 3으로 나눈 나머지가 1인 숫자 하나에 베팅해주세요.\n");
        }
    }

    private static void validateChipsRegex(String input) {
        try {
            List<Integer> splitInput = Util.splitByComma(input);
            if (splitInput.size() != ChipType.values().length) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 6개의 숫자를 쉼표(,)로 구분해서 입력해주세요. \n");
        }
    }

    private static void validateChipsRange(String input) {
        List<Integer> splitInput = Util.splitByComma(input);
        for (int count : splitInput) {
            if (count < 0) {
                throw new IllegalArgumentException(ERROR_PREFIX + " 개수는 0이상의 양수를 입력해주세요. \n");
            }
        }
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 숫자의 형식으로 입력해주세요. \n");
        }
    }

    private static void validateIsValidOption(String input) {
        int option = Integer.parseInt(input);
        if (option < 1 || option > RouletteBetType.getRouletteBetTypeSize() - 1) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 존재하지 않는 배팅 옵션입니다. \n");
        }
    }

    private static void validateIsValidRouletteNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_ROULETTE_NUMBER || number > MAX_ROULETTE_NUMBER) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 0 ~ 36 사이의 숫자를 입력해주세요.\n");
        }
    }


    private static void validateIsNotMultiplyOfThree(String input) {
        int number = Integer.parseInt(input);
        if (number % 3 == 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 3의 배수가 아닌 숫자를 입력해주세요.");
        }
    }
}

package casino.utils.validator;

import casino.domain.type.ChipType;
import casino.domain.option.ExchangeOption;
import casino.utils.Util;
import java.util.List;

public class ExchangeInputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String CHIPS_INPUT_REGEX = "\\s*\\d+\\s*(,\\s*\\d+\\s*){5}";

    public static void validateExchangeOption(String option) {
        try {
            ExchangeOption.from(option);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void validateExchangeCashToChips(String input) {
        validateChipsRegex(input);
        validateChipsRange(input);
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
}

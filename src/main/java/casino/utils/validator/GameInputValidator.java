package casino.utils.validator;

import casino.domain.option.GameOption;

public class GameInputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void validateGameOption(String option) {
        try {
            GameOption.from(option);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}

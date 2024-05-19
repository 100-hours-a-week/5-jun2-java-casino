package casino.utils.validator;

import casino.domain.option.GameOption;
import java.util.List;

public class GameInputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final List<String> acceptOption = List.of("Y", "y", "N", "n");

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
}

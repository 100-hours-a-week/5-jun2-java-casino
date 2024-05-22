package casino.utils.validator;

import casino.domain.option.MainOption;

public class CasinoInputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String NAME_REGEX = "^[가-힣a-zA-Z]{3,10}$";
    private static final int MIN_CASH = 1000;
    private static final int MAX_CASH = 1000000;

    private CasinoInputValidator() {
    }

    public static void validateMainOption(String option) {
        try {
            MainOption.from(option);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void validatePlayerName(String name) {
        validateBlankOrEmpty(name);
        validateNameRegex(name);
    }

    public static void validatePlayerCash(String cash) {
        validateBlankOrEmpty(cash);
        validateNumeric(cash);
        validateCashRange(Integer.parseInt(cash));
    }

    private static void validateBlankOrEmpty(String target) {
        // 빈 값을 입력한 경우
        if (target.isBlank() || target.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 빈 값은 입력할 수 없습니다.\n");
        }
    }

    private static void validateNameRegex(String name) {
        // 올바르지 않은 이름 형식을 입력한 경우
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 이름은 3 ~ 10자 이하의 한글 또는 영어를 입력해야 합니다.\n");
        }
    }

    private static void validateNumeric(String cash) {
        // 초기 자본이 숫자가 아닌 경우
        if (!isNumeric(cash)) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 숫자가 아닌 다른 형식은 입력할 수 없습니다.\n");
        }

        // TO-DO
        // 자본 500원 단위로 받는게 편할 것 같다?
    }

    private static void validateCashRange(int cash) {
        // 올바르지 않은 범위의 초기 자본인 경우
        if (cash < MIN_CASH || cash > MAX_CASH) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 초기 자본은 최소 1,000원 이상, 1,000,000원 이하여야 합니다.\n");
        }
    }

    private static boolean isNumeric(String target) {
        try {
            Integer.parseInt(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

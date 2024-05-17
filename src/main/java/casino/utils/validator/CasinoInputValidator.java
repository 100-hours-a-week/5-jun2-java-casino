package casino.utils.validator;

import casino.domain.options.MainOption;

public class CasinoInputValidator {
    private CasinoInputValidator() {
    }

    public static void validateMainOption(String option) {
        try {
            MainOption.from(option);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}

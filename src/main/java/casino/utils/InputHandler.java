package casino.utils;

import casino.domain.options.MainOption;
import casino.utils.validator.CasinoInputValidator;
import casino.view.casino.CasinoInputView;
import casino.view.casino.CasinoOutputView;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputHandler {
    private InputHandler() {
    }

    public static MainOption receiveValidMainOption() {
        return receiveValidatedInput(
                CasinoInputView::readMainOption,
                CasinoInputValidator::validateMainOption,
                MainOption::from
        );
    }

    private static <T> T receiveValidatedInput(
            Supplier<String> inputSupplier,
            Consumer<String> validator,
            Function<String, T> resultConverter
    ) {
        while (true) {
            try {
                String input = inputSupplier.get();
                validator.accept(input);
                return resultConverter.apply(input);
            } catch (IllegalArgumentException e) {
                CasinoOutputView.printException(e.getMessage());
            }
        }
    }
}

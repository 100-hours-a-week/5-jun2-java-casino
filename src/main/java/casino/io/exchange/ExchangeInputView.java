package casino.io.exchange;

import casino.domain.options.ExchangeOption;
import casino.domain.options.MainOption;
import casino.utils.validator.CasinoInputValidator;
import java.util.Scanner;

public class ExchangeInputView {
    private static final String REQUEST_FUNCTION_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String CONSOLE_SYMBOL = ">> ";
    private final Scanner scanner;

    public ExchangeInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ExchangeOption readExchangeOption()  {
        try {
            String option = readLine(REQUEST_FUNCTION_MESSAGE);
            CasinoInputValidator.validateMainOption(option);
            return ExchangeOption.from(option);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readExchangeOption();
        }
    }

    private String readLine(String message) {
        System.out.println(message);
        System.out.print(CONSOLE_SYMBOL);
        return scanner.nextLine();
    }
}

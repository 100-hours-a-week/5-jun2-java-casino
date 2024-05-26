package casino.request.view;

import casino.domain.type.ChipType;
import casino.domain.option.ExchangeOption;
import casino.utils.Util;
import casino.utils.validator.ExchangeInputValidator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExchangeInputView {
    private static final String REQUEST_FUNCTION_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String REQUEST_CASH_TO_CHIPS_MESSAGE = "교환하고자 하는 칩 개수를 쉼표(,)로 구분하여 입력해주세요. ex) 1, 0, 0, 2, 0, 0";
    private static final String CONSOLE_SYMBOL = ">> ";
    private final Scanner scanner;

    public ExchangeInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ExchangeOption readExchangeOption()  {
        try {
            String option = readLine(REQUEST_FUNCTION_MESSAGE);
            ExchangeInputValidator.validateExchangeOption(option);
            return ExchangeOption.from(option);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readExchangeOption();
        }
    }

    public Map<ChipType, Integer> readExchangeChips() {
        try {
            String input = readLine(REQUEST_CASH_TO_CHIPS_MESSAGE);
            ExchangeInputValidator.validateExchangeCashToChips(input);
            List<Integer> counts = Util.splitByComma(input);
            return ChipType.generateInfoByCounts(counts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readExchangeChips();
        }
    }

    private String readLine(String message) {
        System.out.println(message);
        System.out.print(CONSOLE_SYMBOL);
        return scanner.nextLine();
    }
}

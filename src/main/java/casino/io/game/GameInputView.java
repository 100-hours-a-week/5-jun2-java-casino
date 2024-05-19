package casino.io.game;

import casino.domain.options.GameOption;
import casino.utils.validator.GameInputValidator;
import java.util.Scanner;

public class GameInputView {
    private static final String REQUEST_GAME_MESSAGE = "참여를 원하는 게임을 선택하세요.";
    private static final String CONSOLE_SYMBOL = ">> ";
    private final Scanner scanner;

    public GameOption readGameOption() {
        try {
            String option = readLine(REQUEST_GAME_MESSAGE);
            GameInputValidator.validateGameOption(option);
            return GameOption.from(option);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameOption();
        }
    }

    public GameInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String readLine(String message) {
        System.out.println(message);
        System.out.print(CONSOLE_SYMBOL);
        return scanner.nextLine();
    }
}

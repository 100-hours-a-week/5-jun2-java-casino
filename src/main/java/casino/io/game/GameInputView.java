package casino.io.game;

import casino.domain.option.GameOption;
import casino.utils.validator.GameInputValidator;
import java.util.Scanner;

public class GameInputView {
    private static final String REQUEST_GAME_MESSAGE = "참여를 원하는 게임을 선택하세요.";
    private static final String REQUEST_SLOT_MACHINE_PAYMENT = "슬롯 머신 1회 결제 금액은 5,000원 입니다. 결제하시겠습니까? [Y/N]";
    private static final String REQUEST_RETRY_GAME = "다시 플레이 하시겠습니까? [Y/N]";
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

    public boolean readSlotMachinePayment() {
        try {
            String acceptPayment = readLine(REQUEST_SLOT_MACHINE_PAYMENT);
            GameInputValidator.validateSlotMachineAccept(acceptPayment);
            if (acceptPayment.equals("Y") || acceptPayment.equals("y")) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readSlotMachinePayment();
        }
    }

    public boolean readRetryGame() {
        try {
            String retry = readLine(REQUEST_RETRY_GAME);
            GameInputValidator.validateRetry(retry);
            if (retry.equals("Y") || retry.equals("y")) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readSlotMachinePayment();
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

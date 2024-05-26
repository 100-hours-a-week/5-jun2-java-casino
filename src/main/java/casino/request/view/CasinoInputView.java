package casino.request.view;

import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.utils.validator.CasinoInputValidator;
import java.util.Scanner;

public class CasinoInputView {
    private static final String REQUEST_FUNCTION_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String REQUEST_PLAYER_NAME = "플레이어 이름을 입력하세요. (10자 이하의 한글 또는 영어)";
    private static final String REQUEST_PLAYER_CASH = "플레이어 초기 자본을 입력하세요. (최소 금액 : 1,000원 ~ 최대 금액 : 1,000,000원)";
    private static final String CONSOLE_SYMBOL = ">> ";
    private final Scanner scanner;

    public CasinoInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption readMainOption()  {
        try {
            String option = readLine(REQUEST_FUNCTION_MESSAGE);
            CasinoInputValidator.validateMainOption(option);
            return MainOption.from(option);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMainOption();
        }
    }

    public Player readPlayerInfo() {
        String name = readName();
        Long cash = readCash();
        return new Player(name, RoleType.PLAYER, cash);
    }

    private String readLine(String message) {
        System.out.println(message);
        System.out.print(CONSOLE_SYMBOL);
        return scanner.nextLine();
    }

    private String readName() {
        try {
            String name = readLine(REQUEST_PLAYER_NAME);
            CasinoInputValidator.validatePlayerName(name);
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readName();
        }
    }

    private Long readCash() {
        try {
            String cash = readLine(REQUEST_PLAYER_CASH);
            CasinoInputValidator.validatePlayerCash(cash);
            return Long.parseLong(cash);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCash();
        }
    }
}

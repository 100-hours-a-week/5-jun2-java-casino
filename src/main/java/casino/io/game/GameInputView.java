package casino.io.game;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.option.GameOption;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.utils.Util;
import casino.utils.validator.GameInputValidator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameInputView {
    private static final String REQUEST_GAME_MESSAGE = "참여를 원하는 게임을 선택하세요.";
    private static final String REQUEST_SLOT_MACHINE_PAYMENT = "슬롯 머신 1회 결제 금액은 5,000원 입니다. 결제하시겠습니까? [Y/N]";
    private static final String REQUEST_ROULETTE_CHIP = "%s 게임에 베팅할 칩 개수를 쉼표(,)로 구분하여 입력해주세요. ex) 1, 0, 2, 0, 0, 0";
    private static final String REQUEST_ROULETTE_BET_TYPE = "베팅 옵션을 선택해주세요. 옵션별로 배당금이 다릅니다.";
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

    public Map<ChipType, Integer> readBetChips(GameType gameType) {
        try {
            String input = readLineChips(gameType.getName());
            GameInputValidator.validateRouletteChip(input);
            List<Integer> counts = Util.splitByComma(input);
            return ChipType.generateInfoByCounts(counts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBetChips(gameType);
        }
    }

    public RouletteBetType readRouletteBetType() {
        try {
            String input = readLine(REQUEST_ROULETTE_BET_TYPE);
            GameInputValidator.validateRouletteBetType(input);
            return RouletteBetType.from(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRouletteBetType();
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

    private String readLineChips(String game) {
        System.out.printf(REQUEST_ROULETTE_CHIP + "\n", game);
        System.out.print(CONSOLE_SYMBOL);
        return scanner.nextLine();
    }
}

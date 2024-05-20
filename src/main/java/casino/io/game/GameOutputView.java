package casino.io.game;

import static casino.domain.game.roulette.RouletteBetType.*;
import static casino.io.game.GameAsciiMessage.BACCARAT_GREET;
import static casino.io.game.GameAsciiMessage.BLACKJACK_GREET;
import static casino.io.game.GameAsciiMessage.ROULETTE_GREET;
import static casino.io.game.GameAsciiMessage.SLOT_MACHINE_GREET;
import static casino.io.game.GameAsciiMessage.STRAIGHT_DOWN;
import static casino.io.game.GameAsciiMessage.STRAIGHT_UP;

import casino.domain.game.roulette.RouletteBetType;
import casino.domain.game.roulette.RouletteColorType;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.dto.RouletteGameResultDto;
import casino.dto.SlotMachineGameResultDto;
import java.util.List;
import java.util.Map;

public class GameOutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String MIDDLE_FORMAT = "| %d |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public void printGameOption() {
        System.out.println("!! 카지노 게임장에 입장하셨습니다 !!");
        System.out.println("==================================");
        System.out.println("|          게임장 메인 화면          |");
        System.out.println("==================================");
        System.out.println("1. 슬롯 머신 (Slot Machine)");
        System.out.println("2. 룰렛 (Roulette)");
        System.out.println("3. 블랙잭 (Blackjack)");
        System.out.println("4. 바카라 (Baccarat)");
        System.out.println("Q. 나가기");
    }

    public void printGameGreet(GameType type) {
        if (type == GameType.SLOT_MACHINE) {
            System.out.println(SLOT_MACHINE_GREET.getMessage());
        } else if (type == GameType.ROULETTE) {
            System.out.println(ROULETTE_GREET.getMessage());
        } else if (type == GameType.BLACKJACK) {
            System.out.println(BLACKJACK_GREET.getMessage());
        } else if (type == GameType.BACCARAT) {
            System.out.println(BACCARAT_GREET.getMessage());
        }
    }

    public void printSlotMachineResult(SlotMachineGameResultDto dto) {
        if (dto.result() == SlotMachineResult.JACKPOT_SEVEN) {
            System.out.println(GameAsciiMessage.JACKPOT_SEVEN.getMessage());
        } else if (dto.result() == SlotMachineResult.JACKPOT) {
            System.out.println(GameAsciiMessage.JACKPOT.getMessage());
        } else if (dto.result() == SlotMachineResult.STRAIGHT_UP) {
            System.out.println(STRAIGHT_UP.getMessage());
        } else if (dto.result() == SlotMachineResult.STRAIGHT_DOWN) {
            System.out.println(STRAIGHT_DOWN.getMessage());
        }
        printNumbers(dto.numbers());
        System.out.println("[ 당첨금 ] : " + String.format("%,d", dto.result().getWinningAmount()) + " 원");
    }

    public void printPlayerChips(Map<ChipType, Integer> chips) {
        System.out.println("============================== 플레이어 보유 칩 ==============================");
        for (Map.Entry<ChipType, Integer> entry : chips.entrySet()) {
            ChipType type = entry.getKey();
            int count = entry.getValue();
            System.out.print("[" + type.name() + "]:" + count + " ");
        }
        printBlankLine();
    }

    public void printRouletteBetType() {
        List<RouletteBetType> types = List.of(values());
        System.out.println("==========================================================================");
        for (int i = 0; i < types.size() - 1; i++) {
            int typeNumber = types.get(i).getTypeNumber();
            String explanation = types.get(i).getExplanation();
            int dividendMultiple = types.get(i).getDividendMultiple();
            System.out.println("[" + typeNumber + "] " + explanation + " : [배당금] 베팅 금액의 " + dividendMultiple + " 배");
        }
        System.out.println("==========================================================================");
    }

    public void printRouletteBetOptions(RouletteBetType betType) {
        if (betType == COLUMN_BET) {
            System.out.println("[1] 1열 숫자에 베팅 (1, 4, 7, 19, 13, 16, 19, 22, 25, 28, 31, 34)");
            System.out.println("[2] 2열 숫자에 베팅 (2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35)");
            System.out.println("[3] 3열 숫자에 베팅 (3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36)");
        } else if (betType == DOZEN_BET) {
            System.out.println("[1] '1st 12' 에 베팅 (1 ~ 12 사이의 번호)");
            System.out.println("[2] '2nd 12' 에 베팅 (13 ~ 24 사이의 번호)");
            System.out.println("[3] '3rd 12' 에 베팅 (25 ~ 26 사이의 번호)");
        } else if (betType == HIGH_LOW_NUMBER_BET) {
            System.out.println("[1] Low Number 에 베팅 (1 ~ 18 사이의 번호)");
            System.out.println("[2] High Number 에 베팅 (19 ~ 36 사이의 번호)");
        } else if (betType == EVEN_ODD_NUMBER_BET) {
            System.out.println("[1] Even Number 에 베팅 (0을 제외한 모든 짝수 번호)");
            System.out.println("[2] Odd Number 에 베팅 (0을 제외한 모든 홀수 번호)");
        } else {
            System.out.println("[1] Black Number 에 베팅 (0을 제외한 모든 검정색 번호)");
            System.out.println("[2] Red Number 에 베팅 (0을 제외한 모든 빨간색 번호)");
        }
    }

    public void printRouletteGameResult(RouletteGameResultDto dto) {
        String numberColor = RouletteColorType.findColorNameByNumber(dto.winningNumber());
        RouletteBetType betType = dto.betType();
        System.out.println("[당첨 번호] : " + dto.winningNumber() + " [" + numberColor + "]");
        System.out.println("[당첨 환산 금액] : " + String.format("%,d", dto.totalWinningAmount()) + " 원 (x" + betType.getDividendMultiple() + "배)");
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printNumbers(int[] numbers) {
        int size = numbers.length;
        printTopLine(size);
        printMiddleLine(numbers);
        printBottomLine(size);
    }

    private void printTopLine(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(TOP_LINE);
        }
        printBlankLine();
    }

    private void printMiddleLine(int[] numbers) {
        for (int number : numbers) {
            System.out.printf(MIDDLE_FORMAT, number);
        }
        printBlankLine();
    }

    private void printBottomLine(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(BOTTOM_LINE);
        }
        printBlankLine();
    }
}

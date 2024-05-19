package casino.io.game;

import static casino.io.game.GameAsciiMessage.BACCARAT_GREET;
import static casino.io.game.GameAsciiMessage.BLACKJACK_GREET;
import static casino.io.game.GameAsciiMessage.ROULETTE_GREET;
import static casino.io.game.GameAsciiMessage.SLOT_MACHINE_GREET;
import static casino.io.game.GameAsciiMessage.STRAIGHT_DOWN;
import static casino.io.game.GameAsciiMessage.STRAIGHT_UP;

import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.type.GameType;
import casino.dto.SlotMachineGameResultDto;

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
        System.out.println("[ 당첨금 ] : " + dto.result().getWinningAmount() + " 원");
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
        printBlankLine();
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

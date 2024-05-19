package casino.domain.game.slotmachine;

import java.util.ArrayList;
import java.util.List;

public enum SlotMachineResult {
    // 777
    JACKPOT_SEVEN("잭팟 세븐", 10000000),

    // 모든 숫자가 같은 경우
    JACKPOT("잭팟", 1000000),

    // 오름차순으로 연속된 숫자인 경우
    STRAIGHT_UP("스트레이트 업", 500000),

    // 내림차순으로 연속된 숫자인 경우
    STRAIGHT_DOWN("스트레이트 다운", 100000),

    NONE("없음", 0);

    private final String name;
    private final long winningAmount;

    SlotMachineResult(String name, long winningAmount) {
        this.name = name;
        this.winningAmount = winningAmount;
    }

    public static SlotMachineResult calculateWinningResult(int[] resultNumbers) {
        if (isJackPotSeven(resultNumbers)) {
            return JACKPOT_SEVEN;
        }
        if (isJackPot(resultNumbers)) {
            return JACKPOT;
        }
        if (isStraightUp(resultNumbers)) {
            return STRAIGHT_UP;
        }
        if (isStraightDown(resultNumbers)) {
            return STRAIGHT_DOWN;
        }
        return NONE;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    private static boolean isJackPotSeven(int[] resultNumbers) {
        for (int i = 0; i < resultNumbers.length; i++) {
            if (resultNumbers[i] != 7) {
                return false;
            }
        }
        return true;
    }

    private static boolean isJackPot(int[] resultNumbers) {
        int firstNumber = resultNumbers[0];
        for (int i = 1; i < resultNumbers.length; i++) {
            if (firstNumber != resultNumbers[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraightUp(int[] resultNumbers) {
        for (int i = 1; i < resultNumbers.length; i++) {
            if (resultNumbers[i] != resultNumbers[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraightDown(int[] resultNumbers) {
        for (int i = 1; i < resultNumbers.length; i++) {
            if (resultNumbers[i] != resultNumbers[i - 1] - 1) {
                return false;
            }
        }
        return true;
    }
}

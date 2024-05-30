package casino.domain.participant;

import casino.domain.type.ChipType;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player extends Participant {
    private long cash;
    private boolean turnOver = false;
    private final Object lock = new Object();
    private final EnumMap<ChipType, Integer> chips = new EnumMap<>(ChipType.class);

    public Player(String name, RoleType roleType, long cash) {
        super(name, roleType);
        this.cash = cash;
        initializeChips();
    }

    public long getCashBalance() {
        return cash;
    }

    public Map<ChipType, Integer> getChipsBalance() {
        // 원본에 접근하여 변경할 수 없도록 구현해야 함 -> unmodifiable
        return Collections.unmodifiableMap(new EnumMap<>(chips));
    }

    public void updateCash(boolean isPlus, long amount) {
        if (isPlus) {
            cash += amount;
        } else {
            cash -= amount;
        }
    }

    public void updateChipCount(boolean isPlus, ChipType type, int count) {
        if (isPlus) {
            chips.replace(type, chips.get(type) + count);
        } else {
            chips.replace(type, chips.get(type) - count);
        }
    }

    public void validateChipsToPlay(Map<ChipType, Integer> betChipsInfo) {
        List<Integer> playerChips = chips.values().stream().toList();
        List<Integer> betChips = betChipsInfo.values().stream().toList();

        validateChipSize(playerChips.size(), betChips.size());
        validateBetChipCount(playerChips, betChips);
        validateChipsIsAllZero(betChips);
    }

    public boolean isTurnOver() {
        return turnOver;
    }

    public void clearCard() {
        cards.clear();
    }

    public void setTurnOver(boolean turnOver) {
        this.turnOver = turnOver;
    }

    private void initializeChips() {
        List<ChipType> types = List.of(ChipType.values());
        for (ChipType type : types) {
            chips.put(type, 0);
        }
    }

    private void validateChipSize(int playerChipSize, int betChipSize) {
        if (playerChipSize != betChipSize) {
            throw new IllegalStateException("[ERROR] 올바르지 않은 칩 갯수입니다.");
        }
    }

    private void validateBetChipCount(List<Integer> playerChips, List<Integer> betChips) {
        for (int i = 0; i < playerChips.size(); i++) {
            if (playerChips.get(i) < betChips.get(i)) {
                throw new IllegalArgumentException("[ERROR] 베팅하고자 하는 칩 갯수가 부족합니다.");
            }
        }
    }

    private void validateChipsIsAllZero(List<Integer> betChips) {
        boolean isAllZero = true;
        for (Integer betChip : betChips) {
            if (betChip != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            throw new IllegalArgumentException("[ERROR] 칩을 베팅해야 게임에 참가할 수 있습니다.");
        }
    }
}

package casino.domain.participant;

import casino.domain.casino.ChipType;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player extends Participant {
    private long cash;
    private EnumMap<ChipType, Integer> chips = new EnumMap<>(ChipType.class);

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

    public void updateChipCount(ChipType type, int count) {
        chips.replace(type, chips.get(type) + count);
    }

    private void initializeChips() {
        List<ChipType> types = List.of(ChipType.values());
        for (ChipType type : types) {
            chips.put(type, 0);
        }
    }
}

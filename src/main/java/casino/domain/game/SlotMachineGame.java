package casino.domain.game;

import casino.domain.participant.Player;
import casino.domain.type.GameType;

public class SlotMachineGame extends Game {
    public SlotMachineGame(GameType gameType, Player player) {
        super(gameType, player);
    }
}

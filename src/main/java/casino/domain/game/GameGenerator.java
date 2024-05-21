package casino.domain.game;

import static casino.domain.type.GameStatus.STOP;
import static casino.domain.type.GameType.BLACKJACK;
import static casino.domain.type.GameType.ROULETTE;
import static casino.domain.type.GameType.SLOT_MACHINE;

import casino.domain.game.blackjack.BlackjackGame;
import casino.domain.game.roulette.RouletteGame;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.participant.Player;
import casino.domain.type.GameType;

public class GameGenerator {
    private static final String NOT_EXIST_GAME = "[ERROR] 존재하지 않는 게임 종류입니다.\n";

    public static Game generateGame(GameType type, Player player) {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, STOP);
        } else if (type == ROULETTE) {
            return new RouletteGame(type, player, STOP);
        } else if (type == BLACKJACK) {
            return new BlackjackGame(type, player, STOP);
        }
        throw new IllegalArgumentException(NOT_EXIST_GAME);
    }
}

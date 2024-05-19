package casino.domain.game.slotmachine;

import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;
import java.util.Random;

public class SlotMachineGame extends Game {
    private static final int NUMBERS_SIZE = 3;

    public SlotMachineGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }

    public int[] generateRandomNumbers() {
        Random random = new Random();
        int[] randomNumbers = new int[NUMBERS_SIZE];

        for (int i = 0; i < NUMBERS_SIZE; i++) {
            randomNumbers[i] = random.nextInt(10);
        }

        return randomNumbers;
    }

    public SlotMachineResult calculateWinningResult(int[] resultNumbers) {
        return SlotMachineResult.calculateWinningResult(resultNumbers);
    }
}

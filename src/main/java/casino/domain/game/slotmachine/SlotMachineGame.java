package casino.domain.game.slotmachine;

import casino.domain.game.Game;
import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;
import casino.dto.SlotMachineGameResultDto;
import java.util.Random;

public class SlotMachineGame extends Game {
    private static final int NUMBERS_SIZE = 3;
    private static final int SLOT_MACHINE_PRICE = 5000;

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

    public SlotMachineGameResultDto play(Player player) {
        if (player.getCashBalance() < SLOT_MACHINE_PRICE) {
            throw new IllegalStateException("[ERROR] 현금이 부족합니다. (슬롯 머신 이용료 : 5,000원)");
        }

        // 슬롯 머신 이용료 지불
        player.updateCash(false, SLOT_MACHINE_PRICE);

        int[] numbersResult = generateRandomNumbers();
        SlotMachineResult result = calculateWinningResult(numbersResult);

        // 당첨되었다면 당첨금 지급
        if (result != SlotMachineResult.NONE) {
            player.updateCash(true, result.getWinningAmount());
        }
        return new SlotMachineGameResultDto(result, numbersResult);
    }
}

package casino.service.game;

import static casino.domain.type.GameStatus.*;
import static casino.domain.type.GameType.*;

import casino.domain.game.baccarat.BaccaratGame;
import casino.domain.game.blackjack.BlackjackGame;
import casino.domain.game.Game;
import casino.domain.game.roulette.RouletteBetType;
import casino.domain.game.roulette.RouletteGame;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.participant.Player;
import casino.domain.type.GameType;
import casino.dto.SlotMachineGameResultDto;


public class GameServiceImpl implements GameService {
    private static final int SLOT_MACHINE_PRICE = 5000;

    @Override
    public Game generateGame(GameType type, Player player) {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, STOP);
        } else if (type == ROULETTE) {
            return new RouletteGame(type, player, STOP);
        } else if (type == BLACKJACK) {
            return new BlackjackGame(type, player, STOP);
        } else {
            return new BaccaratGame(type, player, STOP);
        }
    }

    @Override
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player) {
        if (player.getCashBalance() < SLOT_MACHINE_PRICE) {
            throw new IllegalStateException("[ERROR] 현금이 부족합니다. (슬롯 머신 이용료 : 5,000원)");
        }

        // 슬롯 머신 이용료 지불
        player.updateCash(false, SLOT_MACHINE_PRICE);

        SlotMachineGame slotMachineGame = (SlotMachineGame) game;
        int[] numbersResult = slotMachineGame.generateRandomNumbers();
        SlotMachineResult result = slotMachineGame.calculateWinningResult(numbersResult);

        // 당첨되었다면 당첨금 지급
        if (result != SlotMachineResult.NONE) {
            player.updateCash(true, result.getWinningAmount());
        }
        return new SlotMachineGameResultDto(result, numbersResult);
    }

    @Override
    public void playRoulette(RouletteBetType betType, Game game, Player player) {

    }

    @Override
    public void playBlackjack(Game game, Player player) {

    }

    @Override
    public void playBaccarat(Game game, Player player) {

    }
}

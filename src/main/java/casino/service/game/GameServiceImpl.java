package casino.service.game;

import casino.domain.game.Game;
import casino.domain.game.roulette.RouletteGame;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.participant.Player;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import casino.dto.SlotMachineGameResultDto;

/**
 *  게임별로 서비스를 분리하여 만들고 싶었지만 과제에 비해 과한 것 같아서 하나의 서비스로 통합 (이미 클래스 40개 넘어감)
 *  -> 만약 리팩토링을 한다면 게임별로 컨트롤러, 서비스를 구분하여 개발할 것
 */
public class GameServiceImpl implements GameService {
    @Override
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player) {
        SlotMachineGame slotMachineGame = (SlotMachineGame) game;
        return slotMachineGame.play(player);
    }

    @Override
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player) {
        RouletteGame rouletteGame = (RouletteGame) game;
        return rouletteGame.play(info, player);
    }

    @Override
    public void playBlackjack(Game game, Player player) {

    }

}

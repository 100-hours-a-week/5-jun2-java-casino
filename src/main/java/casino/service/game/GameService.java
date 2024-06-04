package casino.service.game;

import casino.domain.game.Game;
import casino.domain.game.blackjack.BlackjackGame;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import casino.dto.SlotMachineGameResultDto;
import java.util.Map;

public interface GameService {
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player);
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player);
    public BlackjackGame setBlackjack(Game game, Player player, Map<ChipType, Integer> betChips);
}

package casino.service.exchange;

import casino.domain.casino.ChipType;
import casino.domain.participant.Participant;
import casino.domain.participant.Player;
import casino.dto.AccountBalanceInfoDto;
import java.util.EnumMap;
import java.util.Map;

public class ExchangeServiceImpl implements ExchangeService {
    @Override
    public AccountBalanceInfoDto findAccountBalanceInfo(Participant participant) {
        if (participant.isPlayer()) {
            Player player = (Player) participant;
            long cash = player.getCashBalance();
            Map<ChipType, Integer> chips = player.getChipsBalance();
            return new AccountBalanceInfoDto(cash, chips);
        }
        throw new IllegalArgumentException("[ERROR] 플레이어 이외의 보유 잔액은 조회할 수 없습니다.\n");
    }
}

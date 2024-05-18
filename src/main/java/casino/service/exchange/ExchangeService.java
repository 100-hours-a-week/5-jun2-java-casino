package casino.service.exchange;

import casino.domain.casino.ChipType;
import casino.domain.participant.Participant;
import casino.domain.participant.Player;
import casino.dto.AccountBalanceInfoDto;
import java.util.List;
import java.util.Map;

public interface ExchangeService {
    AccountBalanceInfoDto findAccountBalanceInfo(Participant participant);
    void exchangeCashToChips(Player player, AccountBalanceInfoDto info);
    void exchangeChipsToCash(Player player, AccountBalanceInfoDto info);
}

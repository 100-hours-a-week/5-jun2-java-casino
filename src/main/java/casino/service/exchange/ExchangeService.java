package casino.service.exchange;

import casino.domain.participant.Participant;
import casino.dto.AccountBalanceInfoDto;

public interface ExchangeService {
    AccountBalanceInfoDto findAccountBalanceInfo(Participant participant);
}

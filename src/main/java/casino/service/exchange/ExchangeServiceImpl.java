package casino.service.exchange;

import casino.domain.casino.ChipType;
import casino.domain.participant.Participant;
import casino.domain.participant.Player;
import casino.dto.AccountBalanceInfoDto;
import java.util.Map;

public class ExchangeServiceImpl implements ExchangeService {
    private static final String ERROR_PREFIX = "[ERROR]";
    @Override
    public AccountBalanceInfoDto findAccountBalanceInfo(Participant participant) {
        if (participant.isPlayer()) {
            Player player = (Player) participant;
            long cash = player.getCashBalance();
            Map<ChipType, Integer> chips = player.getChipsBalance();
            return new AccountBalanceInfoDto(cash, chips);
        }
        throw new IllegalArgumentException(ERROR_PREFIX + " 플레이어 이외의 보유 잔액은 조회할 수 없습니다.\n");
    }

    @Override
    public void exchangeCashToChips(Player player, AccountBalanceInfoDto info) {
        long cash = info.cash();
        Map<ChipType, Integer> chips = info.chips();

        if (isPossibleToExchange(cash, chips)) {
            long amount = 0;

            for (Map.Entry<ChipType, Integer> entry : chips.entrySet()) {
                amount += (long) entry.getKey().getKrw() * entry.getValue();
                player.updateChipCount(entry.getKey(), entry.getValue());
            }
            player.updateCash(false, amount);
            return;
        }

        // 보유 현금보다 많은 칩을 교환할 경우 예외 발생
        throw new IllegalArgumentException(ERROR_PREFIX + " 교환할 수 없는 금액입니다. 현금이 부족합니다.");
    }

    @Override
    public void exchangeChipsToCash(Player player, AccountBalanceInfoDto info) {

    }

    private boolean isPossibleToExchange(long cash, Map<ChipType, Integer> chips) {
        for (Map.Entry<ChipType, Integer> entry : chips.entrySet()) {
            if (entry.getValue() != 0) {
                int amount = entry.getKey().getKrw() * entry.getValue();
                cash -= amount;
            }

            if (cash < 0) {
                return false;
            }
        }
        return true;
    }
}

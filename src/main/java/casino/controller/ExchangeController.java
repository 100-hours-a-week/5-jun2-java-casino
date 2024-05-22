package casino.controller;

import static casino.domain.option.ExchangeOption.*;

import casino.CasinoConfig;
import casino.domain.type.ChipType;
import casino.domain.option.ExchangeOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.dto.AccountBalanceInfoDto;
import casino.response.ExchangeResponse;
import casino.request.Request;
import casino.service.casino.CasinoMainService;
import casino.service.exchange.ExchangeService;
import java.util.Map;

public class ExchangeController implements Controller {
    private final Request request;
    private final ExchangeResponse exchangeResponse;
    private final ExchangeService exchangeService;
    private final CasinoMainService casinoMainService;

    public ExchangeController(CasinoConfig casinoConfig) {
        this.request = casinoConfig.request();
        this.exchangeResponse = casinoConfig.exchangeResponse();
        this.exchangeService = casinoConfig.exchangeService();
        this.casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process() {
        ExchangeOption exchangeOption;

        do {
            exchangeResponse.printBlankLine();
            exchangeResponse.printExchangeOption();
            exchangeOption = request.getExchangeOption();
            processService(exchangeOption);
        } while (exchangeOption.isContinue());
    }

    private void processService(ExchangeOption option) {
        Player findPlayer = findPlayer();
        // 옵션에 따른 환전 로직
        if (option == CHECK_ACCOUNT) {
            checkAccountBalanceService(findPlayer);
        } else if (option == CHIP_TO_CASH || option == CASH_TO_CHIP) {
            exchangeService(option, findPlayer);
        }
    }

    private Player findPlayer() {
        return (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
    }

    private void checkAccountBalanceService(Player findPlayer) {
        AccountBalanceInfoDto info = exchangeService.findAccountBalanceInfo(findPlayer);
        exchangeResponse.printAccountBalanceInfo(info);
    }

    private void exchangeService(ExchangeOption option, Player findPlayer) {
        long cash = findPlayer.getCashBalance();
        Map<ChipType, Integer> playerChips = findPlayer.getChipsBalance();

        try {
            if (option == CASH_TO_CHIP) {
                exchangeResponse.printExchangeCashToChips();
                Map<ChipType, Integer> chips = request.getExchangeChips();
                exchangeService.exchangeCashToChips(findPlayer, new AccountBalanceInfoDto(cash, chips));
            } else if (option == CHIP_TO_CASH) {
                exchangeResponse.printExchangeChipsToCash(playerChips);
                Map<ChipType, Integer> chips = request.getExchangeChips();
                exchangeService.exchangeChipsToCash(findPlayer, new AccountBalanceInfoDto(cash, chips));
            }
        } catch (IllegalArgumentException e) {
            exchangeResponse.printException(e.getMessage());
        }
    }
}

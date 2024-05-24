package casino.controller.entrypoint.impl;

import casino.Jun2CasinoObjectContainer;
import casino.controller.entrypoint.Controller;
import casino.domain.option.ExchangeOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.domain.type.ChipType;
import casino.dto.AccountBalanceInfoDto;
import casino.request.CasinoRequest;
import casino.response.ExchangeResponse;
import casino.service.casino.CasinoMainService;
import casino.service.exchange.ExchangeService;

import java.util.Map;

import static casino.domain.option.ExchangeOption.*;

public class ExchangeController implements Controller {
    private final CasinoRequest request;
    private final ExchangeResponse exchangeResponse;
    private final ExchangeService exchangeService;
    private final CasinoMainService casinoMainService;

    public ExchangeController(Jun2CasinoObjectContainer jun2CasinoObjectContainer) {
        this.request = jun2CasinoObjectContainer.casinoRequest();
        this.exchangeResponse = jun2CasinoObjectContainer.exchangeResponse();
        this.exchangeService = jun2CasinoObjectContainer.exchangeService();
        this.casinoMainService = jun2CasinoObjectContainer.casinoMainService();
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

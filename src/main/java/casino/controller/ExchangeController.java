package casino.controller;

import casino.CasinoConfig;
import casino.domain.casino.ChipType;
import casino.domain.options.ExchangeOption;
import casino.domain.participant.Participant;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.dto.AccountBalanceInfoDto;
import casino.io.exchange.ExchangeInputView;
import casino.io.exchange.ExchangeOutputView;
import casino.service.casino.CasinoMainService;
import casino.service.exchange.ExchangeService;
import java.util.List;
import java.util.Map;

public class ExchangeController implements Controller {
    private final ExchangeOutputView exchangeOutputView;
    private final ExchangeInputView exchangeInputView;
    private final ExchangeService exchangeService;
    private final CasinoMainService casinoMainService;

    public ExchangeController(CasinoConfig casinoConfig) {
        this.exchangeOutputView = casinoConfig.exchangeOutputView();
        this.exchangeInputView = casinoConfig.exchangeInputView();
        this.exchangeService = casinoConfig.exchangeService();
        this.casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process() {
        ExchangeOption exchangeOption;

        do {
            exchangeOutputView.printBlankLine();
            exchangeOutputView.printExchangeOption();
            exchangeOption = exchangeInputView.readExchangeOption();
            processService(exchangeOption);
        } while (exchangeOption.isContinue());
    }

    private void processService(ExchangeOption option) {
        Player findPlayer = findPlayer();
        // 옵션에 따른 환전 로직
        if (option == ExchangeOption.CHECK_ACCOUNT) {
            checkAccountBalanceService(findPlayer);
        } else if (option == ExchangeOption.CASH_TO_CHIP) {
            exchangeCashToChipService(findPlayer);
        }
    }

    private Player findPlayer() {
        return (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
    }

    private void checkAccountBalanceService(Player findPlayer) {
        AccountBalanceInfoDto info = exchangeService.findAccountBalanceInfo(findPlayer);
        exchangeOutputView.printAccountBalanceInfo(info);
    }

    private void exchangeCashToChipService(Player findPlayer) {
        exchangeOutputView.printExchangeCashToChips();
        long cash = findPlayer.getCashBalance();
        Map<ChipType, Integer> chips = exchangeInputView.readExchangeCashToChips();

        try {
            exchangeService.exchangeCashToChips(findPlayer, new AccountBalanceInfoDto(cash, chips));
        } catch (IllegalArgumentException e) {
            exchangeOutputView.printException(e.getMessage());
        }
    }

}

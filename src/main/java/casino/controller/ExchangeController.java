package casino.controller;

import casino.CasinoConfig;
import casino.domain.options.ExchangeOption;
import casino.domain.participant.Participant;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.dto.AccountBalanceInfoDto;
import casino.io.exchange.ExchangeInputView;
import casino.io.exchange.ExchangeOutputView;
import casino.service.casino.CasinoMainService;
import casino.service.exchange.ExchangeService;

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
        // 옵션에 따른 환전 로직
        if (option == ExchangeOption.CHECK_ACCOUNT) {
            Participant findPlayer = casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
            AccountBalanceInfoDto info = exchangeService.findAccountBalanceInfo(findPlayer);
            exchangeOutputView.printAccountBalanceInfo(info);
        }
    }

}

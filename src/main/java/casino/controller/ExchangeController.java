package casino.controller;

import casino.CasinoConfig;
import casino.domain.options.ExchangeOption;
import casino.io.exchange.ExchangeInputView;
import casino.io.exchange.ExchangeOutputView;
import casino.service.exchange.ExchangeService;

public class ExchangeController implements Controller {
    private final ExchangeOutputView exchangeOutputView;
    private final ExchangeInputView exchangeInputView;
    private final ExchangeService exchangeService;

    public ExchangeController(CasinoConfig casinoConfig) {
        this.exchangeOutputView = casinoConfig.exchangeOutputView();
        this.exchangeInputView = casinoConfig.exchangeInputView();
        this.exchangeService = casinoConfig.exchangeService();
    }

    @Override
    public void process() {
        ExchangeOption exchangeOption;

        do {
            exchangeOutputView.printBlankLine();
            exchangeOutputView.printExchangeOption();
            exchangeOption = exchangeInputView.readExchangeOption();
            activeService(exchangeOption);
        } while (exchangeOption.isContinue());
    }

    private void activeService(ExchangeOption option) {
        // 옵션에 따른 환전 로직
    }
}

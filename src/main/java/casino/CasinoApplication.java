package casino;

import casino.controller.CasinoController;

public class CasinoApplication {
    public static void main(String[] args) {
        CasinoConfig casinoConfig = new CasinoConfig();
        CasinoController casinoController = new CasinoController(casinoConfig);
        casinoController.process();
    }
}

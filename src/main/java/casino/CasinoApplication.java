package casino;

import casino.controller.CasinoController;

public class CasinoApplication {
    public static void main(String[] args) {
        CasinoController casinoController = new CasinoController();
        casinoController.process();
    }
}

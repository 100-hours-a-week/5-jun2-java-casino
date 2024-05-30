package casino.controller.game;

import static casino.domain.type.GameType.BLACKJACK;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.game.blackjack.BlackjackGame;
import casino.domain.participant.Dealer;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.request.Request;
import casino.response.GameResponse;
import casino.service.game.GameService;
import casino.utils.validator.GameInputValidator;
import java.util.Map;
import java.util.concurrent.Delayed;


public class BlackjackController implements GameController {
    private final Request request;
    private final GameResponse gameResponse;
    private final GameService gameService;

    public BlackjackController(CasinoConfig casinoConfig) {
        this.request = casinoConfig.request();
        this.gameResponse = casinoConfig.gameResponse();
        this.gameService = casinoConfig.gameService();
    }

    @Override
    public void process(Game game, Player player) {
        gameResponse.printPlayerChips(player.getChipsBalance());
        Map<ChipType, Integer> betChips = request.getBetChips(BLACKJACK);
        player.validateChipsToPlay(betChips);
        BlackjackGame blackjackGame = gameService.setBlackjack(game, player, betChips);
        printParticipantsCards(player, blackjackGame.getDealer());

        if (!game.isPlay()) {
            game.changeStatus();
        }

        while (game.isPlay()) {
            Thread playerThread = new Thread(blackjackGame::playerTurn);
            Thread dealerThread = new Thread(blackjackGame::dealerTurn);

            playerThread.start();
            dealerThread.start();

            try {
                playerThread.join();
                dealerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameResponse.printBlackjackValue(player.getCardsValue(), blackjackGame.calculateDealerScore());
            printBlackjackResult(player, blackjackGame.getDealer(), betChips);
            game.changeStatus();
        }
    }

    private void printParticipantsCards(Player player, Dealer dealer) {
        gameResponse.printCards(player);
        gameResponse.printCards(dealer);
    }

    private void printBlackjackResult(Player player, Dealer dealer, Map<ChipType,Integer> betChips) {
        int playerValue = player.getCardsValue();
        int dealerValue = dealer.getCardsValue();
        boolean isPlayerWin = false;

        if (playerValue == 21 && dealerValue == 21) {
            System.out.println("!!!Player and Dealer Blackjack!!! 무승부");
        } else if (playerValue == 21 && dealerValue != 21) {
            isPlayerWin = true;
            System.out.println("!!!Player Blackjack!!! 플레이어 승리");
        } else if (dealerValue == 21 && playerValue != 21) {
            System.out.println("!!!Dealer Blackjack!!! 딜러 승리");
        } else if (playerValue > 21 && dealerValue <= 21) {
            System.out.println("플레이어 카드 합이 21을 초과했습니다. 딜러 승리");
        } else if (dealerValue > 21 && playerValue <= 21) {
            isPlayerWin = true;
            System.out.println("딜러 카드 합이 21을 초과했습니다. 플레이어 승리");
        } else {
            String winner = playerValue > dealerValue ? "플레이어" : playerValue == dealerValue ? "없습니다. 무승부" : "딜러";
            if (winner.equals("플레이어")) {
                isPlayerWin = true;
            }
            System.out.println("블랙잭 게임 승리 : " + winner);
        }

        if (isPlayerWin) {
            for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
                player.updateChipCount(true, entry.getKey(), entry.getValue() * 2);
            }
        }
    }
}

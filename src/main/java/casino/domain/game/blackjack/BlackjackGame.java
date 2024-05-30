package casino.domain.game.blackjack;

import casino.domain.game.Card;
import casino.domain.game.CardDeck;
import casino.domain.game.CardGame;
import casino.domain.participant.Dealer;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


public class BlackjackGame extends CardGame {
    private final CardDeck cardDeck;
    private final Dealer dealer;
    private volatile boolean playerTurnOver = false;
    private volatile boolean dealerTurnOver = false;
    private volatile boolean gameOver = false;
    private final CountDownLatch playerDoneSignal = new CountDownLatch(1);
    private final CountDownLatch dealerDoneSignal = new CountDownLatch(1);

    public BlackjackGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
        this.cardDeck = new CardDeck();
        this.dealer = new Dealer("Dealer", RoleType.DEALER);
    }

    public void setGame() {
        player.clearCard();
        dealer.clearCard();
        cardDeck.reset();

        for (int i = 0; i < 2; i++) {
            player.addCard(cardDeck.drawCard());
            dealer.addCard(cardDeck.drawCard());
        }
    }

    public void playerTurn() {
        while (!playerTurnOver && !gameOver) {
            if (player.isBusted() || player.getCardsValue() == 21) {
                playerTurnOver = true;
                gameOver = true;
                playerDoneSignal.countDown();
                dealerDoneSignal.countDown();
                return;
            }

            String command = readCommand();

            if ("end".equals(command)) {
                playerTurnOver = true;
            } else {
                Card card = cardDeck.drawCard();
                System.out.println("플레이어가 카드를 받았습니다! " + card.toString() );
                player.addCard(card);
            }

            if (player.getCardsValue() > 21) {
                playerTurnOver = true;
                gameOver = true;
                playerDoneSignal.countDown();
                dealerDoneSignal.countDown();
                return;
            }

            if (playerTurnOver) {
                playerDoneSignal.countDown();
            }
        }
    }

    public void dealerTurn() {
        try {
            playerDoneSignal.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (!dealerTurnOver && !gameOver) {
            if (dealer.getCardsValue() > 21 || dealer.getCardsValue() == 21) {
                dealerTurnOver = true;
                gameOver = true;
                dealerDoneSignal.countDown();
                return;
            }

            if (dealer.getCardsValue() < 17 && playerTurnOver) {
                System.out.println("딜러가 카드를 받았습니다!");
                dealer.addCard(cardDeck.drawCard());
            } else {
                dealerTurnOver = true;
                dealerDoneSignal.countDown();
            }

            if (dealer.getCardsValue() > 21) {
                dealerTurnOver = true;
                gameOver = true;
                dealerDoneSignal.countDown();
                return;
            }
        }
    }

    public int calculateDealerScore() {
        return dealer.getCardsValue();
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    private String readCommand() {
        System.out.print("카드를 추가로 받으려면 hit, 종료하려면 end 를 입력하세요. [hit/end] ");
        try {
            String command = new Scanner(System.in).nextLine();
            if (!command.equals("hit") && !command.equals("end")) {
                throw new IllegalArgumentException();
            }
            return command;
        } catch (IllegalArgumentException e) {
            return readCommand();
        }
    }
}

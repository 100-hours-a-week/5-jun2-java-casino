package casino.domain.game.blackjack;

import casino.domain.game.Card;
import casino.domain.game.CardDeck;
import casino.domain.game.CardGame;
import casino.domain.participant.Dealer;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;
import java.util.List;
import java.util.Scanner;


public class BlackjackGame extends CardGame {
    private final CardDeck cardDeck;
    private final Dealer dealer;
    private boolean playerTurnOver = false;
    private boolean dealerTurnOver = false;

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

        List<Card> cards = player.getCards();
        for (Card card : cards) {
            System.out.print(card.toString() + " ");
        }
        System.out.println();

        List<Card> dcards = dealer.getCards();
        for (Card card : dcards) {
            System.out.print(card.toString() + " ");
        }
        System.out.println();
    }

    public synchronized void playerTurn() {
        System.out.println("플레이어의 턴!!!");
        while (!playerTurnOver) {
            if (player.isBusted()) {
                playerTurnOver = true;
                notifyAll();
                return;
            }

            System.out.print("hit or stay ? ");
            String command = new Scanner(System.in).nextLine();
            System.out.println(command);

            if ("stay".equals(command)) {
                playerTurnOver = true;
            } else {
                Card card = cardDeck.drawCard();
                System.out.println("player draw : " + card.toString());
                player.addCard(card);
            }

            notifyAll();

            try {
                if (!playerTurnOver) {
                    wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void dealerTurn() {
        System.out.println("딜러의 턴!!!");
        while (!dealerTurnOver) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (dealer.getCardsValue() < 17 && playerTurnOver) {
                dealer.addCard(cardDeck.drawCard());
            } else {
                dealerTurnOver = true;
                return;
            }
            notifyAll();
        }
    }

    public int calculateDealerScore() {
        return dealer.getCardsValue();
    }

    public Player getPlayer() {
        return player;
    }
}

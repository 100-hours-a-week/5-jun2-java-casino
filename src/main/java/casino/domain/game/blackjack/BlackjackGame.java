package casino.domain.game.blackjack;

import casino.domain.game.CardDeck;
import casino.domain.game.CardGame;
import casino.domain.participant.Dealer;
import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlackjackGame extends CardGame {
    public BlackjackGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }

    public void play(Player player, Dealer dealer) throws Exception {
        CardDeck cardDeck = new CardDeck();

        for (int i = 0; i < 2; i++) {
            player.addCard(cardDeck.drawCard());
            dealer.addCard(cardDeck.drawCard());
        }

        player.setCardDeck(cardDeck);
        dealer.setCardDeck(cardDeck);

        // Player, Dealer 턴 관리
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Void> playerTask = () -> {
            player.play(cardDeck);
            return null;
        };

        Callable<Void> dealerTask = () -> {
            dealer.play(cardDeck);
            return null;
        };

        Future<Void> playerFuture = executor.submit(playerTask);
        Future<Void> dealerFuture = executor.submit(dealerTask);

        playerFuture.get();
        dealerFuture.get();

        executor.shutdown();
    }
}

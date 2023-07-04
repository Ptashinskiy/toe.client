package tic.tac.toe.client.config;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import tic.tac.toe.client.dto.GameDto;
import tic.tac.toe.client.dto.GameStatus;
import tic.tac.toe.client.dto.GetGameRequest;
import tic.tac.toe.client.dto.Sign;

import java.lang.reflect.Type;

public class GameStompSessionHandler implements StompSessionHandler {

    private final String gameId;

    public GameStompSessionHandler(String gameId) {
        this.gameId = gameId;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/game2/status", this);
        session.send("/game/game-status", new GetGameRequest(gameId));
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        exception.printStackTrace();
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        exception.printStackTrace();
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return GameDto.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        GameDto game = (GameDto) payload;
        System.out.println(game);
        if (game.getStatus().equals(GameStatus.FINISHED)) {
            System.out.println("The game is finished.");
            if (game.getWinner().equals(Sign.X)) {
                System.out.println("You won!");
            } else {
                System.out.println("Bot won!");
            }
        }
    }
}

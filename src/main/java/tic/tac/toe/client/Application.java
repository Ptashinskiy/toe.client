package tic.tac.toe.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import tic.tac.toe.client.config.GameStompSessionHandler;
import tic.tac.toe.client.config.HealthStompSessionHandler;
import tic.tac.toe.client.dto.MakeMoveRequest;

import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		String gameId = restTemplate.exchange("http://localhost:8080/games", HttpMethod.POST, null, String.class).getBody();

		WebSocketClient client = new StandardWebSocketClient();

		WebSocketStompClient stompClient = new WebSocketStompClient(client);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());

		GameStompSessionHandler gameHandler = new GameStompSessionHandler(gameId);
		HealthStompSessionHandler healthHandler = new HealthStompSessionHandler();
		StompSession gameSession = stompClient.connectAsync("ws://localhost:8080/tic-tac-toe", gameHandler).get();
		stompClient.connectAsync("ws://localhost:8080/tic-tac-toe", healthHandler);

		String input = "input";
		while (!input.equals("exit")) {
			MakeMoveRequest request = new MakeMoveRequest();
			request.setGameId(gameId);
			System.out.println("Enter the letter coordinate: ");
			input = new Scanner(System.in).nextLine();
			request.setLetterCoordinate(input);
			System.out.println("Enter the number coordinate: ");
			input = new Scanner(System.in).nextLine();
			request.setNumberCoordinate(input);
			gameSession.subscribe("/game2/games/" + gameId, gameHandler);
			gameSession.send("/game/make-move", request);
		}
	}

}

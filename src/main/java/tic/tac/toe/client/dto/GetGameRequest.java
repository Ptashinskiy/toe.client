package tic.tac.toe.client.dto;

public class GetGameRequest {

    private String gameId;

    public GetGameRequest() {
    }

    public GetGameRequest(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}

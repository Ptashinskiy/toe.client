package tic.tac.toe.client.dto;

public class MakeMoveRequest {

    private String gameId;

    private String coordinates;

    public MakeMoveRequest() {
    }

    public MakeMoveRequest(String gameId, String coordinates) {
        this.gameId = gameId;
        this.coordinates = coordinates;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
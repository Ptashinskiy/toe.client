package tic.tac.toe.client.dto;

public class MakeMoveRequest {

    private String gameId;

    private String numberCoordinate;

    private String letterCoordinate;

    public MakeMoveRequest() {
    }

    public MakeMoveRequest(String gameId, String numberCoordinate, String letterCoordinate) {
        this.gameId = gameId;
        this.numberCoordinate = numberCoordinate;
        this.letterCoordinate = letterCoordinate;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getNumberCoordinate() {
        return numberCoordinate;
    }

    public void setNumberCoordinate(String numberCoordinate) {
        this.numberCoordinate = numberCoordinate;
    }

    public String getLetterCoordinate() {
        return letterCoordinate;
    }

    public void setLetterCoordinate(String letterCoordinate) {
        this.letterCoordinate = letterCoordinate;
    }
}
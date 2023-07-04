package tic.tac.toe.client.dto;

public class GameDto {

    private String id;

    private Sign[][] field;

    private GameStatus status;

    private Sign winner;

    public GameDto() {
    }

    public GameDto(String id, Sign[][] field, GameStatus status, Sign winner) {
        this.id = id;
        this.field = field;
        this.status = status;
        this.winner = winner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sign[][] getField() {
        return field;
    }

    public void setField(Sign[][] field) {
        this.field = field;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Sign getWinner() {
        return winner;
    }

    public void setWinner(Sign winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "    " + " 1 " + "  2 " + "  3 " + "\n" +
                " A   " + field[0][0] + " | " + field[0][1] + " | " + field[0][2] + "\n" +
                "   ____|___|____\n" +
                " B   " + field[1][0] + " | " + field[1][1] + " | " + field[1][2] + "\n" +
                "   ____|___|____\n" +
                " C   " + field[2][0] + " | " + field[2][1] + " | " + field[2][2];
    }
}

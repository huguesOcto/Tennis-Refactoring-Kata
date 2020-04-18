import java.util.List;
import java.util.Objects;

public class TennisGame2 implements TennisGame
{

    private static final String ADVANTAGE = "Advantage";

    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String LOVE = "Love";
    public static final String DEUCE = "Deuce";
    private static final String VICTORY = "Victory";
    private String player1Score = LOVE;
    private String player2Score = LOVE;

    public TennisGame2(String player1Name, String player2Name) {}

    public String getScore(){
        if (isPlayer1Win()) {
            return "Win for player1";
        }
        if (isPlayer2Win()) {
            return "Win for player2";
        }
        if (isPlayer1Advantage()) {
            return "Advantage player1";
        }
        if (isPlayer2Advantage()) {
            return "Advantage player2";
        }
        if (this.isDeuce()) {
            return DEUCE;
        }
        if (Objects.equals(player2Score, player1Score)) {
            return this.player1Score + "-All";
        }

        return this.player1Score + "-" + this.player2Score;
    }

    public void wonPoint(String player) {
        if (isPlayer1Win() || isPlayer2Win()) {
            return;
        }

        if ("player1".equals(player)) {
            addPointToPlayer1();
        }
        else {
            addPointToPlayer2();
        }
    }

    private boolean isPlayer2Advantage() {
        return this.player2Score.equals(ADVANTAGE);
    }

    private boolean isPlayer1Advantage() {
        return this.player1Score.equals(ADVANTAGE);
    }

    private boolean isPlayer2Win() {
        return Objects.equals(this.player2Score, VICTORY);
    }

    private boolean isPlayer1Win() {
        return Objects.equals(this.player1Score, VICTORY);
    }

    private boolean isDeuce() {
        return player1Score.equals(FORTY) && player2Score.equals(FORTY);
    }

    private void addPointToPlayer1() {
        if (this.isPlayer2Advantage()) {
            this.setDeuce();
            return;
        }

        this.player1Score = getPointWinnerNewScore(this.player1Score, this.player2Score);
    }

    private void addPointToPlayer2() {
        if (this.isPlayer1Advantage()) {
            this.setDeuce();
            return;
        }

        this.player2Score = getPointWinnerNewScore(this.player2Score, this.player1Score);
    }

    private static String nextScore(String score) {
        if (score.equals(ADVANTAGE)) {
            return VICTORY;
        }
        if (score.equals(LOVE)) {
            return FIFTEEN;
        }
        if (score.equals(FIFTEEN)) {
            return THIRTY;
        }
        if (score.equals(THIRTY)) {
            return FORTY;
        }
        return null;
    }

    private static String getPointWinnerNewScore(String pointWinnerScore, String pointLoserScore) {
        if (List.of(LOVE, FIFTEEN, THIRTY, ADVANTAGE).contains(pointWinnerScore)) {
            return nextScore(pointWinnerScore);
        }

        if (pointWinnerScore.equals(FORTY)) {
            if (pointLoserScore.equals(FORTY)) {
                return ADVANTAGE;
            }
            if (List.of(LOVE, FIFTEEN, THIRTY).contains(pointLoserScore)) {
                return VICTORY;
            }
        }
        return null;
    }

    private void setDeuce() {
        this.player2Score = FORTY;
        this.player1Score = FORTY;
    }

}
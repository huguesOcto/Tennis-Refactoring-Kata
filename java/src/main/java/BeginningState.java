import java.util.Objects;

public class BeginningState implements State {

	private String player1Points;
	private String player2Points;

	public static final String FIFTEEN = "Fifteen";
	public static final String THIRTY = "Thirty";
	public static final String FORTY = "Forty";
	public static final String LOVE = "Love";

	public BeginningState(String player1Score, String player2Score) {
		this.player1Points = player1Score;
		this.player2Points = player2Score;
	}

	@Override
	public String getScore() {
		if (Objects.equals(player1Points, player2Points)) {
			return this.player1Points + "-All";
		}
		return this.player1Points + "-" + this.player2Points;
	}

	@Override
	public State addPointToPlayer1() {
		if (this.player1Points.equals(FORTY)) {
				return new VictoryPlayer1State();
		}
		if (this.player1Points.equals(THIRTY) && this.player2Points.equals(FORTY)) {
				return new DeuceState();
		}
		return new BeginningState(addOnePoint(this.player1Points), this.player2Points);
	}

	@Override
	public State addPointToPlayer2() {
		if (this.player2Points.equals(FORTY)) {
			return new VictoryPlayer2State();
		}
		if (this.player2Points.equals(THIRTY) && this.player1Points.equals(FORTY)) {
			return new DeuceState();
		}
		return new BeginningState(this.player1Points, addOnePoint(this.player2Points));
	}

	private static String addOnePoint(String playerPoints) {
		if (playerPoints.equals(LOVE)) {
			return FIFTEEN;
		}
		if (playerPoints.equals(FIFTEEN)) {
			return THIRTY;
		}
		if (playerPoints.equals(THIRTY)) {
			return FORTY;
		}

		throw new IllegalArgumentException();
	}
}

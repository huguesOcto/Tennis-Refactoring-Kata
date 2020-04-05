import java.util.Objects;

public class TennisGame1 implements TennisGame {

	private enum Score {
		Love,
		Fifteen,
		Thirty,
		Forty,
		Advantage,
		Victory
	}

	private Score player1Score = Score.Love;
	private Score player2Score = Score.Love;

	public void wonPoint(String playerName) {
		if (this.isPlayer1Victory() || this.isPlayer2Victory()) {
			return;
		}

		if (Objects.equals(playerName, "player1")) {
			if (isAdvantagePlayer2()) {
				this.setDeuce();
			} else {
				addPointToPlayer1();
			}
		} else {
			if (isAdvantagePlayer1()) {
				this.setDeuce();
			} else {
				addPointToPlayer2();
			}
		}
	}

	private void setDeuce() {
		this.player1Score = Score.Forty;
		this.player2Score = Score.Forty;
	}

	private void addPointToPlayer2() {
		this.player2Score = addPointToScore(this.player2Score);
	}

	private void addPointToPlayer1() {
		this.player1Score = addPointToScore(this.player1Score);
	}

	private Score addPointToScore(Score playerScore) {
		if (this.isDeuce()) {
			return Score.Advantage;
		}
		if (playerScore.equals(Score.Love)) {
			return Score.Fifteen;
		}
		if (playerScore.equals(Score.Fifteen)) {
			return Score.Thirty;
		}
		if (playerScore.equals(Score.Thirty)) {
			return Score.Forty;
		}
		return Score.Victory;
	}

	public String getScore() {
		if (this.isPlayer1Victory()) {
			return "Win for player1";
		}
		if (this.isPlayer2Victory()) {
			return "Win for player2";
		}
		if (this.isDeuce()) {
			return "Deuce";
		}
		if (this.isAdvantagePlayer1()) {
			return "Advantage player1";
		}
		if (this.isAdvantagePlayer2()) {
			return "Advantage player2";
		}

		if (player1Score == player2Score) {
			return String.format("%s-All", this.player1Score.toString());
		}

		return String.format(
				"%s-%s", player1Score.toString(), player2Score.toString()
		);
	}

	private boolean isAdvantagePlayer1() {
		return player1Score.equals(Score.Advantage);
	}

	private boolean isAdvantagePlayer2() {
		return player2Score.equals(Score.Advantage);
	}

	private boolean isDeuce() {
		return player1Score.equals(Score.Forty) && player2Score.equals(Score.Forty);
	}

	private boolean isPlayer1Victory() {
		return player1Score.equals(Score.Victory);
	}

	private boolean isPlayer2Victory() {
		return player2Score.equals(Score.Victory);
	}

}

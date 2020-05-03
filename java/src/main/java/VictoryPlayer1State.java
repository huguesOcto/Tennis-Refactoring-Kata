public class VictoryPlayer1State implements State {

	@Override
	public String getScore() {
		return "Win for player1";
	}

	@Override
	public State addPointToPlayer1() {
		// Do nothing because game is over
		return this;
	}

	@Override
	public State addPointToPlayer2() {
		// Do nothing because game is over
		return this;
	}

}

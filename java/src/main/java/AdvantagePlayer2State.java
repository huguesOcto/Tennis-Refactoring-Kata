public class AdvantagePlayer2State implements State {

	@Override
	public String getScore() {
		return "Advantage player2";
	}

	@Override
	public State addPointToPlayer2() {
		return new VictoryPlayer2State();
	}

	@Override
	public State addPointToPlayer1() {
		return new VictoryPlayer1State();
	}

}

public class AdvantagePlayer1State implements State {

	@Override
	public String getScore() {
		return "Advantage player1";
	}

	@Override
	public State addPointToPlayer1() {
		return new VictoryPlayer1State();
	}

	@Override
	public State addPointToPlayer2() {
		return new DeuceState();
	}

}

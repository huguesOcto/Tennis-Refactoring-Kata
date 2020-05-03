public class DeuceState implements State {

	@Override
	public String getScore() {
		return "Deuce";
	}

	@Override
	public State addPointToPlayer1() {
		return new AdvantagePlayer1State();
	}

	@Override
	public State addPointToPlayer2() {
		return new AdvantagePlayer2State();
	}

}

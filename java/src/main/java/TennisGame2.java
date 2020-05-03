public class TennisGame2 implements TennisGame
{

    private static final String LOVE = "Love";
    private State state;

    public TennisGame2(String player1Name, String player2Name) {
        this.state = new BeginningState(LOVE, LOVE);
    }

    public String getScore(){
        return this.state.getScore();
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            this.state = this.state.addPointToPlayer1();
        }
        else {
            this.state = this.state.addPointToPlayer2();
        }
    }
}
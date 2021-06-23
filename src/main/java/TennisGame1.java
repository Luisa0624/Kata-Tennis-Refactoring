
public class TennisGame1 implements TennisGame {

    private int ScorePlayer1 = 0;
    private int ScorePlayer2 = 0;
    private String playerName1;
    private String playerName2;

    public TennisGame1(String playerName1, String playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
    }

    public void wonPoint(String PlayerName) {
        if (PlayerName == "player1") {
            ScorePlayer1 ++;
        }
        else {
            ScorePlayer2 ++;
        }
    }

    public String getScore() {
        String Score = "";
        if (ScorePlayer1 == ScorePlayer2){
            Score = PuntajeDeEmpate();
        }
        else if ((ScorePlayer1 >= 4) || (ScorePlayer2 >= 4)){
            Score = Avance();
        } else{
            Score = Puntaje(ScorePlayer1) + "-" + Puntaje(ScorePlayer2);
        }
        return Score;
    }

    public String PuntajeDeEmpate(){
        switch (ScorePlayer1)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public String Avance(){
        int DiferenciaDePuntaje = ScorePlayer1 - ScorePlayer2;
        switch (DiferenciaDePuntaje){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                if (DiferenciaDePuntaje >= 2){
                    return "Win for player1";
                } else {
                    return "Win for player2";
                }
        }
    }

    public String Puntaje(int ScorePlayer) {
        switch (ScorePlayer) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
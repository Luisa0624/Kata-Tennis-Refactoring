import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame{

    private int ScorePlayer1 = 0;
    private int ScorePlayer2 = 0;
    private String Player1Name;
    private String Player2Name;

    public TennisGame2(String Player1Name, String Player2Name) {
        this.Player1Name = Player1Name;
        this.Player2Name = Player2Name;
    }

    public String getScore(){
        String Score = "";
        if (Empate()){
            Score = PuntajesIguales();
        }  else if(SeleccionDeAvance()){
            int DiferenciaDePuntaje = ScorePlayer1 - ScorePlayer2;
            Score = Avance(DiferenciaDePuntaje);
        } else {
            Score = Puntaje(ScorePlayer1) + "-" + Puntaje(ScorePlayer2);
        }
        return Score;
    }

    public void wonPoint(String Player) {
        var puntaje = (Player == "player1") ? (ScorePlayer1 ++) : (ScorePlayer2 ++);
    }


    public boolean Empate(){
        return (ScorePlayer1 == ScorePlayer2);
    }


    public boolean SeleccionDeAvance(){
        return ((ScorePlayer1 >= 4) || (ScorePlayer2 >= 4));
    }


    public String PuntajesIguales() {
        List<String> Puntajes = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return Puntajes.get(ScorePlayer1);
    }


    public String Avance(int DiferenciaDePuntaje){
        switch (DiferenciaDePuntaje){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (DiferenciaDePuntaje >= 2)? "Win for player1" : "Win for player2";
        }
    }

    public String Puntaje(int ScorePlayer){
        List<String> Puntajes = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return Puntajes.get(ScorePlayer);
    }
}
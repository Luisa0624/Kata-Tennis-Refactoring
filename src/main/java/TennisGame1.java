
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }


    public String getScore() {
        String score = "";

        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:score = "Love-All";
                    break;
                case 1: score = "Fifteen-All";
                    break;
                case 2:score = "Thirty-All";
                    break;
                default:score = "Deuce";
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else {

            int tempScore = 0;
            score = Score(score, m_score1);
            score+="-";
            score = Score(score, m_score2);
        }
        return score;
    }

    private String Score(String score, int points) {
        return Score.nameFromPoints(m_score1) + "-" + Score.nameFromPoints(m_score2);
    }

    enum Score {
        Love, Fifteen, Thirty, Forty;

        public static String nameFromPoints(int points) {
            return values()[points].name();
        }

    }

}

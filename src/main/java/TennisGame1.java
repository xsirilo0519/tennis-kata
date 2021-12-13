
public class TennisGame1 implements TennisGame {

    //nombres adecuados para las variables
    private int player1score = 0;
    private int player2score = 0;
    private final String player1Name;
    private final String player2Name;
    private final String[] listSqualScore = {"Love-All", "Fifteen-All", "Thirty-All","Deuce"};
    private final String[] listScore = {"Love", "Fifteen", "Thirty","Forty"};
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    //Se pone to Equals y se utilizan las variables existentes
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1score += 1;
        else
            player2score += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (isEqualScore())
        {
            score = getEqualScore();
        }

        else if (player1score>=4 || player2score>=4)
        {
            int minusResult = player1score-player2score;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for "+player2Name;
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1score;
                else { score+="-"; tempScore = player2score;}
                score = getPlayerScore(score, tempScore);
            }
        }
        return score;
    }

    //Extraccion de metodos con condicional
    private boolean isEqualScore() {
        return player1score==player2score;
    }
    //Extraccion de metodos
    //Simplificar condicional
    private String getPlayerScore(String score, int tempScore) {
        score+=listScore[tempScore];
        return score;
    }

    //Extraccion de metodos
    //Simplificar condicional
    private String getEqualScore() {
        return player1score>2?listSqualScore[3]:listSqualScore[player1score];
    }
}

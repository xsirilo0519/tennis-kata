
public class TennisGame1 implements TennisGame {

    //nombres adecuados para las variables
    private int player1score = 0;
    private int player2score = 0;
    private final String player1Name;
    private final String player2Name;
    private static final int MAXSCORE=4;
    private final String[] listSqualScore = {"Love-All", "Fifteen-All", "Thirty-All","Deuce"};
    private final String[] listScore = {"Love", "Fifteen", "Thirty","Forty"};
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    //Se pone to Equals y se utilizan las variables existentes
    //encapsulamiento
    public void wonPoint(String playerName) {
        if (playerName.equals(getPlayer1Name()))
            player1score += 1;
        else
            player2score += 1;
    }
    //encapsulamiento
    //se queria utilizar solo el return pero aumentaba el complexity por lo que se opto poner variable
    public String getScore() {
        String score;
        if (isEqualScore())
        {
            score = getEqualScore();
        }
        else if (isPlayerWin())
        {
            score = getInfoMatch();
        }
        else
        {
            score=printScoreMatch(getPlayer1score(),getPlayer2score());
        }
        return score;
    }
    //Extraccion de metodo y simplificacion de condicional
    //encapsulamiento
    private String printScoreMatch(int player1score,int player2score){
        return getPlayerScore(player1score)+"-"+getPlayerScore(player2score);
    }

    //Extraccion de metodo
    //Simplificar condicional
    //encapsulamiento
    private String getInfoMatch() {
        int minusResult = getPlayer1score()-getPlayer2score();
        return isAdvantage(minusResult)?getAdvantage(minusResult):getWinPlayer(minusResult);
    }
    //Simplificar condicional
    private boolean isAdvantage(int minusResult) {
        return isMayor(minusResult,-2)&&minusResult<2;
    }
    //Simplificar condicional
    //encapsulamiento
    private String getWinPlayer(int minusResult ){
        return "Win for "+(minusResult>=2?getPlayer1Name():getPlayer2Name());
    }
    //Simplificar condicional
    //encapsulamiento
    private String getAdvantage(int minusResult ){
        return "Advantage "+(minusResult==1?getPlayer1Name():getPlayer2Name());
    }
    //encapsulamiento
    private boolean isPlayerWin() {
        return getPlayer1score()>=MAXSCORE || getPlayer2score()>=MAXSCORE;
    }

    //Extraccion de metodos con condicional
    //encapsulamiento
    private boolean isEqualScore() {
        return getPlayer1score()==getPlayer2score();
    }
    //Extraccion de metodos
    //Simplificar condicional
    private String getPlayerScore( int tempScore) {
        return listScore[tempScore];
    }

    //Extraccion de metodos
    //Simplificar condicional
    //encapsulamiento
    private String getEqualScore() {
        return isMayor(getPlayer1score(),2)?listSqualScore[3]:listSqualScore[player1score];
    }
    //Simplificar condicional
    private boolean isMayor(int value, int num){
        return value>num;
    }
    //encapsulamiento
    public int getPlayer1score() {
        return player1score;
    }
    //encapsulamiento
    public int getPlayer2score() {
        return player2score;
    }
    //encapsulamiento
    public String getPlayer1Name() {
        return player1Name;
    }
    //encapsulamiento
    public String getPlayer2Name() {
        return player2Name;
    }
}

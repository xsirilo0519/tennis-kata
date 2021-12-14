
public class TennisGame3 implements TennisGame {
    
    private int puntoPlayer2;
    private int puntoPlayer1;
    private final String player1Name;
    private final String player2Name;
    private final String[] listaSets = {"Love", "Fifteen", "Thirty", "Forty"};
    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    //se queria utilizar solo el return pero aumentaba el complexity por lo que se opto poner variable
    public String getScore() {
        String playerName;
        if (isMenorAndIsDisf()) {
            playerName= getEqualScore();
        } else if (isEqualsPoints()){
            playerName= "Deuce";
        }else {
            playerName = getWinOrAdvanPlayerName();
            playerName = getMessageWinOrAdvan(playerName);
        }
        return playerName;
    }

    private String getMessageWinOrAdvan(String playerName) {
        return isAdvantage() ? "Advantage " + playerName : "Win for " + playerName;
    }

    private String getWinOrAdvanPlayerName() {
        return isMenor(getPuntoPlayer1() , getPuntoPlayer2()) ? getPlayer2Name() : getPlayer1Name();
    }

    private String getEqualScore() {
        return isEqualsPoints() ? listaSets[getPuntoPlayer1() ] + "-All" : getPutosPlayer1AndPlayer2();
    }

    private String getPutosPlayer1AndPlayer2() {
        return listaSets[getPuntoPlayer1() ] + "-" + listaSets[getPuntoPlayer2()];
    }

    private boolean isAdvantage() {
        return Math.abs(getPuntoPlayer1() -getPuntoPlayer2()) == 1;
    }


    private boolean isEqualsPoints() {
        return getPuntoPlayer1() == getPuntoPlayer2();
    }

    private boolean isMenorAndIsDisf(){
        return isMenor(getPuntoPlayer1(), 4) && isMenor(getPuntoPlayer2() , 4) && isDifToSix();
    }

    private boolean isDifToSix() {
        return getPuntoPlayer1()  + getPuntoPlayer2() != 6;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(getPlayer1Name()))
            this.puntoPlayer1 += 1;
        else
            this.puntoPlayer2 += 1;
    }

    private boolean isMenor(int value,int numero){
        return value<numero;
    }
    public int getPuntoPlayer2() {
        return puntoPlayer2;
    }

    public int getPuntoPlayer1() {
        return puntoPlayer1;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }
}

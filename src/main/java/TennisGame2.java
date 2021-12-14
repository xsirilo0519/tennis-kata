
public class TennisGame2 implements TennisGame
{
    private int player1point = 0;
    private int player2point = 0;

    private final String player1Name;
    private final String player2Name;
    private static final String DEUDE="Deude";
    private final String[] listaSets = {"Love", "Fifteen", "Thirty", "Forty"};
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    //Se dejó de esta manera para mantener la logica del programa
    //Se extendieron a metodos todos los condicionales y simplificaron las condiciones
    //Se dejó con una complejidad de 6 solo para mantener la logica inicial
    //se queria utilizar solo el return pero aumentaba el complexity por lo que se opto poner variable
    public String getScore(){
        String score = "";
        if (isEqualsMessage(isEqualPlayer1AndPlayer2()))
        {
            score=getEqualPlayer1AndPlayer2();
            score += "-All";
        }
        if(isMessagesOfPoints())
            score = getPuntisPlayer1AndPlayer2();

        if (isDeuce())
            score = DEUDE;

        if(score.equals(""))
            score = getAdvantageOrWin(score);

        return score;
    }

    private String getAdvantageOrWin(String score) {
        if (isMayorToNumber())
        {
            score = "Advantage "+getPlayer();
        }
        //¿Por qué esto es menos complejo que la linea de arriba?
        if (isWinner()){
            score="Win for ";
            score+=getPlayerWin();
        }
        return score;
    }

    private boolean isWinner() {
        return Math.abs((getPlayer1point()-getPlayer2point()))>=2;
    }


    private boolean isMayorToNumber() {
        return getPlayer2point() >= 3||getPlayer1point()>=3;
    }

    private String getPlayerWin(){
        return (getPlayer1point()-getPlayer2point())>=2?getPlayer1Name():player2Name;
    }

    private String getPlayer(){
        return isMenor(getPlayer2point(),getPlayer1point())?getPlayer1Name():getPlayer2Name();
    }

    private boolean isDeuce() {
        return isEqualPlayer1AndPlayer2() && getPlayer1point()>=3;
    }

    private boolean isEqualsMessage(boolean equalPlayer1AndPlayer2) {
        return equalPlayer1AndPlayer2 && isMenor(getPlayer1point(), 4);
    }

    private  boolean isMessagesOfPoints(){
        return isMenor(getPlayer1point(),4)&&isMenor(getPlayer2point(),4)&&!isEqualPlayer1AndPlayer2();
    }

    private boolean isMenor(int value,int numero)
    {
        return value<numero;
    }
    private boolean isEqualPlayer1AndPlayer2() {
        return getPlayer1point()==getPlayer2point();
    }

    private String getPuntisPlayer1AndPlayer2() {
             return listaSets[getPlayer1point()] + "-" + listaSets[getPlayer2point()];
    }

    private String getEqualPlayer1AndPlayer2() {
        return listaSets[getPlayer1point()];
    }

    public void player1Score(){
        player1point++;
    }
    
    public void player2Score(){
        player2point++;
    }

    public int getPlayer1point() {
        return player1point;
    }

    public int getPlayer2point() {
        return player2point;
    }


    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }


    public void wonPoint(String player) {
        if (player.equals(player1Name))
            player1Score();
        else
            player2Score();
    }
}
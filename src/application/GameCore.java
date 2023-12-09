package application;

public class GameCore {
    public static void playGame(){

//      Check that game is done? if it is break game loop
        while (!isGameEnd()) {


//          clear for new round
            setNewRound();

//          for loop in all agent to make play
            for (int i = 0; i < 5; i++) {
//                attacker start to play

//                defender start to play

            }

//          count new round
            Main.roundCount++;

        }
    }

    private static void setNewRound() {
        for (int i = 0; i < 5; i++) {

//                attacker clear stagge


//                defender clear stage

        }
    }

    private static boolean isGameEnd() {
        int totalRound = 13;
        return Main.roundCount >= totalRound || Main.isSpikedefuse;
    }
}

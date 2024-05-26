import java.util.ArrayList;

public class GameManager {

    String gameStatus = null;
    Boolean gameEnd = null;
//    static ArrayList<Player> players = new ArrayList<>(2);
    // TODO: I don't even think I need a players ArrayList anymore since I don't use the elements within them.
    //  Clean this up more later as well as teh setPlayers method. Hm. Wow.

    // Create a Player array to return both the current player and the other, non-current player.
    static Player[] switchPlayersArray = new Player[2];


    public GameManager() {
        // This is a fucking constructor.
    }

    // Temporary method that I may or may not use.
    public void startGame() {

    }

    public void getGameStatus(String status) {
        this.gameStatus = status;
    }

    /*
     * Conditions to end the game given the status as reported back from the GameInitializer class.
     */
    public Boolean gameOver(String gameStatus) {
        if (gameStatus.equals("Game Over")) {
            this.gameEnd = true;
        }
        else {
            this.gameEnd = false;
        }

        return gameEnd;
    }

    static Player[] switchTurn(Player currentPlayer, Player otherPlayer) {
        /* Swap by assigning the currentPlayer object to a temp Player object.
        * Then, assining currentPlayer to the otherPlayer since it is no longer their turn.
        * Finally, assign otherPlayer to the temp object, which holds the previous currentPlayer object.
        */
        Player hold = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = hold;

        switchPlayersArray[0] = currentPlayer;
        switchPlayersArray[1] = otherPlayer;

        return switchPlayersArray;
    }

    // Adds the Players into an arraylist for later use.
    public static void setPlayers(Player incomingPlayer) {
//        players.add(incomingPlayer);
    }

}

 /* TODO:
        - You will need to figure out how to handle moves when the currentPlayer cannot make a move a la Pokemon but that comes later.
     */


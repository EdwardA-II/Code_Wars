import java.util.ArrayList;

public class GameManager {

    String gameStatus = null;
    Boolean gameEnd = null;
    static ArrayList<Player> players = new ArrayList<>(2);
    static Player currPlayer = null; //TODO: Need to somehow assign currPlayer to Player1 (players.get(0)). But it's null here...

    public GameManager() {
        // This is a fucking constructor.
        Player placeholder = new Player();
        players.add(placeholder);
        currPlayer = players.get(0); // Adding a placeholder here but may need to refactor later...
    }

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

    static void switchTurn() {
        // If the current player is player 1, switch it to player 2.
        // If it isn't, then current player *is* player 2. So, switch it to player 1.

        if ( currPlayer == players.get(1) ) {
            GameManager.currPlayer = players.get(2); // Don't need to use GameManager, but it makes it
                                                        // more understandable to me.
        }
        else {
            GameManager.currPlayer = players.get(1);
        }


    }

    // Adds the Players into an arraylist for later use.
    public static void setPlayers(Player incomingPlayer) {
        players.add(incomingPlayer);
    }

    //TODO:
    /* Okay, here's my plan:
     * - Create a setPlayers method in this class and call it when prompting the players for their classes in the Game.java
     *   file. ( e.g.: setPlayers(Player 1) and ...(player2) ). [DONE]
     * - Create a static variable with the currentPlayer as the value. [DONE]
     * - "Simply" swap the currentPlayer's value with the other Player.
     * - At this point, there should be no need to track whoever went since it will always be the currentPlayer. Then you
     * keep swapping back and forth until game over.
     * - You will need to figure out how to handle moves when the currentPlayer cannot make a move a la Pokemon but that comes later.
     */







}

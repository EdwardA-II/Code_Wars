import java.util.ArrayList;

public class GameManager {

    String gameStatus = null;
    Boolean gameEnd = null;
    static Player whoseTurn = null; // Static so the current player's turn is always visible.
    static ArrayList<Characters> players = new ArrayList<>(2);


    public GameManager() {
        // This is a fucking constructor.
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

    static Player switchTurn(Player currentPlayer) {
        Player currPlayer = currentPlayer;

        return currPlayer;
    }

    /* Okay, here's my plan:
     * - Create a setPlayers method in this class and call it when prompting the players for their classes in the Game.java
     *   file. (e.g.: setPlayers(Player 1) and ...(player2).
     * - Create a static variable with the currentPlayer as the value.
     * - "Simply" swap the currentPlayer's value with the other Player.
     * - At this point, there should be no need to track whoever went since it will always be the currentPlayer. Then you
     * keep swapping back and forth until game over.
     * - You will need to figure out how to handle moves when the currentPlayer cannot make a move a la Pokemon but that comes later.
     */







}

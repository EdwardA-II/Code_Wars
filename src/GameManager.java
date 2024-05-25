import java.util.ArrayList;

public class GameManager {

    String gameStatus = null;
    Boolean gameEnd = null;
    static ArrayList<Player> players = new ArrayList<>(2);
    static Player currPlayer = null;

    // Create a Player array to return both the current player and the other, non-current player.
    static Player[] switchPlayersArray = new Player[2];

    //TODO: Need to somehow assign currPlayer to Player1 (players.get(0)). But it's null here...
    // Update: I don't think I even need this static variable since I use another variable in switchTurn...

    /* TODO: I am lowkey thinking that having both a players arraylist and a players array is somewhat redundant.
     * But I know I can worry about cleaning it up (refactor) later.
     * Maybe not since I need to add to it when asking for Players. Or maybe not since I can jsut do arr[i] instead.
     * But I would need to ask how many are playing and then take that value and use it to initialize an array of
     * that size. Yafeelme?
     */


    public GameManager() {
        // This is a fucking constructor.
        Player placeholder = new Player();
        players.add(placeholder);
        currPlayer = players.get(0); // Adding a placeholder here but may need to refactor later...
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
        // If the current player is player 1, switch currentPlayer to player 2.
        // If it isn't, then current player *is* player 2. So, switch it to player 1.

        Characters currentPlayerCharacter = currentPlayer.getPlayerCharacter(); // Might need to go deeper (pause) and compare character names as well. We shall see
        Characters player1Character = players.get(1).getPlayerCharacter();
        Characters player2Character = players.get(2).getPlayerCharacter();

//        if ( currentPlayerCharacter.equals(player1Character) ) {
//            GameManager.currPlayer = players.get(2);
        // Do I even need an if-else block...?
            // Update current and other player objects.
            Player hold = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = hold;

//        }
//        else {
//            GameManager.currPlayer = players.get(1);

//        }

        switchPlayersArray[0] = currentPlayer;
        switchPlayersArray[1] = otherPlayer;

        return switchPlayersArray;
    }

    // Adds the Players into an arraylist for later use.
    public static void setPlayers(Player incomingPlayer) {
        players.add(incomingPlayer);
    }

    /* TODO:
        Okay, here's my plan:
        * Create a setPlayers method in this class and call it when prompting the players for their classes in the Game.java
          file. ( e.g.: setPlayers(Player 1) and ...(player2) ). [DONE]
        * Create a static variable with the currentPlayer as the value. [DONE]
        * "Simply" swap the currentPlayer's value with the other Player.
        * - At this point, there should be no need to track whoever went since it will always be the currentPlayer. Then you
            keep swapping back and forth until game over.
        * - You will need to figure out how to handle moves when the currentPlayer cannot make a move a la Pokemon but that comes later.
     */







}

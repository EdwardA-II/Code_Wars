public class GameManager {

    String gameStatus = null;
    Boolean gameEnd = null;

    public GameManager() {
        // This is a fucking constructor.
    }

    public void startGame() {

    }

    public void getGameStatus(String status) {
        this.gameStatus = status;
    }

    // Conditions to end the game given the status as reported back from the GameInitializer class.
    public Boolean gameOver(String gameStatus) {
        if (gameStatus.equals("Game Over")) {
            this.gameEnd = true;
        }
        else {
            this.gameEnd = false;
        }

        return gameEnd;
    }




}

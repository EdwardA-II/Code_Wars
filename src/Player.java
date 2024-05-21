import java.util.ArrayList;

public class Player {
    // Random bs that will fill out later.
    String player = "";
    int move = 0;
    Characters playerCharacter = null;


    public Player() {
        // This is a constructor.
    }

    // Connect the Player to the Character they are playing as.
    public void assignCharacter(Characters playerCharacterChoice) {
        this.playerCharacter = playerCharacterChoice;

    }

    // Functionality to end the player's current turn.
    public void endTurn() {

    }



    // Maybe I also need some kind of "startTurn" functionality as well?



    
    
}
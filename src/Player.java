import java.util.ArrayList;

public class Player {
    Characters playerCharacter = null;
    String characterName = null;

    public Player() {
        // This is a constructor.
    }

    // Connect the Player to the Character they are playing as. Basically a setter lol.
    public void assignCharacter(Characters playerCharacterChoice) {
        this.playerCharacter = playerCharacterChoice;
    }

    public Characters getPlayerCharacter() {
        return this.playerCharacter;
    }

    public void setCharacterName(String characterName) {
        this.characterName = playerCharacter.getName();
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public Boolean characterIsDead(int characterHealth) {
        Boolean isDead = false;

        if (characterHealth <= 0) {
            isDead = true;

        }

        return isDead;
    }
}
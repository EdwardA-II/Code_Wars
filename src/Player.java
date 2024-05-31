public class Player {
    Characters playerCharacter = null;

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

    public String getCharacterName() {
        return playerCharacter.getName();
    }

    public Boolean characterIsDead(int characterHealth) {
        Boolean isDead = false;

        if (characterHealth <= 0) {
            isDead = true;

        }

        return isDead;
    }
}
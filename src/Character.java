/**
 * Character interface that contains a method "blueprint" for every Character.
 * 
 */
public interface Character { 
    
    /**
     * Gets the name of the Character.
     * 
     * @return The Character's name.
     */
    public String getName();

    /**
     * Sets the name of the Character.
     * 
     * @param inputName - The name of Character that the PLAYER wants to use. 
     * @return The Character's name.
     */
    public void setName(String inputName);
    
    /**
     * Attacks the player's OPPONENT.
     * 
     * @param opponentHealth - the OPPONENT's HEALTH.
     * @param opponentDefense - the OPPONENT'S DEFENSE.
     * 
     * @return The OPPONENT's health after attacking their HEALTH and DEFENSE. 
     */
    public int attack(int opponentHealth, int opponentDefense);

    /**
     * Attacks the player's OPPONENT with the Character's Special Ability.
     * 
     */
    public void specialAbility();

    /**
     * Takes in DAMAGE from the OPPONENT.
     * 
     * @param damageTaken - the DAMAGE done by the OPPONENT.
     * 
     * @return The PLAYER's health their OPPONENT's attack. 
     */
    public void takeDamage(int damageTaken);

    /**
     * Determines if the PLAYER is defeated or not.
     * 
     * @return isDefeated - if the PLAYER's health <= 0, PLAYER is defeated.
     */
    public boolean isDefeated();

    // ...some other methods
    
}

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

    /**
     * Returns the current health of the Character.
     * @return - Current health
     */
    public int getHealth();

    /**
     * Changes the health to the specified value.
     * @param newHealth - Value to set the Character's health to.
     */
    public void setHealth(int newHealth);

    /**
     * @return the defense
     */
    public int getDefense();

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense);
    
    /**
     * @return the accuracy
     */
    public int getAccuracy();

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(int accuracy);

    /**
     * @return the itemCapacity
     */
    public Item[] getItemCapacity();

    /**
     * @param itemCapacity the itemCapacity to set
     */
    public void setItemCapacity(int itemCapacity);

    /**
     * Provides us with the Character's current attack value
     */
    public int getAttack();

    /**
     * Changes the Character's attack value
     * Useful for when other Characters lower or alter the Character's attack power.
     * @param attack - The Character's attack value.
     */
    public void setAttack(int attack);
    
}

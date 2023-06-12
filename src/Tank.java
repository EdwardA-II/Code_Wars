
public class Tank  implements Character {
    String name = "";
    int health = 1500;
    int attack = 200; // Increase/decrease for balance?
    int defense = 750;
    int accuracy = 0; // Still need to figure out how to implement ACCURACY.
    Item[] itemSlots = new Item[2]; // May need to change to an ArrayList since it might change.

    public Tank(String characterName)
    {
        this.name = characterName;
    }

    /**
     * Gets the name of the Character.
     * 
     * @return The Character's name.
     */
    @Override
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name of the Character.
     * 
     * @param inputName - The name of Character that the PLAYER wants to use. 
     * @return The Character's name.
     */
    @Override
    public void setName(String inputName)
    {
        this.name = inputName;
        // Might not need this method since the Character name is set in the constructor.
        // And it doesn't change. Hmm...
    }

    /**
     * @return the health
     */
    @Override
    public int getHealth() 
    {
        return this.health;
    }

    /**
     * @param health the defense to set
     */
    @Override
    public void setHealth(int newHealth) 
    {
        this.health = newHealth;
    }

    /**
     * @return the defense
     */
    @Override
    public int getDefense() 
    {
        return this.defense;
    }

    /**
     * @param defense the defense to set
     */
    @Override
    public void setDefense(int defense) 
    {
        this.defense = defense;
    }

    /**
     * @return the accuracy
     */
    @Override
    public int getAccuracy() 
    {
        return this.accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    @Override
    public void setAccuracy(int accuracy) 
    {
        this.accuracy = accuracy;
    }

    /**
     * @return the itemCapacity
     */
    @Override
    public Item[] getItemCapacity() 
    {
        return this.itemSlots;
    }

    /**
     * @param itemCapacity the itemCapacity to the new total number of items the character can carry (capacity).
     */
    @Override
    public void setItemCapacity(int newItemCapacity) 
    {
        Item[] newItemSlots = new Item[newItemCapacity]; // Create a new array based on the new capacity.
        this.itemSlots = newItemSlots; // Assign the previous array to this new one.
    }
    
    /**
     * Takes in DAMAGE from the OPPONENT.
     * 
     * @param damageTaken - the DAMAGE done by the OPPONENT.
     * 
     * @return The PLAYER's health their OPPONENT's attack. 
     */
    @Override
    public void takeDamage(int damageTaken)
    {
        this.health = (this.health + defense) - damageTaken;
    }

    /**
     * Attacks the player's OPPONENT.
     * 
     * @param opponentHealth - the OPPONENT's HEALTH.
     * @param opponentDefense - the OPPONENT'S DEFENSE.
     * 
     * @return The OPPONENT's health after attacking their HEALTH and DEFENSE. 
     */
    @Override
    public int attack(int opponentHealth, int opponentDefense) 
    {
        // Call with the OPPONENT's current health (opponentName.getHealth)
        
        // Subtract from it and then return the remaining health.
        opponentHealth = (opponentHealth + opponentDefense) - this.attack;

        // For special moves where the damage is done directly to the health, call this method with 
        // opponentDefense = 0?

        return opponentHealth;
        
    }

    /**
     * Determines if the PLAYER is defeated or not.
     * 
     * @return isDefeated - if the PLAYER's health <= 0, PLAYER is defeated.
     */
    @Override
    public boolean isDefeated() {
        boolean defeated = false;

        if (this.health <= 0) {
            defeated = true;
        }

        return defeated;
    }

    /**
     * Provides us with the Character's current attack value
     * @param attack - The Character's current attack value.
     */
    public int getAttack(int attack)
    {
        return this.attack;
    }

    /**
     * Changes the Character's attack value
     * Useful for when other Characters lower or alter the Character's attack power.
     * @param attack - The Character's attack value.
     */
    public void setAttack(int newAttack)
    {
        this.attack = newAttack
    }


    /**
     * Attacks the player's OPPONENT with the Character's Special Ability.
     * 
     */
    @Override
    public void specialAbility() 
    {
        // Hmm... how do I implement this...?
        
    }


}


public class Tank  implements Character {
    String name = "";
    int health = 1500;
    int attack = 200; // Increase/decrease for balance?
    int defense = 750;
    int accuracy = 0; // Still need to figure out how to implement ACCURACY.
    Item[] itemCapacity = new Item[2]; // May need to change to an ArrayList since it might change.

    public Tank(String characterName)
    {
        this.name = characterName;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(String inputName)
    {
        this.name = inputName;
        // Might not need this method since the Character name is set in the constructor.
        // And it doesn't change. Hmm...
    }

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

    @Override
    public void specialAbility() 
    {
        // Hmm... how do I implement this...?
        
    }

    @Override
    public void takeDamage(int damageTaken)
    {
        this.health = (this.health + defense) - damageTaken;
    }

    

    @Override
    public boolean isDefeated() {
        boolean defeated = false;

        if (this.health <= 0) {
            defeated = true;
        }

        return defeated;
    }

    /**
     * @return the health
     */
    public int getHealth() 
    {
        return this.health;
    }

    /**
     * @param health the defense to set
     */
    public void setHealth(int health) 
    {
        this.health = health;
    }

    /**
     * @return the defense
     */
    public int getDefense() 
    {
        return this.defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) 
    {
        this.defense = defense;
    }

    /**
     * @return the accuracy
     */
    public int getAccuracy() 
    {
        return this.accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(int accuracy) 
    {
        this.accuracy = accuracy;
    }

    /**
     * @return the itemCapacity
     */
    public Item[] getItemCapacity() 
    {
        return this.itemCapacity;
    }

    /**
     * @param itemCapacity the itemCapacity to set
     */
    public void setItemCapacity(Item[] itemCapacity) 
    {
        this.itemCapacity = itemCapacity;
    }
    
    
}

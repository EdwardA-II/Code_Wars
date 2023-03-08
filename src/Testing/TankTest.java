import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

// import static org.junit.

public class TankTest {
    
    @Test
    public void takeDamage_150_ShouldEqual2100()
    {
        Character chara = new Tank("test");
        chara.takeDamage(150);
        assertEquals(2100, chara.getHealth());
    }

    @Test
    public void attack_200_ShouldEqual1650()
    {
        // Assuming the Opponent's Health is 1500 and Defense is 300...
        Character chara = new Tank("test");
        int oppHealth = chara.attack(1500, 300);
        assertEquals(1600, oppHealth);

    }

}
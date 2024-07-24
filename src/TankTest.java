import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TankTest {
    
    @Test
    public void takeDamage_150_ShouldEqual2100()
    {
        Characters chara = new Tank("test");
        chara.takeDamage(150);
        assertEquals(2100, chara.getHealth());
    }

    @Test
    public void attack_200_ShouldEqual1650()
    {
        // Assuming the Opponent's Health is 1500 and Defense is 300...
        Characters chara = new Tank("test");
        double oppHealth = chara.attack(1500, 300);
        assertEquals(1600, oppHealth);

    }

    @Test
    public void isDefeated_healthIs0_ShouldBeTrue()
    {
        Characters chara = new Tank("Test");
        chara.setHealth(0);
        String falseMessage = "Should be true because health = 0";
        assertTrue(falseMessage, chara.isDefeated());
    }

    @Test
    public void isDefeated_healthIsNegative_ShouldBeTrue()
    {
        Characters chara = new Tank("Test");
        chara.setHealth(-15);
        String falseMessage = "Should be true because health < 0";
        assertTrue(falseMessage, chara.isDefeated());
    }

    @Test
    public void isDefeated_healthIs100_ShouldBeFalse()
    {
        Characters chara = new Tank("Test");
        chara.setHealth(100);
        String falseMessage = "Should be false because health > 0";
        assertFalse(falseMessage, chara.isDefeated());
    }

    // Placeholder for the specialAbility test method.
    // @Test
    // public void specialAbility_someCondition_someExpectedResult()
    // {
    //     Characters chara = new Tank("Test");
    //     chara.specialAbility();
    //     String falseMessage = "Something, something...";
    //     assertEqual(falseMessage, chara.isDefeated());
    // }

}
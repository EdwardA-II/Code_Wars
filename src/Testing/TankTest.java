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

}
package entity_tests;

import entity.monster.Monster;
import entity.monster.Steal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MonsterTest {
    Monster monster;
    Monster monster2;

    @BeforeEach
    @DisplayName("Set up a Monster with a power and fight summary")
    void setUp(){
        int[] attack = new int[]{1, 1};
        int[] health = new int[]{1, 1};
        HashMap<String, int[]> stats = new HashMap<>();
        stats.put("Attack", attack);
        stats.put("Health", health);
        monster = new Monster("Slime", "Basic", stats, true, new Steal());
        monster2 = new Monster("Friendly Bear", "Tamable", stats, false);
    }

    @Test
    @DisplayName("Test getter methods")
    void testGetters(){
        Assertions.assertAll("Check that all getter methods return the correct values",
                () -> Assertions.assertEquals("Slime", monster.getName()),
                () -> Assertions.assertEquals("Basic", monster.getType()),
                () -> Assertions.assertEquals(1, monster.getAttack()),
                () -> Assertions.assertEquals(1, monster.getHealth()),
                () -> Assertions.assertTrue(monster.isHasPower()),
                () -> Assertions.assertTrue(monster.getPower() instanceof Steal));
    }

    @Test
    @DisplayName("Test toString of Monster")
    void testToString(){
        Assertions.assertEquals("Slime", monster.toString());
    }

    @Test
    @DisplayName("Test getPowerString when Monster has a power")
    void testGetPowerString(){
        Assertions.assertEquals("Steals essence", monster.getPowerString());
    }

    @Test
    @DisplayName("Test getPowerString when Monster does not have a power")
    void testGetPowerStringNone(){
        Assertions.assertEquals("None", monster2.getPowerString());
    }
}

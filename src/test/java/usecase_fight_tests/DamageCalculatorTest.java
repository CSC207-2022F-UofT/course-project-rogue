package usecase_fight_tests;

import entity.*;
import entity.Monster.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.DamageCalculator;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class DamageCalculatorTest {

    // Monster variables
    int[] atkStat = new int[]{10, 10};
    int[] hpStat = new int[]{10, 10};
    HashMap<String, int[]> stats = new HashMap<>(Map.ofEntries(
            entry("Attack", atkStat),
            entry("Health", hpStat)));
    Monster monster = new Monster("1", "T", stats, false);

    /** Makes a new Player with the given equipment stat value. */
    private Player makePlayerStats(int n){
        int[] location = new int[]{1, 2};
        Weapon sword = new Weapon("Sword", n);
        Armor armor = new Armor("Shield", n);
        BasicEquipmentSlots equipment = new BasicEquipmentSlots(sword, armor);
        Collectible essence = new Collectible("Essence", 10);
        Collectible artifact = new Collectible("Artifact");
        CollectibleInventory collect = new CollectibleInventory("1", essence, artifact);
        return new Player(5, 5, collect, equipment, location);
    }


    @Test
    @DisplayName("Test DamageCalculator Construction")
    void testConstructor(){
        Player player = makePlayerStats(5);
        DamageCalculator dc = new DamageCalculator(monster, player);
        Assertions.assertEquals(monster, dc.getMonster());
        Assertions.assertEquals(player, dc.getPlayer());
    }

    @Test
    @DisplayName("Test Basic Calculate")
    void testCalculate(){
        Player player = makePlayerStats(5);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Test Calculate when Damage Reduction is greater than Monster Attack")
    void testCalculateGreater(){
        Player player = makePlayerStats(10);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Test Calculate when Damage Reduction is equal to Monster Attack")
    void testCalculateEqual(){
        Player player = makePlayerStats(15);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(0, result);
    }
}

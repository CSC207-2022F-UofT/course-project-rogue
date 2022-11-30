package usecase_fight_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.monster.Monster;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.DamageCalculator;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class DamageCalculatorTest {


    /** Makes a new Monster with the given attack and health. */
    private Monster makeMonster(int attack, int health){
        int[] atkStat = new int[]{attack, attack};
        int[] hpStat = new int[]{health, health};
        HashMap<String, int[]> stats = new HashMap<>(Map.ofEntries(
                entry("Attack", atkStat),
                entry("Health", hpStat)));
        return new Monster("1", "T", stats, false);
    }


    /** Makes a new Player with the given base stats and equipment stats. */
    private Player makePlayerStats(int health, int attack, int atk){
        int[] location = new int[]{1, 2};
        Weapon sword = new Weapon("Sword", atk);
        Armor armor = new Armor("Shield", 5);
        BasicEquipmentSlots equipment = new BasicEquipmentSlots(sword, armor);
        Collectible essence = new Collectible("Essence", 10);
        Collectible artifact = new Collectible("Artifact");
        CollectibleInventory collect = new CollectibleInventory("1", essence, artifact);
        return new Player(health, attack, collect, equipment, location);
    }


    @Test
    @DisplayName("Test DamageCalculator Construction")
    void testConstructor(){
        Monster monster = makeMonster(10, 10);
        Player player = makePlayerStats(5, 5, 5);
        DamageCalculator dc = new DamageCalculator(monster, player);
        Assertions.assertEquals(monster, dc.getMonster());
        Assertions.assertEquals(player, dc.getPlayer());
    }

    @Test
    @DisplayName("Test Calculate with 1 turn.")
    void testCalculateSingle(){
        Monster monster = makeMonster(10, 10);
        Player player = makePlayerStats(5, 5, 5);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(5, result);
        // patk = 5 + 5, matk = 5, php = 5, mhp = 10
        // phits = 5/5 = 1
        // mhits = 10 / 10 = 1
        // for 1 turn
        // damage = 5 * 1
    }

    @Test
    @DisplayName("Test Calculate when there is less than one turn in a fight.")
    void testCalculateLess(){
        Monster monster = makeMonster(6, 6);
        Player player = makePlayerStats(5, 5, 5);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(1, result);
        // patk = 5 + 5 = 10, matk = 6 - 5 = 1, php = 5, mhp = 6
        // phits = 5/1 = 5
        // mhits = 6 / 10 = 0.6
        // turns = 1
        // damage = 1 * 1 = 1
    }

    @Test
    @DisplayName("Test Calculate when there is more than one turn in the fight.")
    void testCalculateMore(){
        Monster monster = makeMonster(10, 30);
        Player player = makePlayerStats(10, 10, 5);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(10, result);
        // pAtk = 10 + 5, pHp = 10, mAtk = 10 - 5 = 5, mHp = 30
        // phits = 10 / 5 = 2
        // mhits = 30 / 15 = 2
        // turns = 2
        // damage = 2*5 = 10
    }

    @Test
    @DisplayName("Test Calculate when Player total attack == 0 and there is less than one turn in the fight.")
    void testCalculatePlayerZeroLess(){
        Monster monster = makeMonster(15, 15);
        Player player = makePlayerStats(2, 0, 0);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(10, result);
        // pAtk = 0, mAtk = 10, mHp = 15, pHp = 2
        // pHits = 2/10 = 0.2
        // mHits = undefined (pAtk == 0)
        // turns = 1
        // damage = 1*10 = 10
    }


    @Test
    @DisplayName("Test Calculate when Player total attack <= 0 and there is one turn in the fight.")
    void testCalculatePlayerZeroSingle(){
        Monster monster = makeMonster(10, 15);
        Player player = makePlayerStats(5, 0, 0);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(5, result);
        // pAtk = 0, mAtk = 5, mHp = 15, pHp = 5
        // pHits = 5 / 5 = 1
        // mHits = undefined (pAtk == 0)
        // turns = 1
        // damage = 1*5 = 5
    }

    @Test
    @DisplayName("Test Calculate when Player total attack <= 0 and there is more than one turn in the fight.")
    void testCalculatePlayerZeroMore(){
        Monster monster = makeMonster(10, 15);
        Player player = makePlayerStats(15, 0, 0);
        DamageCalculator dc = new DamageCalculator(monster, player);
        int result = dc.calculate();
        Assertions.assertEquals(15, result);
        // pAtk = 0, mAtk = 5, mHp = 15, pHp = 2
        // pHits = 15 / 5 = 3
        // mHits = undefined (pAtk == 0)
        // turns = 3
        // damage = 3*5 = 15
    }

    @Test
    @DisplayName("Test that Calculate always returns zero when Monster attack is <= 0 no matter how many turns.")
    void testCalculateMonsterZero(){
        Player player = makePlayerStats(10, 5, 5);
        Monster mon1 = makeMonster(5, 2); // 0.2 turns
        Monster mon2 = makeMonster(5, 10); // 1 turn
        Monster mon3 = makeMonster(5, 20); // 2 turns
        DamageCalculator dc1 = new DamageCalculator(mon1, player);
        DamageCalculator dc2 = new DamageCalculator(mon2, player);
        DamageCalculator dc3 = new DamageCalculator(mon3, player);
        Assertions.assertTrue(dc1.calculate() == 0 && dc2.calculate() == 0 && dc3.calculate() == 0);
    }
}

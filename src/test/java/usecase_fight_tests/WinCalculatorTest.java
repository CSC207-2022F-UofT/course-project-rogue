package usecase_fight_tests;

import entity.*;
import entity.Monster.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.WinCalculator;

import java.util.HashMap;

public class WinCalculatorTest {

    /** Makes a monster with the given attack and health. */
    private Monster makeMonster(int atk, int hp){
        int[] attack = new int[]{atk, atk};
        int[] health = new int[]{hp, hp};
        HashMap<String, int[]> stats = new HashMap<>();
        stats.put("Attack", attack);
        stats.put("Health", health);
        return new Monster("Slime", "Normal", stats, false);
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
    @DisplayName("Test Win Calculator Construction")
    void testConstruction(){
        Player player = makePlayerStats(10, 10, 5);
        Monster monster = makeMonster(15, 15);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(player, wc.getPlayer());
        Assertions.assertEquals(monster, wc.getMonster());
    }

    @Test
    @DisplayName("Test Calculate when there is no difference in the amount of hits required " +
            "to kill the Player and the Monster")
    void testCalculateEqual(){
        Player player = makePlayerStats(10, 10, 5);
        Monster monster = makeMonster(15, 15);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(50, wc.calculate());
        // result is 50 chance
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Player is greater than that of Monster.")
    void testCalculateGreater(){
        Player player = makePlayerStats(10, 10, 5);
        Monster monster = makeMonster(7, 15);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(70, wc.calculate());
        // result win chance must be greater than 50
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Player is less than that of Monster.")
    void testCalculateLess(){
        Player player = makePlayerStats(3, 5, 0);
        Monster monster = makeMonster(10, 20);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(33, wc.calculate());
        // result win chance must be less than 50
    }


    @Test
    @DisplayName("Test Calculate when the total attack of Monster is 0.")
    void testCalculateAbsoluteHundred(){
        Player player = makePlayerStats(10, 10, 0);
        Monster monster = makeMonster(5, 10);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(100, wc.calculate());
        // result win chance must be 100 (monster cannot kill player)
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Monster is much less than that of Player.")
    void testCalculateHundred(){
        Player player = makePlayerStats(20, 5, 5);
        Monster monster = makeMonster(7, 1);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(100, wc.calculate());
        // result win chance must be 100
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Player much less than that of Monster.")
    void testCalculateZero(){
        Player player = makePlayerStats(1, 1, 1);
        Monster monster = makeMonster(15, 22);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(0, wc.calculate());
        // result win chance is 0.
    }

    @Test
    @DisplayName("Test Calculate when Player attack is 0.")
    void testCalculateAbsoluteZero(){
        Player player = makePlayerStats(10, 0, 0);
        Monster monster = makeMonster(15, 10);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(0, wc.calculate());
        // result win chance is 0 (monster never killed)
    }

    @Test
    @DisplayName("Test Calculate when Monster attack and Player attack are both zero.")
    void testCalculateStale(){
        Player player = makePlayerStats(10, 0, 0);
        Monster monster = makeMonster(5, 10);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(0, wc.calculate());
        // result win chance is 0 - stalemate
    }

}

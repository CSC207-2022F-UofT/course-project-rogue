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
        // pAtk = 10 + 5 = 15, pHp = 10, mAtk = 15 - 5 = 10, mHp = 15
        // pHits = 10 / 10 = 1
        // mHits = 15 / 15 = 1
        // bonus = (1 - 1)*5
        // win chance = 50 + 0
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Player is greater than that of Monster.")
    void testCalculateGreater(){
        Player player = makePlayerStats(10, 10, 5);
        Monster monster = makeMonster(7, 15);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(70, wc.calculate());
        // result win chance must be greater than 50

        // pAtk = 10 + 5 = 15, pHp = 10, mAtk = 7 - 5 = 2, mHp = 15
        // pHits = 10 / 2 = 5
        // mHits = 15 / 15 = 1
        // bonus = (5 - 1)*5 = 20
        // win chance = 50 + 20 = 70
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Player is less than that of Monster.")
    void testCalculateLess(){
        Player player = makePlayerStats(3, 5, 0);
        Monster monster = makeMonster(10, 20);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(33, wc.calculate());
        // result win chance must be less than 50

        // pAtk = 5 + 0 = 5, pHp = 3, mAtk = 10 - 5 = 5, mHp = 20
        // pHits = 3 / 5 = 0.6
        // mHits = 20 / 5 = 4
        // bonus = (0.6 - 4)*5 = -17
        // win chance = 50 + (-17) = 33
    }


    @Test
    @DisplayName("Test Calculate when the total attack of Monster is 0.")
    void testCalculateAbsoluteHundred(){
        Player player = makePlayerStats(10, 10, 0);
        Monster monster = makeMonster(5, 10);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(100, wc.calculate());
        // result win chance must be 100 (player always wins cause monster cannot kill player)

        // pAtk = 0 + 0 = 0, pHp = 10, mAtk = 15 - 5 = 10, mHp = 10
        // pHits = 10 / 0 = undefined
        // mHits = 10 / 10 = 1
        // player never killed
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Monster is much less than that of Player.")
    void testCalculateHundred(){
        Player player = makePlayerStats(20, 5, 5);
        Monster monster = makeMonster(7, 1);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(100, wc.calculate());
        // result win chance must be 100 (player always wins cause monster cannot kill player)

        // pAtk = 5 + 5 = 10, pHp = 20, mAtk = 7 - 5 = 2, mHp = 1
        // pHits = 20 / 2 = 10
        // mHits = 1 / 10 = 0.1
        // bonus = (10 - 0.1)*5 = 49.5
        // win chance = 50 + 49.5 = 99.5 to 100
    }

    @Test
    @DisplayName("Test Calculate when the number of hits required to kill Player much less than that of Monster.")
    void testCalculateZero(){
        Player player = makePlayerStats(1, 1, 1);
        Monster monster = makeMonster(15, 22);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(100, wc.calculate());
        // pAtk = 1 + 1 = 2, pHp = 1, mAtk = 15 - 5 = 10, mHp = 22
        // pHits = 1 / 10 = 0.1
        // mHits = 22 / 2 = 11
        // bonus = (0.1 - 11)*5 = -54.5
        // win chance = 50 + (-54.5) = -4.5, returns 0

        // result win chance is 0.
    }

    @Test
    @DisplayName("Test Calculate when Player attack is 0.")
    void testCalculateAbsoluteZero(){
        Player player = makePlayerStats(10, 0, 0);
        Monster monster = makeMonster(15, 10);
        WinCalculator wc = new WinCalculator(monster, player);
        Assertions.assertEquals(0, wc.calculate());
        // result win chance is 0.

        // pAtk = 0 + 0 = 0, pHp = 10, mAtk = 15 - 5 = 10, mHp = 10
        // pHits = 10 / 10 = 1
        // mHits = 10 / 0 = undefined
        // monster never killed
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

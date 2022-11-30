package usecase_fight_tests;

import entity.item.Equipment;
import entity.monster.Monster;
import entity.item.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.FightSummary;

import java.util.HashMap;

public class FightSummaryTest {
    FightSummary fs1;
    FightSummary fs2;
    Equipment equipment;
    Monster monster;

    @BeforeEach
    @DisplayName("Set up a Monster and FightSummary")
    void setUP(){
        int[] attack = new int[]{1, 1};
        int[] health = new int[]{1, 1};
        HashMap<String, int[]> stats = new HashMap<>();
        stats.put("Attack", attack);
        stats.put("Health", health);
        monster = new Monster("Slime", "Basic", stats, false);

        equipment = new Weapon("Sharp stick", 5);

        fs1 = new FightSummary(monster, 5, 60, 5);
        fs2 = new FightSummary(monster, 6, 0, 0, equipment);
    }

    @Test
    @DisplayName("Test FightSummary Getters")
    void testGet(){
        Assertions.assertAll("Checks that all getter methods return the correct value",
                () -> Assertions.assertEquals(5, fs1.getAmountDrop()),
                () -> Assertions.assertEquals(60, fs1.getWinChance()),
                () -> Assertions.assertEquals(5, fs1.getDamage()),
                () -> Assertions.assertEquals(equipment, fs2.getEquipment()),
                () -> Assertions.assertEquals(monster, fs2.getMonster()));
    }

    @Test
    @DisplayName("Test getStaleMate Method")
    void testGetStaleMate(){
        Assertions.assertAll("Checks that getStaleMate returns true iff win chance and damage is 0",
                () -> Assertions.assertTrue(fs2.getStaleMate()),
                () -> Assertions.assertFalse(fs1.getStaleMate()));

    }
}

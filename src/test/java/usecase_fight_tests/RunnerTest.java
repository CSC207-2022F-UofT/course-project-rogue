package usecase_fight_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.monster.Monster;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.FightSummary;
import usecase_fight.states.Runner;

import java.util.HashMap;

public class RunnerTest {

    final Collectible essence = new Collectible("Essence", 10);
    final Collectible artifact = new Collectible("Artifact", 1);
    final CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    final Armor armor = new Armor("Padded Jacket", 50);
    final Weapon weapon = new Weapon("Plastic Sword", 50);
    final BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
    Runner runner;
    Player player;
    Monster monster;
    FightSummary fs;

    @BeforeEach
    @DisplayName("SetUp Runner and Player with FightSummary")
    void setUp(){
        int[] attack = new int[]{1, 1};
        int[] health = new int[]{1, 1};
        HashMap<String, int[]> stats = new HashMap<>();
        stats.put("Attack", attack);
        stats.put("Health", health);
        monster = new Monster("Slime", "Basic", stats, false);
        fs = new FightSummary(monster, 5, 100, 20);

        player = new Player(20, 5, inventory, equipmentSlots);
        player.setFight(fs);
        player.setFighting(true);
        player.setCanMove(false);

        runner = new Runner(player);
    }

    @Test
    @DisplayName("Test that flee changes Player states")
    void testChangeStates(){
        runner.takePath();
        Assertions.assertAll("Check that Player is no longer Fighting and can move",
                () -> Assertions.assertTrue(player.getCanMove()),
                () -> Assertions.assertFalse(player.getFighting()));
    }
}

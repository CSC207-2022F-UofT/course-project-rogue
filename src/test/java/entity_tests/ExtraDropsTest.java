package entity_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.monster.ExtraDrops;
import entity.monster.Monster;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.FightSummary;

import java.util.HashMap;

public class ExtraDropsTest {
    final Collectible essence = new Collectible("Essence", 10);
    final Collectible artifact = new Collectible("Artifact", 0);
    final CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    final Armor armor = new Armor("Padded Jacket", 50);
    final Weapon weapon = new Weapon("Plastic Sword", 50);
    final BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
    Player player;
    ExtraDrops extraDrops;
    FightSummary fs;

    private void makeSummary(int essence){
        int[] attack = new int[]{1, 1};
        int[] health = new int[]{1, 1};
        HashMap<String, int[]> stats = new HashMap<>();
        stats.put("Attack", attack);
        stats.put("Health", health);
        Monster monster = new Monster("Slime", "Basic", stats, false);
        fs = new FightSummary(monster, essence, 100, 5);
    }

    @BeforeEach
    @DisplayName("Set up an extra drops power")
    void setUp(){
        extraDrops = new ExtraDrops();
        player = new Player(20, 5, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test usePower when dropped essence is 0")
    void testUsePowerZero(){
        makeSummary(0);
        player.setFight(fs);
        String result = extraDrops.usePower(player);
        Assertions.assertEquals("0 extra essence dropped!", result);
    }

    @Test
    @DisplayName("Test usePower when dropped essence is greater than 0")
    void testUsePowerGreater(){
        makeSummary(5);
        player.setFight(fs);
        String result = extraDrops.usePower(player);
        Assertions.assertEquals("5 extra essence dropped!", result);
    }

    @Test
    @DisplayName("Test toString")
    void testToString(){
        String result = extraDrops.toString();
        Assertions.assertEquals("Drops 2x essence", result);
    }
}

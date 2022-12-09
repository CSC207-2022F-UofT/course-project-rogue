package usecase_fight_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.player.Player;
import interface_adapters.OutputBoundary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.states.AfterFight;
import usecase_fight.states.FightPath;

public class AfterFightTest {

    final Collectible essence = new Collectible("Essence", 10);
    final Collectible artifact = new Collectible("Artifact", 1);
    final CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    final Armor armor = new Armor("Padded Jacket", 50);
    final Weapon weapon = new Weapon("Plastic Sword", 50);
    final BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
    Player player;
    AfterFight af;

    @BeforeEach
    @DisplayName("Set up a Monster, Player and different FightSummary.")
    void setUP(){
        player = new Player(20, 5, inventory, equipmentSlots);
        player.setFighting(true);
        player.setCanMove(false);

        af = new AfterFight(player);

        OutputBoundary outputBoundary = new OutputBoundary() {
            @Override
            public void updateText(String line1, String line2, String line3, String line4) {}
            @Override
            public void updateHp(int hp) {}
            @Override
            public void updateEssenceCnt(int cnt) {}
            @Override
            public void updateArtifact(int cnt) {}
            @Override
            public void updatePlayerLocation(int[] location) {}
            @Override
            public void updateWin() {}
            @Override
            public void updateDead() {}
            @Override
            public void updateMap(String[][] map) {}
        };
        FightPath.setOutputBoundary(outputBoundary);
    }


    @Test
    @DisplayName("Test that AfterFight changes the state of Player to canHeal and canUpgrade, and change fighting to" +
            "false")
    void testChangeState(){
        af.takePath();
        Assertions.assertAll("Check that Player is no longer Fighting and can heal and upgrade. Player can still" +
                        " cannot move",
                () -> Assertions.assertFalse(player.getCanMove()),
                () -> Assertions.assertFalse(player.getFighting()),
                () -> Assertions.assertTrue(player.getCanHeal()),
                () -> Assertions.assertTrue(player.getCanUpgrade()));
    }
}

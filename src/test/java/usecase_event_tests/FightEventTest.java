package usecase_event_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.player.Player;
import file_reader.GameFileReader;
import interface_adapters.OutputBoundary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_event.Event;
import usecase_event.FightEvent;
import usecase_factories.MonsterFactory;

public class FightEventTest {
    final Collectible essence = new Collectible("Essence", 100);
    final Collectible artifact = new Collectible("Artifact", 1);
    final CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    final Armor armor = new Armor("Chain Mail", 5);
    final Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    final BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    Player player;
    FightEvent event;
    final GameFileReader fr = new GameFileReader("data_base/Monster.json");

    @BeforeEach
    @DisplayName("SetUp Player and FightEvent")
    void setUp(){
        event = new FightEvent();
        player = new Player(5, 5, inventory, equipmentSlots);
        MonsterFactory.setFileReader(fr);
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
        Event.setOutputBoundary(outputBoundary);
    }

    @Test
    @DisplayName("Test that Trigger creates a new FightSummary for Player and changes Player states")
    void testTrigger(){
        Assertions.assertNull(player.getFight()); // check that no fight yet
        event.trigger(player);
        Assertions.assertAll("Check that Player has fight summary and correct states",
                () -> Assertions.assertTrue(player.getFighting()),
                () -> Assertions.assertFalse(player.getCanMove()),
                () -> Assertions.assertNotNull(player.getFight()));
    }

    @Test
    @DisplayName("Test Enter")
    void testEnter(){
        Assertions.assertTrue(event.enter(player));
    }
}

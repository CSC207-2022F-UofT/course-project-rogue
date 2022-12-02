package usecase_event_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.player.Player;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_event.FightEvent;
import usecase_factories.EquipmentFactory;
import usecase_factories.MonsterFactory;
import user_interface.View;
import user_interface.Visual;

public class FightEventTest {
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 1);
    CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    int[] location = new int[]{0, 0};
    Player player;
    FightEvent event;
    GameFileReaderInterface fr = new GameFileReader("data_base/Equipment.json");
    GameFileReaderInterface fr2 = new GameFileReader("data_base/Monster.json");
    MonsterFactory mf = new MonsterFactory(fr2);
    EquipmentFactory ef = new EquipmentFactory(fr);


    @BeforeEach
    @DisplayName("SetUp Player and FightEvent")
    void setUp(){
        event = new FightEvent(new Visual(new View()), mf, ef);
        player = new Player(5, 5, inventory, equipmentSlots, location);
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

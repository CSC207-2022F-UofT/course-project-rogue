package usecase_playeractions_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_event.ArtifactEvent;
import usecase_event.Event;
import usecase_event.WallEvent;
import usecase_playeractions.Map;
import user_interface.View;
import user_interface.Visual;

public class MapTest {

    Map map;
    Player player;
    int maxHP = 100;
    int atkPt = 10;
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 0);
    CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    int[] location = new int[]{0, 0};


    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        map = new Map();
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test Move")
    void testMove(){
        ArtifactEvent ae = new ArtifactEvent();
        map.setBoard(ae,0,1);
        map.move(player,0,1);
        Assertions.assertEquals(1, player.getPlayerLocation()[1]);
        Assertions.assertEquals(1, player.getArtifact().getNum());
        map.setBoard(new WallEvent(),0,2);
        map.move(player,0,1);
        Assertions.assertEquals(1, player.getPlayerLocation()[1]);
    }

}



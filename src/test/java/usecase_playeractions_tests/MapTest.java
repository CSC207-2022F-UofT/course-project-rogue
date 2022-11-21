package usecase_playeractions_tests;

import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_event.ArtifactEvent;
import usecase_event.EssenceEvent;
import usecase_event.WallEvent;
import usecase_playeractions.Map;

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
        player = new Player(maxHP, atkPt, inventory, equipmentSlots, location);
    }

    @Test
    @DisplayName("Test Move")
    void testMove(){
        map.setBoard(new ArtifactEvent(),0,1);
        map.move(player,0,1);
        Assertions.assertEquals(1, player.getPlayerLocation()[1]);
        Assertions.assertEquals(1, player.getCollectible("Artifact").getNum());
        map.setBoard(new WallEvent(),0,2);
        map.move(player,0,1);
        Assertions.assertEquals(1, player.getPlayerLocation()[1]);
    }

}


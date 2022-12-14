package usecase_fight_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Equipment;
import entity.item.Weapon;
import entity.monster.Monster;
import entity.player.Player;
import interface_adapters.OutputBoundary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.FightSummary;
import usecase_fight.states.FightPath;
import usecase_fight.states.Fighter;

import java.util.HashMap;

public class FighterTest {

    final Collectible essence = new Collectible("Essence", 10);
    final Collectible artifact = new Collectible("Artifact", 1);
    final CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    final Armor armor = new Armor("Padded Jacket", 50);
    final Weapon weapon = new Weapon("Plastic Sword", 50);
    final BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
    Player player;
    FightSummary fs; // 100 win, 5dmg, 5essence, stronger ARMOR
    FightSummary fs1; // 100 win, 5dmg, 5essence, stronger equipment
    FightSummary fs2; // 100 win, 5 dmg, 5essence, weaker equipment
    FightSummary fs3; // 100 win, 5dmg, 5essence, no equipment
    FightSummary fs4; // 0 win, 5dmg, 5essence, equipment
    FightSummary fs5; // 0 win, player hp, 5essence, equipment
    FightSummary fs6; // tie
    Monster monster;
    Equipment eq1;
    Equipment eq2;
    Equipment eq3;
    Fighter fighter;

    /** Set the given Player with the given summary. */
    private void setSummary(Player player, FightSummary summary){
        player.setFight(summary);
    }


    @BeforeEach
    @DisplayName("Set up a Monster, Player and different FightSummary.")
    void setUP(){
        int[] attack = new int[]{1, 1};
        int[] health = new int[]{1, 1};
        HashMap<String, int[]> stats = new HashMap<>();
        stats.put("Attack", attack);
        stats.put("Health", health);
        monster = new Monster("Slime", "Basic", stats, false);

        player = new Player(20, 5, inventory, equipmentSlots);
        player.setFighting(true);
        player.setCanMove(false);

        eq1 = new Weapon("Sword", 100);
        eq2 = new Weapon("Stick", 5);
        eq3 = new Armor("Bag", 100);

        fs = new FightSummary(monster, 5, 100, 5, eq3);
        fs1 = new FightSummary(monster, 5, 100, 5, eq1);
        fs2 = new FightSummary(monster, 5, 100, 5, eq2);
        fs3 = new FightSummary(monster, 5, 100, 5);
        fs4 = new FightSummary(monster, 5, 0, 5, eq1);
        fs5 = new FightSummary(monster, 5, 0, 20, eq3);
        fs6 = new FightSummary(monster, 5, 0, 0, eq2);

        fighter = new Fighter(player);

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
    @DisplayName("Test fight when Player wins")
    void fightWin(){
        this.setSummary(player, fs3);
        // check hp same, 5essence gained, equipment same
        Equipment oldArmor = player.getArmor();
        Equipment oldWeapon = player.getWeapon();
        int oldHP = player.getCurrHitPoint();
        fighter.takePath();
        Assertions.assertAll("Check that Player HP and equipment does not change and 5 essence",
                () -> Assertions.assertEquals(oldArmor, player.getArmor()),
                () -> Assertions.assertEquals(oldWeapon, player.getWeapon()),
                () -> Assertions.assertEquals(oldHP, player.getCurrHitPoint()),
                () -> Assertions.assertEquals(15, player.getEssence().getNum()));
    }

    @Test
    @DisplayName("Test fight when Player wins and exchanges a Weapon")
    void fightExchangeWeapon(){
        // check weapon is new weapon
        this.setSummary(player, fs1);
        Equipment oldWeapon = player.getWeapon();
        fighter.takePath();
        Assertions.assertEquals(eq1, player.getWeapon());
        Assertions.assertNotEquals(oldWeapon, player.getWeapon());
    }

    @Test
    @DisplayName("Test fight when Player wins and does not exchange a Weapon")
    void fightNoExchange(){
        // check weapon is same
        this.setSummary(player, fs2);
        Equipment oldWeapon = player.getWeapon();
        fighter.takePath();
        Assertions.assertEquals(oldWeapon, player.getWeapon());
    }

    @Test
    @DisplayName("Test fight when Player wins and exchanges Armor")
    void fightExchangeArmor(){
        // check new armor
        this.setSummary(player, fs);
        Equipment oldArmor = player.getArmor();
        fighter.takePath();
        Assertions.assertEquals(eq3, player.getArmor());
        Assertions.assertNotEquals(oldArmor, player.getArmor());
    }

    @Test
    @DisplayName("Test fight when Player loses")
    void fightLose(){
        // check same essence, same equipment, damage taken
        this.setSummary(player, fs4);
        Equipment oldArmor = player.getArmor();
        Equipment oldWeapon = player.getWeapon();
        int oldEssence = player.getEssence().getNum();
        fighter.takePath();
        Assertions.assertAll("Check that Player essence count and equipment does not change and takes 5 damage",
                () -> Assertions.assertEquals(oldArmor, player.getArmor()),
                () -> Assertions.assertEquals(oldWeapon, player.getWeapon()),
                () -> Assertions.assertEquals(oldEssence, player.getEssence().getNum()),
                () -> Assertions.assertEquals(15, player.getCurrHitPoint()));
    }

    @Test
    @DisplayName("Test fight when Player loses and dies")
    void fightGameOver(){
        // check game over state
        this.setSummary(player, fs5);
        fighter.takePath();
        Assertions.assertTrue(player.getGameOver());
    }

    @Test
    @DisplayName("Test fight when fight is a tie")
    void fightTie(){
        // everything is same
        this.setSummary(player, fs6);
        Equipment oldArmor = player.getArmor();
        Equipment oldWeapon = player.getWeapon();
        int oldEssence = player.getEssence().getNum();
        int oldHP = player.getCurrHitPoint();
        fighter.takePath();
        Assertions.assertAll("Check that Player essence count and equipment does not change and takes 5 damage",
                () -> Assertions.assertEquals(oldArmor, player.getArmor()),
                () -> Assertions.assertEquals(oldWeapon, player.getWeapon()),
                () -> Assertions.assertEquals(oldEssence, player.getEssence().getNum()),
                () -> Assertions.assertEquals(oldHP, player.getCurrHitPoint()));
    }
}

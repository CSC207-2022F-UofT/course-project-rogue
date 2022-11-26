package file_reader_tests;

import entity.monster.Monster;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameFileReaderTest {
    GameFileReaderInterface playerFileReader =
            new GameFileReader("src/test/java/file_reader_tests/playerFileTest.json");

    GameFileReaderInterface monsterFileReader =
            new GameFileReader("src/test/java/file_reader_tests/monsterFileTest.json");

    //Player 1 to 4 are in top to bottom order in playerFileTest.json
    //PLEASE READ ME:
    // For all verify helper methods below, it asserts whether the player read in is the correct one.
    void verifyPlayer1(Player player){
        Assertions.assertEquals(100, player.getMaxHitPoint());
        Assertions.assertEquals(1, player.getAttackPoint());
        Assertions.assertEquals(12323, player.getEssence().getNum());
        Assertions.assertEquals(0, player.getArtifact().getNum());
        Assertions.assertEquals(1223, player.getEquipment("Weapon").getStatValue());
        Assertions.assertEquals(122, player.getEquipment("Armor").getStatValue());
    }

    void verifyPlayer4(Player player){
        Assertions.assertEquals(0, player.getMaxHitPoint());
        Assertions.assertEquals(0, player.getAttackPoint());
        Assertions.assertEquals(0, player.getEssence().getNum());
        Assertions.assertEquals(0, player.getArtifact().getNum());
        Assertions.assertEquals(1, player.getEquipment("Weapon").getStatValue());
        Assertions.assertEquals(0, player.getEquipment("Armor").getStatValue());
    }

    void verifyPlayer3(Player player){
        Assertions.assertEquals(41, player.getMaxHitPoint());
        Assertions.assertEquals(2, player.getAttackPoint());
        Assertions.assertEquals(-23, player.getEssence().getNum());
        Assertions.assertEquals(0, player.getArtifact().getNum());
        Assertions.assertEquals(4, player.getEquipment("Weapon").getStatValue());
        Assertions.assertEquals(5, player.getEquipment("Armor").getStatValue());
    }

    void verifyPlayer2(Player player){
        Assertions.assertEquals(1, player.getMaxHitPoint());
        Assertions.assertEquals(512, player.getAttackPoint());
        Assertions.assertEquals(234, player.getEssence().getNum());
        Assertions.assertEquals(0, player.getArtifact().getNum());
        Assertions.assertEquals(2, player.getEquipment("Weapon").getStatValue());
        Assertions.assertEquals(122, player.getEquipment("Armor").getStatValue());
    }
    @Test
    void testBasicPlayerCreation(){
        try {
            //1st JSONObject in list
            Player player = new ObjectMapper().
                    readValue(playerFileReader.findString("class", "Basic Player"), Player.class);
            verifyPlayer1(player);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindString(){
        try {
            //4th JSONObject in list
            Player player = new ObjectMapper().
                    readValue(playerFileReader.findString("test", "Test"), Player.class);
            verifyPlayer4(player);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindStringEmptyString(){
        try {
            //3rd JSONObject in list
            Player player = new ObjectMapper().
                    readValue(playerFileReader.findString("class", ""), Player.class);
            verifyPlayer3(player);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindInt(){
        try {
            //2nd JSONObject in list
            Player player = new ObjectMapper().
                    readValue(playerFileReader.findInt("maxHitPoint", 1), Player.class);
            verifyPlayer2(player);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindBoolean(){
        try {
            //3rd JSONObject in list
            Player player = new ObjectMapper().
                    readValue(playerFileReader.findBoolean("StraitCurve", true), Player.class);
            verifyPlayer3(player);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFindStringValueDoesNotExist(){
        Assertions.assertNull(playerFileReader.findString("class", "Difficult"));
    }


    void verifyMonster1(Monster monster){
        Assertions.assertEquals(monster.getName(), "Clown");
        Assertions.assertEquals(monster.getType(), "type");
        Assertions.assertTrue(1 <= monster.getAttack() && monster.getAttack() <= 3);
        Assertions.assertTrue(2 <= monster.getHealth() && monster.getHealth() <= 100);
        Assertions.assertFalse(monster.isHasPower());
    }
    @Test
    void testMakeClownMonster(){
        try {
            Monster monster = new ObjectMapper().
                    readValue(monsterFileReader.findString("n","Clown"), Monster.class);
            verifyMonster1(monster);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}

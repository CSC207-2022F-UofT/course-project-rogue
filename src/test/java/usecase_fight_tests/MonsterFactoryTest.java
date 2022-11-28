package usecase_fight_tests;

import entity.Monster.Monster;
import entity.Monster.Steal;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import org.junit.jupiter.api.*;
import usecase_gamedata.MonsterFactory;

// Test Notes: MonsterFactory does not pass any tests. FileNotFoundException
public class MonsterFactoryTest {

    GameFileReaderInterface fr = new GameFileReader("data_base");
    MonsterFactory mf = new MonsterFactory(fr);


    @Test
    @DisplayName("Test Monster Creation")
    void testCreate(){
        Monster result = mf.create(0);
        Assertions.assertAll("Should return the attributes of the Monster with index = 0 in the database.",
                () -> Assertions.assertFalse(result.isHasPower()),
                () -> Assertions.assertEquals("Slime", result.getName()),
                () -> Assertions.assertEquals("Normal", result.getType()),
                () -> Assertions.assertTrue(25 <= result.getHealth() && result.getHealth() <= 75),
                () -> Assertions.assertTrue(25 <= result.getAttack() && result.getAttack() <= 75));
    }

    @Test
    @DisplayName("Test Monster Creation of Monster with Power")
    void testCreateWithPower(){
        Monster result = mf.create(3);

        Assertions.assertAll("Should return the attributes of the Monster with index = 3 in the database.",
                () -> Assertions.assertTrue(result.isHasPower()),
                () -> Assertions.assertEquals("Snatcher", result.getName()),
                () -> Assertions.assertEquals("Normal", result.getType()),
                () -> Assertions.assertTrue(75 <= result.getHealth() && result.getHealth() <= 125),
                () -> Assertions.assertTrue(75 <= result.getAttack() && result.getAttack() <= 125),
                () -> Assertions.assertTrue(result.getPower() instanceof Steal));

        // for now this test will not work because of inconsistencies with MonsterFactory and confusion with how to make
        // a MonsterPower.
    }

}
package usecase_factories_tests;

import entity.monster.Monster;
import entity.monster.Steal;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import org.junit.jupiter.api.*;
import usecase_factories.MonsterFactory;

public class MonsterFactoryTest {

    final GameFileReaderInterface readerInterface = new GameFileReader("data_base/Monster.json");
    final MonsterFactory mf = new MonsterFactory(readerInterface);


    @Test
    @DisplayName("Test Monster Creation")
    void testCreate(){
        Monster result = mf.create(0);
        Assertions.assertAll("Should return the attributes of the Monster with index = 0 in the database.",
                () -> Assertions.assertFalse(result.isHasPower()),
                () -> Assertions.assertEquals("Slime", result.getName()),
                () -> Assertions.assertEquals("Normal", result.getType()),
                () -> Assertions.assertTrue(100 <= result.getHealth() && result.getHealth() <= 150),
                () -> Assertions.assertTrue(75 <= result.getAttack() && result.getAttack() <= 125));
    }

    @Test
    @DisplayName("Test Monster Creation of Monster with Power")
    void testCreateWithPower(){
        Monster result = mf.create(3);

        Assertions.assertAll("Should return the attributes of the Monster with index = 3 in the database.",
                () -> Assertions.assertTrue(result.isHasPower()),
                () -> Assertions.assertEquals("Snatcher", result.getName()),
                () -> Assertions.assertEquals("Normal", result.getType()),
                () -> Assertions.assertTrue(100 <= result.getHealth() && result.getHealth() <= 250),
                () -> Assertions.assertTrue(75 <= result.getAttack() && result.getAttack() <= 225),
                () -> Assertions.assertTrue(result.getPower() instanceof Steal));
    }

}

package usecase_fight_tests;

import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.DropRetriever;
import usecase_factories.EquipmentFactory;

public class DropRetrieverTest {

    GameFileReaderInterface fr = new GameFileReader("data_base");
    EquipmentFactory ef = new EquipmentFactory(fr);
    DropRetriever dr;

    @BeforeEach
    @DisplayName("Set up before test.")
    void setUp(){
        dr = new DropRetriever(ef);
    }

    @Test
    @DisplayName("Test that getEssenceNum() returns a value within 1 to 10.")
    void testGetEssenceNum(){
        int result = dr.getEssenceNum();
        Assertions.assertTrue((1 <= result  && result <= 10));
    }

    // make a test for getEquipment? Maybe? it essentially just needs to test that equipment is being made
}

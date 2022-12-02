package usecase_factories_tests;

import entity.item.Equipment;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_factories.EquipmentFactory;

public class EquipmentFactoryTest {

    GameFileReaderInterface fr = new GameFileReader("data_base/Equipment.json");
    EquipmentFactory ef = new EquipmentFactory(fr);

    @Test
    @DisplayName("Test Weapon Creation")
    void testCreateWeapon(){
        Equipment result = ef.create(0);
        Assertions.assertAll("Should return the attributes of the Equipment with index = 0 in the database.",
                () -> Assertions.assertEquals("Iron Sword", result.getName()),
                () -> Assertions.assertEquals(100, result.getStatValue()));
    }

    @Test
    @DisplayName("Test Armor Creation")
    void testCreateArmor(){
        Equipment result = ef.create(5);
        Assertions.assertAll("Should return the attributes of the Equipment with index = 5 in the database.",
                () -> Assertions.assertEquals("Bronze Armor", result.getName()),
                () -> Assertions.assertEquals(100, result.getStatValue()));
    }
}

package usecase_factories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.equipment_slots.item.Equipment;
import file_reader.GameFileReaderInterface;

public class EquipmentFactory {

    private static GameFileReaderInterface ef; // not sure if its problematic to have this as static

    public EquipmentFactory(GameFileReaderInterface ef){
        EquipmentFactory.ef = ef;
    }

    /**
     * @param index The index of the Equipment in the database.
     * @return A random Monster.
     */

    public static Equipment create(int index){
        try {
            return new ObjectMapper().readValue(ef.findInt("index", index), Equipment.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

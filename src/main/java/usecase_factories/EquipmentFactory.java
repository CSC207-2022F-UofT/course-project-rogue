package usecase_factories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.item.Equipment;
import file_reader.GameFileReaderInterface;

public class EquipmentFactory {

    private static GameFileReaderInterface readerInterface;

    public EquipmentFactory(){}

    /** Constructor for testing purposes */
    public EquipmentFactory(GameFileReaderInterface readerInterface){
        EquipmentFactory.readerInterface = readerInterface;
    }

    public static void setFileReader(GameFileReaderInterface fileReader){
        EquipmentFactory.readerInterface = fileReader;
    }

    /**
     * @param index The index of the Equipment in the database.
     * @return A random Monster.
     */

    public Equipment create(int index){
        try {
            return new ObjectMapper().readValue(readerInterface.findInt("index", index), Equipment.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

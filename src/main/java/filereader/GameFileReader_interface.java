package filereader;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public interface GameFileReader_interface {
    public HashMap<String, Object>[] getEntityData(String dir) throws IOException, ParseException;
    public HashMap<String, Object>[] getPlayerData() throws IOException, ParseException;
    public HashMap<String, Object>[] getMonsterData() throws IOException, ParseException;
    public HashMap<String, Object>[] getCollectibleData() throws IOException, ParseException;
    public HashMap<String, Object>[] getEquipmentData() throws IOException, ParseException;
    public Object[][] getMapData() throws IOException, ParseException;
}

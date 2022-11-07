package FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 * This class contain methods that read from JSON file and return them in java objects.
 * @author John Chen
 */
public class GameFileReader implements GameFileReader_interface{

    /**
     * @param dir : the directory of the data we are accessing
     * @return  an array of HashMap each HashMap representing an entity of the same types.
     * @throws IOException
     * @throws ParseException
     */
    @Override
    public HashMap<String, Object>[] getEntityData(String dir) throws IOException, ParseException {
        return Objects.requireNonNull(readJsonFile(dir));
    }

    /**
     * Returns the data needed to create all types of Player in an array
     *@throws IOException
     *@throws ParseException
     *
     * @return an array of HashMap each containing the data for a particular type of Player.
     */
    public HashMap<String, Object>[] getPlayerData() throws IOException, ParseException {
        return Objects.requireNonNull(readJsonFile("data_base/Player.json"));
    }

    /**
     * Returns the data needed to create all types of Monster in an array
     *@throws IOException
     *@throws ParseException
     *
     * @return an array of HashMap each containing the data for a particular type of Monster.
     */
    @Override
    public HashMap<String, Object>[] getMonsterData() throws IOException, ParseException {
        return Objects.requireNonNull(readJsonFile("data_base/Monster.json"));
    }

    /**
     * Returns the data needed to create all types of Collectible in an array
     *@throws IOException
     *@throws ParseException
     *
     * @return an array of HashMap each containing the data for a particular type of Collectible.
     */
    @Override
    public HashMap<String, Object>[] getCollectibleData() throws IOException, ParseException {
        return Objects.requireNonNull(readJsonFile("data_base/Collectible.json"));
    }

    /**
     * Returns the data needed to create all types of Equipment in an array
     *@throws IOException
     *@throws ParseException
     *
     * @return an array of HashMap each containing the data for a particular type of Equipment.
     */
    @Override
    public HashMap<String, Object>[] getEquipmentData() throws IOException, ParseException {
        return Objects.requireNonNull(readJsonFile("data_base/Equipment.json"));
    }

    /**
     * Pre-condition : The JSONArray read must only contain other JSONArray of java objects. JSONArray read must
     * have consistent length for all its inner JSONArray.
     * @return a 2 dimensional array
     * @throws IOException
     * @throws ParseException
     */
    @Override
    public Object[][] getMapData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("data_base/Map.json");
        JSONArray jarr = (JSONArray) jsonParser.parse(reader);
        int n = jarr.size();
        int m = ((JSONArray)jarr.get(0)).size();
        Object[][] arr = new Object[n][m];
        for(int i = 0; i < n; i++){
            for(int o = 0; o < m; o++){
                arr[i][o] = ((JSONArray)jarr.get(i)).get(o);
            }
        }
        return arr;
    }


    /**
     * Pre-condition : The file starts with a JSONArray
     * Reads JSON file and turn read data into java objects.
     *@throws IOException
     *@throws ParseException
     *
     * @param dir : the directory of the Json file that this method is reading from.
     * @return JSONArray in the form of an array of HashMaps or an array of java objects
     */
    private HashMap<String, Object>[] readJsonFile(String dir) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(dir);
        Object obj = jsonParser.parse(reader);
        if(obj instanceof JSONArray) {
            return toHashMap((JSONArray) obj);
        }
        return null;
    }

    /**
     * Turn JSONObject into HashMap
     *
     * @param obj : JSONObject representing an entity
     * @return a JSONObject in the form of a HashMap
     */
    private HashMap<String, Object> toHashMap(JSONObject obj){
        HashMap<String, Object> hm = new HashMap<>();
        for (String key : (Iterable<String>) obj.keySet()) {
            Object value = obj.get(key);
            if (value instanceof JSONObject) {
                value = toHashMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                if(!((JSONArray) value).isEmpty() && ((JSONArray) value).get(0) instanceof JSONObject){
                    value = toHashMap((JSONArray) value);
                }
            }
            hm.put(key, value);
        }
        return hm;
    }

    /**
     * Turn JSONArray into an array
     *
     * @param arr : JSONArray representing an array of Object.
     * @return an array of HashMap
     */
    private HashMap<String, Object>[] toHashMap(JSONArray arr){
        int n = arr.size();
        HashMap<String, Object>[] ha = new HashMap[n];
        for(int i = 0; i < n; i++){
            ha[i] = toHashMap((JSONObject) arr.get(i));
        }
        return ha;
    }
}

package file_reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public interface GameFileReaderInterface {
    static JSONArray find_helper(String dir) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(dir);
        return (JSONArray) jsonParser.parse(reader);
    }
    String findInt(String key, int value);
    default String findInt_helper(String key, int value, String dir){
        JSONArray jarr;
        try {
            jarr = GameFileReaderInterface.find_helper(dir);
            for (Object o : jarr) {
                JSONObject jsonObject = (JSONObject) o;
                if (jsonObject.get(key) instanceof Number && (Long) jsonObject.get(key) == value) {
                    return jsonObject.toJSONString();
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Did not find a player with the key to value combination.");
        return null;
    }
    String findString(String key, String value);
    default String findString_helper(String key, String value, String dir){
        JSONArray jarr;
        try {
            jarr = GameFileReaderInterface.find_helper(dir);
            for (Object o : jarr) {
                JSONObject jsonObject = (JSONObject) o;
                if (jsonObject.get(key) instanceof String && jsonObject.get(key).equals(value)) {
                    return jsonObject.toJSONString();
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Did not find a player with the key to value combination.");
        return null;
    }
    String findBoolean(String key, Boolean value);
    default String findBoolean_helper(String key, Boolean value, String dir){
        JSONArray jarr;
        try {
            jarr = GameFileReaderInterface.find_helper(dir);
            for (Object o : jarr) {
                JSONObject jsonObject = (JSONObject) o;
                if (jsonObject.get(key) instanceof Boolean && jsonObject.get(key) == value) {
                    return jsonObject.toJSONString();
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Did not find a player with the key to value combination.");
        return null;
    }
    void update(String dir);
    void update();
}

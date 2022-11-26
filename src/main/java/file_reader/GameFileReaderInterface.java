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
    public String findInt(String key, int value);
    default String findInt_helper(String key, int value, String dir){
        JSONArray jarr;
        try {
            jarr = GameFileReaderInterface.find_helper(dir);
            for(int i = 0; i < jarr.size(); i++){
                JSONObject jsonObject = (JSONObject) jarr.get(i);
                if(jsonObject.get(key) instanceof Number && (Long)jsonObject.get(key) == value){
                    return jsonObject.toJSONString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Did not find a player with the key to value combination.");
        return null;
    }
    public String findString(String key, String value);
    default String findString_helper(String key, String value, String dir){
        JSONArray jarr;
        try {
            jarr = GameFileReaderInterface.find_helper(dir);
            for(int i = 0; i < jarr.size(); i++){
                JSONObject jsonObject = (JSONObject) jarr.get(i);
                if(jsonObject.get(key) instanceof String && ((String)(jsonObject.get(key))).equals(value)){
                    return jsonObject.toJSONString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Did not find a player with the key to value combination.");
        return null;
    }
    public String findBoolean(String key, Boolean value);
    default String findBoolean_helper(String key, Boolean value, String dir){
        JSONArray jarr;
        try {
            jarr = GameFileReaderInterface.find_helper(dir);
            for(int i = 0; i < jarr.size(); i++){
                JSONObject jsonObject = (JSONObject) jarr.get(i);
                if(jsonObject.get(key) instanceof Boolean && (Boolean) jsonObject.get(key) == value){
                    return jsonObject.toJSONString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Did not find a player with the key to value combination.");
        return null;
    }
//    default String getMap() throws IOException, ParseException {
//        throw new UnsupportedOperationException("getMap is not properly implemented");
//    }
    public void setDir(String dir);
    public String getDir();
}

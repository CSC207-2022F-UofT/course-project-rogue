package FileReader;

import entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.*;

import java.io.FileReader;
import java.io.IOException;

public class playerFileReader implements GameFileReader_interface{



    /**
     * @param key : a parameter of the Player constructor.
     * @param value : the value parameter "key" points to.
     * @return the first Player found by iterative order with this key to value. Return null if no such Player exist.
     */
    @Override
    public String findInt(String key, int value) {
        JSONArray jarr;
        try {
            jarr = GameFileReader_interface.find_helper("data_base/Player.json");
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

    /**
     * @param key : a parameter of the Player constructor.
     * @param value : the value parameter "key" points to.
     * @return the first Player found by iterative order with this key to value. Return null if no such Player exist.
     */
    @Override
    public String findString(String key, String value){
        JSONArray jarr;
        try {
            jarr = GameFileReader_interface.find_helper("data_base/Player.json");
            for(int i = 0; i < jarr.size(); i++){
                JSONObject jsonObject = (JSONObject) jarr.get(i);
                if(jsonObject.get(key) instanceof String && ((String)jsonObject.get(key)).equals(value)){
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
}

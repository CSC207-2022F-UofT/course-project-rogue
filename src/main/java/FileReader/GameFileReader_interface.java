package FileReader;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public interface GameFileReader_interface {
    static public JSONArray find_helper(String dir) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(dir);
        return (JSONArray) jsonParser.parse(reader);
    }
    default String findInt(String key, int value){
        throw new UnsupportedOperationException("findInt is not properly implemented");
    }
    default String findString(String key, String value){
        throw new UnsupportedOperationException("findString is not properly implemented");
    }
    default String findBoolean(String key, Boolean value){
        throw new UnsupportedOperationException("findBoolean is not properly implemented");
    }
    default String findArray(String key, int[] value){
        throw new UnsupportedOperationException("findString is not properly implemented");
    }
//    default String getMap() throws IOException, ParseException {
//        throw new UnsupportedOperationException("getMap is not properly implemented");
//    }
}

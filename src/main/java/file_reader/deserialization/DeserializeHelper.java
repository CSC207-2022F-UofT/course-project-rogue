package file_reader.deserialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

public class DeserializeHelper {
    public int readInt(JsonNode node){
        return (Integer) ((IntNode) node).numberValue();
    }
    public String readString(JsonNode node){
        return node.textValue();
    }
    public int[] readIntArr(JsonNode node){
        int[] ar = new int[node.size()];
        int i = 0;
        for(JsonNode n: node){
            ar[i++] = readInt(n);
        }
        return ar;
    }
    public String[] readStringArr(JsonNode node){
        String[] ar = new String[node.size()];
        int i = 0;
        for(JsonNode n: node){
            ar[i++] = readString(n);
        }
        return ar;
    }
}

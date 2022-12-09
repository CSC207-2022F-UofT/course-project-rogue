package file_reader.deserialization;

import com.fasterxml.jackson.databind.JsonNode;

public class DeserializeHelper {

    /**
     * @param node : the node that represent an int
     * @return an int represented by a Jackson node
     */
    public int readInt(JsonNode node){
        return (Integer) node.numberValue();
    }

    /**
     * @param node : the node that represent a String
     * @return a string represented by a Jackson node
     */
    public String readString(JsonNode node){
        return node.textValue();
    }

    /**
     * @param node : the node that represent a boolean
     * @return a boolean represented by a Jackson node
     */
    public boolean readBoolean(JsonNode node){
        return node.booleanValue();
    }

    /**
     * @param node : the node that represent an Int Array
     * @return an int array represented by a Jackson node
     */
    public int[] readIntArr(JsonNode node){
        int[] ar = new int[node.size()];
        int i = 0;
        for(JsonNode n: node){
            ar[i++] = readInt(n);
        }
        return ar;
    }

    /**
     * @param node : the node that represent a String Array
     * @return a string array represented by a Jackson node
     */
    public String[] readStringArr(JsonNode node){
        String[] ar = new String[node.size()];
        int i = 0;
        for(JsonNode n: node){
            ar[i++] = readString(n);
        }
        return ar;
    }
}

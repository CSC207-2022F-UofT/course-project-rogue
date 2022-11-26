package file_reader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class MapDeserialization extends StdDeserializer<int[][]> {

    public MapDeserialization() {
        this(null);
    }
    public MapDeserialization(Class<?> vc){
        super(vc);
    }
    /**
     * @param p    Parsed used for reading JSON content
     * @param ctxt Context that can be used to access information about
     *             this deserialization activity.
     * @return
     * @throws IOException
     * @throws JacksonException
     */
    @Override
    public int[][] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        JsonNode n = node.get("map");
        int[][] map = new int[n.size()][n.get(0).size()];
        for(int i = 0; i < n.size(); i++){
            map[i] = h.readIntArr(n.get(i));
        }
        return map;
    }
}

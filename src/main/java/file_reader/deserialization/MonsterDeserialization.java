package file_reader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.monster.Monster;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class MonsterDeserialization  extends StdDeserializer<Monster> {
    public MonsterDeserialization() {
        this(null);
    }

    /**
     * @param p    Parsed used for reading JSON content
     * @param ctxt Context that can be used to access information about
     *             this deserialization activity.
     * @return Monster
     * @throws IOException
     * @throws JacksonException
     */
    @Override
    public Monster deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        String name = h.readString(node.get("n"));
        String type = h.readString(node.get("t"));
        HashMap<String, int[]> stats = new HashMap<>();
        Iterator<String> keys = node.get("stats").fieldNames();
        while(keys.hasNext()){
            String key = keys.next();
            stats.put(key, h.readIntArr(node.get("stats").get(key)));
        }
        boolean b = h.readBoolean(node.get("state"));
        return new Monster(name, type, stats, b);
    }

    public MonsterDeserialization(Class<?> vc){
        super(vc);
    }

}

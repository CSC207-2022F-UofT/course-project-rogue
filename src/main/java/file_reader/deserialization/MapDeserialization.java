package file_reader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import usecase_event.*;
import usecase_playeractions.Map;

import java.io.IOException;

public class MapDeserialization extends StdDeserializer<Map> {

    public MapDeserialization() {
        this(null);
    }
    public MapDeserialization(Class<?> vc){
        super(vc);
    }

    /**
     * @param p    Parsed used for reading JSON content(in the Jackson package)
     * @param ctxt Context that can be used to access information about
     *             this deserialization activity.(in the Jackson package)
     * @return A map read from file reader.
     * @throws IOException exception
     */
    @Override
    public Map deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        JsonNode n = node.get("map");
        Map map = new Map();
        for(int i = 0; i < n.size(); i++){
            String[] a = h.readStringArr(n.get(i));
            Event e;
            for(int o = 0; o < a.length; o++){
                String event = a[o];
                switch (event){
                    case "A":
                        e = new ArtifactEvent();
                    case "Es": // can be deleted
                        e = new EssenceEvent();
                    case "F": // this case can be deleted
                        // e = new FightEvent();
                    case "N":
                        e = new NoEvent();
                    case "R":
                        // e = new RandomEvent(); needs MonsterFactory and EquipmentFactory args
                    case "WL":
                        e = new WallEvent();
                    case "W":
                        //TODO: Find a way to add GameFileReader inside Win Event
//                        e = new WinEvent();
                    default:
                        e = new WallEvent();
                }
                map.setBoard(e, i, o);
            }
        }
        return map;
    }
}

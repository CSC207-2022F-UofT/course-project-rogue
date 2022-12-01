package file_reader.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import file_writer.GameFileWriter;
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
     * @throws IOException
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
                        e = (ArtifactEvent) e;
                    case "Es":
                        e = new EssenceEvent();
                        e = (EssenceEvent) e;
                    case "F":
                        e = new FightEvent();
                        e = (FightEvent) e;
                    case "N":
                        e = new NoEvent();
                        e = (NoEvent) e;
                    case "R":
                        e = new RandomEvent();
                        e = (RandomEvent) e;
                    case "WL":
                        e = new WallEvent();
                        e = (WallEvent) e;
                    case "W":
                        e = new WinEvent(new GameFileWriter("database/Player_save.json"));
                        e = (WinEvent) e;
                    default:
                        e = new WallEvent();
                        e = (WallEvent) e;
                }
                map.setBoard(e, i, o);
            }
        }
        return map;
    }
}

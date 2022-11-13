package FileReader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.Collectible;
import entity.CollectibleInventory;
import org.w3c.dom.html.HTMLTableColElement;

import java.io.IOException;

public class collectibleInventoryDeserialization extends StdDeserializer<CollectibleInventory> {
    public collectibleInventoryDeserialization() {
        this(null);
    }

    public collectibleInventoryDeserialization(Class<?> vc){
        super(vc);
    }

    @Override
    public CollectibleInventory deserialize(JsonParser p, DeserializationContext ctxt) throws IOException,
            JacksonException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        deserializeHelper h = new deserializeHelper();
        String invN = h.readString(node.get("inventoryName"));
        Collectible e = new Collectible(h.readString(node.get("essence").get("collectibleType")),
                h.readInt(node.get("essence").get("num")));
        Collectible a = new Collectible(h.readString(node.get("artifact").get("collectibleType")));
        return new CollectibleInventory(invN, e, a);
    }

}
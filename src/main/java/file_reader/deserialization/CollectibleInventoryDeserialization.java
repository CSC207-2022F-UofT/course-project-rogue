package file_reader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Collectible;

import java.io.IOException;

public class CollectibleInventoryDeserialization extends StdDeserializer<CollectibleInventory> {
    public CollectibleInventoryDeserialization() {
        this(null);
    }

    public CollectibleInventoryDeserialization(Class<?> vc){
        super(vc);
    }

    /**
     *
     * @param p Parsed used for reading JSON content(apart of Jackson, not our design)
     * @param ctxt Context that can be used to access information about
     *   this deserialization activity.(apart of Jackson, not our design)
     * @return CollectibleInventory read in together with Player(Player stores CollectibleInventory)
     * @throws IOException
     */
    @Override
    public CollectibleInventory deserialize(JsonParser p, DeserializationContext ctxt) throws IOException{
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        String invN = h.readString(node.get("inventoryName"));
        Collectible e = new Collectible(h.readString(node.get("essence").get("collectibleType")),
                h.readInt(node.get("essence").get("num")));
        Collectible a = new Collectible("Artifact");
        return new CollectibleInventory(invN, e, a);
    }

}

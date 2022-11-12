package FileReader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import entity.BasicEquipmentSlots;
import entity.Collectible;
import entity.CollectibleInventory;
import entity.Player;
import org.json.simple.JSONArray;

import java.io.IOException;

public class playerDeserialization extends StdDeserializer<Player> {
    public playerDeserialization() {
        this(null);
    }
    public playerDeserialization(Class<?> vc){
        super(vc);
    }
    @Override
    public Player deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        deserializeHelper h = new deserializeHelper();
        int mHP = h.readInt(node.get("maxHitPoint"));
        int aTP = h.readInt(node.get("attackPoint"));
        CollectibleInventory inventory = om.treeToValue(node.get("inventory"), CollectibleInventory.class);
        BasicEquipmentSlots ep = om.treeToValue(node.get("equipments"), BasicEquipmentSlots.class);
        int[] location = h.readIntArr(node.get("location"));
        return new Player(mHP, aTP, inventory, ep, location);
    }
}

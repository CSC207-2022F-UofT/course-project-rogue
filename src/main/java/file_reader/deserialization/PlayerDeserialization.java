package file_reader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.BasicEquipmentSlots;
import entity.CollectibleInventory;
import entity.Player;

import java.io.IOException;

public class PlayerDeserialization extends StdDeserializer<Player> {
    public PlayerDeserialization() {
        this(null);
    }
    public PlayerDeserialization(Class<?> vc){
        super(vc);
    }
    @Override
    public Player deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        int mHP = h.readInt(node.get("maxHitPoint"));
        int aTP = h.readInt(node.get("attackPoint"));
        CollectibleInventory inventory = om.treeToValue(node.get("inventory"), CollectibleInventory.class);
        BasicEquipmentSlots ep = om.treeToValue(node.get("equipments"), BasicEquipmentSlots.class);
        int[] location = h.readIntArr(node.get("location"));
        return new Player(mHP, aTP, inventory, ep, location);
    }
}

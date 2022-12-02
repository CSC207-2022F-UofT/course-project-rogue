package file_reader.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.item.Armor;
import entity.item.Equipment;
import entity.item.Weapon;

import java.io.IOException;

@SuppressWarnings("unused")
public class EquipmentDeserialization extends StdDeserializer<Equipment> {

    public EquipmentDeserialization(){this(null);}
    public EquipmentDeserialization(Class<?> vc){
        super(vc);
    }


    /**
     *
     * @param p Parsed used for reading JSON content
     * @param text Context that can be used to access information about
     *   this deserialization activity.
     *
     * @return Armor iff the stat value field is named "dmgReduced" and Weapon iff the field is named
     * "weaponAttackPoint"
     * @throws IOException Exception
     */
    @Override
    public Equipment deserialize(JsonParser p, DeserializationContext text) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        String name = h.readString(node.get("name"));
        int stat;
        if (node.get("weaponAttackPoint") == null){
            stat = h.readInt(node.get("dmgReduced"));
            return new Armor(name, stat);
        } else {
            stat = h.readInt(node.get("weaponAttackPoint"));
            return new Weapon(name, stat);
        }
    }
}

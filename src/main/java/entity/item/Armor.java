package entity.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Armor extends Equipment {

    /**
     * Creates a new Armor object.
     * @param name the name of the Armor.
     * @param dmgReduced the damage reduced value.
     */
    public Armor(@JsonProperty("name")String name, @JsonProperty("dmgReduced")int dmgReduced){
        super(name,1, "DamageReduction", dmgReduced);
    }
}

package entity.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weapon extends Equipment {

    /**
     * Creates a new Weapon object.
     * @param name the name of the Weapon.
     * @param weaponAttackPoint the attack power value.
     */
    public Weapon(@JsonProperty("name")String name, @JsonProperty("weaponAttackPoint")int weaponAttackPoint){
        super(name, 1, "Attack", weaponAttackPoint);
    }
}

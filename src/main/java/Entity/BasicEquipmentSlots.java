package Entity;

import java.util.HashMap;

public class BasicEquipmentSlots {
    private Armor armor;
    private Weapon weapon;

    public BasicEquipmentSlots(Weapon weapon, Armor armor) {
        this.armor = armor;
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setArmor(Armor newArmor){
        this.armor = newArmor;
    }
    public void setWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }

}

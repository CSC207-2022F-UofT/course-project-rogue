package entity;

import entity.Equipment;

public class Weapon extends Equipment {

    /**
     * Creates a new entity.Weapon object.
     * @param name the name of the entity.Weapon.
     * @param num the number of weapons.
     * @param weaponAttackPoint the attack power value.
     */
    public Weapon(String name, int num, int weaponAttackPoint){
        super(name, num, "Attack", weaponAttackPoint);
    }

    /**
     * Returns the attack point value.
     * @return the attack point value.
     */
    public int getWeaponAttackPoint() {
        return this.getStats();
    }
}

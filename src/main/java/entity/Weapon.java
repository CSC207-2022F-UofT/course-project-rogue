package entity;

public class Weapon extends Equipment {

    /**
     * Creates a new Weapon object.
     * @param name the name of the Weapon.
     * @param weaponAttackPoint the attack power value.
     */
    public Weapon(String name, int weaponAttackPoint){
        super(name, 1, "Attack", weaponAttackPoint);
    }

    /**
     * Returns the attack point value.
     * @return the attack point value.
     */
    public int getWeaponAttackPoint() {
        return this.getStats();
    }
}

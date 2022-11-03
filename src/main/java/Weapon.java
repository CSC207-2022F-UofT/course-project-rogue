public class Weapon extends Equipment{
    private int weaponAttackPoint; // attack power

    /**
     * Creates a new Weapon object.
     * @param name the name of the Weapon.
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
        return this.weaponAttackPoint;
    }
}

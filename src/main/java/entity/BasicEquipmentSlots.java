package entity;

public class BasicEquipmentSlots {
    private Armor armor;
    private Weapon weapon;

    /**
     * Construct the BasicEquipmentSlot
     *
     * @param weapon: Weapon class
     * @param armor: Armor class
     */
    public BasicEquipmentSlots(Weapon weapon, Armor armor) {

        this.armor = armor;
        this.weapon = weapon;
    }

    /** Returns the Armor
     *
     * @return Armor instance attribute
     */
    public Armor getArmor() {
        return armor;
    }

    /** Returns the Weapon
     * @return Weapon instance attribute
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /** Change the Armor in the equipment slots
     *
     * @param newArmor: Armor class
     */
    public void setArmor(Armor newArmor){

        this.armor = newArmor;
    }

    /** Change the Weapon in the equipment slots
     *
     * @param newWeapon: Weapon class
     */
    public void setWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }

}

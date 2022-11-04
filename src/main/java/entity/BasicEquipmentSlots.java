package entity;

public class BasicEquipmentSlots {
    private Armor armor;
    private Weapon weapon;

    /**
     * Construct the BasicEquipmentSlot
     *
     * @param weapon: entity.Weapon class
     * @param armor: entity.Armor class
     */
    public BasicEquipmentSlots(Weapon weapon, Armor armor) {

        this.armor = armor;
        this.weapon = weapon;
    }

    /** Returns the entity.Armor
     *
     * @return entity.Armor instance attribute
     */
    public Armor getArmor() {
        return armor;
    }

    /** Returns the entity.Weapon
     * @return entity.Weapon instance attribute
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /** Change the entity.Armor in the equipment slots
     *
     * @param newArmor: entity.Armor class
     * @return Replaces the original entity.Armor with the inputted entity.Armor
     */
    public void setArmor(Armor newArmor){

        this.armor = newArmor;
    }

    /** Change the entity.Weapon in the equipment slots
     *
     * @param newWeapon: entity.Weapon class
     */
    public void setWeapon(Weapon newWeapon){

        this.weapon = newWeapon;
    }

}

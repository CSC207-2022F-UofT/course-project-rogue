package entity;

public class BasicEquipmentSlots {
    private Armor armor;
    private Weapon weapon;

    public BasicEquipmentSlots(Weapon weapon, Armor armor) {
        /**
         * Construct the class
         *
         * @param weapon: Weapon class
         * @param armor: Armor class
         * @return Setting up the class
         */
        this.armor = armor;
        this.weapon = weapon;
    }

    public Armor getArmor() {
        /** Returns the Armor
         *
         *
         * @return Armor
         */
        return armor;
    }

    public Weapon getWeapon() {
        /** Returns the Weapon
         *
         *
         * @return Weapon
         */
        return weapon;
    }

    public void setArmor(Armor newArmor){
        /** Change the Armor in the equipment slots
         *
         * @param newArmor: Armor class
         * @return Replaces the original Armor with the inputted Armor
         */
        this.armor = newArmor;
    }
    public void setWeapon(Weapon newWeapon){
        /** Change the Weapon in the equipment slots
         *
         * @param newWeapon: Weapon class
         * @return Replaces the original Weapon with the inputted Weapon
         */
        this.weapon = newWeapon;
    }

}

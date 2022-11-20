package entity;

public abstract class Equipment extends Item implements Comparable<Equipment> {
    private final String statType; // the type of stat
    private int statValue; // the value of the stat

    private int timesUpgraded; // how many times the equipment has been upgraded

    /**
     * Creates a new Equipment object.
     * @param name the name of the Equipment.
     * @param num the number of equipments.
     * @param statType the type of stat associated with the Equipment.
     * @param statValue the value of the stat associated with the Equipment.
     */
    public Equipment(String name, int num, String statType, int statValue){
        super(name, num);
        this.statType = statType;
        this.statValue = statValue;
    }

    /**
     * Creates a new Equipment object.
     * @param name the name of the Equipment.
     * @param num the number of equipments.
     * @param statType the type of stat associated with the Equipment.
     * @param statValue the value of the stat associated with the Equipment.
     * @param upgrades the number of times the Equipment has been upgraded.
     */
    public Equipment(String name, int num, String statType, int statValue, int upgrades){
        super(name, num);
        this.statType = statType;
        this.statValue = statValue;
        this.timesUpgraded = upgrades;
    }

    /**
     * Returns the stat's value.
     * @return the stat's value.
     */
    public int getStatValue(){return this.statValue;}

    /**
     * Returns the type of stat.
     * @return the type of stat.
     */
    public String getStatType(){
        return this.statType;
    }

    /**
     * Returns the number of times this equipment has been upgraded.
     * @return the number of times this equipment has been upgraded.
     */
    public int getTimesUpgraded(){return this.timesUpgraded;}

    /**
     * Sets timesUpgraded to the number given.
     * @param numUpgrades the new number of timesUpgraded.
     */
    public void setTimesUpgraded(int numUpgrades){
        this.timesUpgraded = numUpgrades;
    }

    /**
     * Changes statValue to newStatValue.
     * @param newStatValue the new value of statValue.
     */
    public void setStatValue(int newStatValue){
        this.statValue = newStatValue;
    }

    /**
     * Adds a number to statValue. Can add any integer.
     * @param be_added the number added to statValue.
     */
    public void addStatValue(int be_added){
        this.statValue = this.statValue + be_added;
    }

    /**
     * Adds a number to timesUpgraded. Can add any integer.
     * @param upgradeNum the number added to timesUpgraded.
     */
    public void addTimesUpgraded(int upgradeNum){
        this.timesUpgraded = this.timesUpgraded + upgradeNum;
    }

    /**
     * Compares the statValue of this Equipment to another Equipment.
     * @param newEquip the other Equipment to compare to.
     * @return a positive integer, negative integer, or zero depending on if
     * this object's statValue is greater than, less than, or equal to the newEquip's statValue.
     */
    @Override
    public int compareTo(Equipment newEquip){
        if (this.statValue > newEquip.statValue){
            return 1;
        } else if (this.statValue < newEquip.statValue){
            return -1;
        } else {
            return 0;
        }
    }
}

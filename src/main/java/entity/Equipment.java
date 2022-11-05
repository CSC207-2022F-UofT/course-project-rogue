package entity;

public class Equipment extends Item implements Stats {
    private final String statType; // the type of stat
    private int statValue; // the value of the stat

    /**
     * Creates a new entity.Equipment object.
     * @param name the name of the entity.Equipment.
     * @param num the number of equipments.
     * @param statType the type of stat associated with the entity.Equipment.
     * @param statValue the value of the stat associated with the entity.Equipment.
     */
    public Equipment(String name, int num, String statType, int statValue){
        super(name, num);
        this.statType = statType;
        this.statValue = statValue;
    }

    /**
     * Returns the stat's value.
     * @return the stat's value.
     */
    @Override
    public int getStats(){
        return this.statValue;
    }

    /**
     * Returns the type of stat.
     * @return the type of stat.
     */
    public String getStatType(){
        return this.statType;
    }

    /**
     * Changes statValue to newStatValue.
     * @param newStatValue the new value of statValue.
     */
    public void setStatValue(int newStatValue){
        this.statValue = newStatValue;
    }

    /**
     * Adds a value to statValue.
     * @param be_added the value added to statValue.
     */
    public void addStatValue(int be_added){
        this.statValue = this.statValue + be_added;
    }
}

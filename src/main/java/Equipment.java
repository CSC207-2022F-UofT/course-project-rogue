import java.util.HashMap;

public class Equipment extends Item implements Stats{
    private String statType; // the type of stat
    private int statValue; // the value of the stat

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
     * Returns a Hashmap of the stat type and its value.
     * @return the stat type and the stat's value.
     */
    public HashMap<String, Integer> getStats(){
        HashMap<String, Integer> statsMap = new HashMap<>();
        statsMap.put(this.statType, this.statValue);
        return statsMap;
    }

    /**
     * Returns the type of stat.
     * @return the type of stat.
     */
    public String getStatType(){
        return this.statType;
    }

    /**
     * Returns the stat value.
     * @return the stat value
     */
    public int getStatValue(){
        return this.statValue;
    }
}

package usecase_heal_and_upgrade;

public class CalculatorStat {
    public CalculatorStat(){}

    public final int STAT_INCREASE = 20;

    /**
     * This method will return the Stat increase in one upgrade
     * @return the stat to be added
     */
    public int determineAdd() {
        return STAT_INCREASE;
    }
}

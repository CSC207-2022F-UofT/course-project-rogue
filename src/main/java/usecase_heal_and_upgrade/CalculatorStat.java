package usecase_heal_and_upgrade;

public class CalculatorStat {
    int statIncrease;

    public CalculatorStat(){
        this.statIncrease = 20;
    }

    /**
     * This method will return the Stat increase in one upgrade
     * @return the stat to be added
     */
    public int determineAdd() {
        return this.statIncrease;
    }
}

package usecase_essence_use.data_calculator;

public class CalculatorStat {

    public final int statIncrease;

    public CalculatorStat(){
        statIncrease = 20;
    }

    /**
     * This method will return the Stat increase in one upgrade
     * @return the stat to be added
     */
    public int determineAdd() {
        return statIncrease;
    }
}

package usecase_heal_and_upgrade;

public class StatCalculator {
    int statadded;

    public StatCalculator(){
        this.statadded = 20;
    }

    /**
     * This method will return the Stat increase in one upgrade
     * @return the stat to be added
     */
    public int determine_add() {
        return this.statadded;
    }
}

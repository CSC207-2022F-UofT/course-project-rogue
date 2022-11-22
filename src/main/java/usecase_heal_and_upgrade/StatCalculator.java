package usecase_heal_and_upgrade;

public class StatCalculator {
    int statIncrese;

    public StatCalculator(){
        this.statIncrese = 20;
    }

    /**
     * This method will return the Stat increase in one upgrade
     * @return the stat to be added
     */
    public int determineAdd() {
        return this.statIncrese;
    }
}

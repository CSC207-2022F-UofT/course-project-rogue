package usecase_essence_use.data_preset_normal;

public final class statSetting {

    private final int statIncrease;
    private final int upgradeTimesMax;

    public statSetting(){
        statIncrease = 20;
        upgradeTimesMax = 3;
    }

    /**
     * This method will return the Stat increase in one upgrade
     * @return the stat to be added
     */
    public int determineAdd() {
        return statIncrease;
    }

    /**
     * This method will return the max time upgrade limit
     * @return max time upgrade limit
     */
    public int determineMaxUpgradeTimes(){return upgradeTimesMax;}
}

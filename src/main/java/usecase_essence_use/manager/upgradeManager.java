package usecase_essence_use.manager;

import entity.item.Equipment;
import entity.player.Player;
import usecase_essence_use.data_preset_normal.collectibleNeedSetting;
import usecase_essence_use.data_preset_normal.statSetting;

public class upgradeManager {

    private final CollectibleUseManager CollectHelper;
    private final Player player;
    private final collectibleNeedSetting essenceNeed;

    private final statSetting statDetermine;


    private final String EquipType;


    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player the player of the game
     */
    public upgradeManager(Player player, String equipType, collectibleNeedSetting essenceNeed,
                          statSetting statDetermine){
        this.player = player;
        this.essenceNeed = essenceNeed;
        this.CollectHelper = new CollectibleUseManager(player, this.essenceNeed.essenceForUpgrade());
        this.EquipType = equipType;
        this.statDetermine = statDetermine;
    }

    private Equipment getEquipment(Player player, String equipType){
        if (equipType.equals("Weapon") || equipType.equals("weapon")){
            return player.getWeapon();
        }
        return player.getArmor();
    }


    /**
     * Update heal infomation. The method must be called before the game print heal summary.
     */
    public void UpgradeInfoUpdate(){
        CollectHelper.essenceNeedUpdate(essenceNeed.essenceForUpgrade);
    }

    /**
     * get the equipment
     * @return the equipment
     */
    public Equipment getEquipment(){
        return  this.getEquipment(this.player, this.EquipType);
    }

    /**
     * get the essence need for upgrade
     * @return get the essence need for upgrade
     */
    public int getEssenceCost(){
        return this.CollectHelper.getEssenceNeed();
    }

    /**
     * get the stat increase from this upgrade
     * @return the stats be increased
     */
    public int getStatIncrease(){
        return this.statDetermine.determineAdd();
    }

    /**
     * get if we can upgrade
     * @return boolean if we can upgrade
     */
    public boolean getAble(){
        return this.CollectHelper.getAble();
    }

    /**
     * get the equipments upgrade times
     * @return the upgrade times
     */
    public int getTimesUpgrade(){return  this.getEquipment(this.player, this.EquipType).getTimesUpgraded();}

    /**
     * get the maxTimeUpgrade
     */
    public int getMaxTimes(){return  this.statDetermine.determineMaxUpgradeTimes();}

    public boolean getBelowLimit(){
        return statDetermine.determineMaxUpgradeTimes() > getEquipment(this.player, this.EquipType).getTimesUpgraded();}

    public void upgrade(){
        Equipment equipment = getEquipment(player, EquipType);
        if (CollectHelper.getAble()&& getTimesUpgrade()<getMaxTimes()) {
            this.CollectHelper.spendCollectible();
            equipment.addStatValue(this.statDetermine.determineAdd());
            equipment.addTimesUpgraded(1);
            player.setCanUpgrade(false);
        }
    }
}

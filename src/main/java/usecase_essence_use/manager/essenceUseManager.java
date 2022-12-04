package usecase_essence_use.manager;

import entity.player.Player;
import usecase_essence_use.data_preset_normal.collectibleNeedSetting;
import usecase_essence_use.data_preset_normal.statSetting;

public class essenceUseManager {
    private final healManager healCount;
    private final upgradeManager weaponUpgradeCount;
    private final upgradeManager armorUpgradeCount;
    private boolean newData;

    public essenceUseManager(Player player, collectibleNeedSetting essenceNeed, statSetting statAdd){
        healCount = new healManager(player, essenceNeed);
        weaponUpgradeCount = new upgradeManager(player, "Weapon", essenceNeed, statAdd);
        armorUpgradeCount = new upgradeManager(player, "Armor", essenceNeed, statAdd);
        newData = false;
    }

    public healManager getHealManage() {
        return healCount;
    }

    public upgradeManager getArmorUpgradeManage() {
        return armorUpgradeCount;
    }

    public upgradeManager getWeaponUpgradeManage() {
        return weaponUpgradeCount;
    }


    /**
     * update the infomation of the Calculator in this class, please use it everytime you triger the class.
     */
    public void updateInfo(){
        this.armorUpgradeCount.UpgradeInfoUpdate();
        this.weaponUpgradeCount.UpgradeInfoUpdate();
        this.healCount.healInfoUpdate();
        this.newData = true;
    }

    /**
     * Change the status of the manager, let the action manager know that the data is new or not.
     */
    public void setNewDataFalse(){
        this.newData = false;
    }

    public boolean isNewData() {
        return newData;
    }
}

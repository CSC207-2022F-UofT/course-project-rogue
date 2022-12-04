package usecase_essence_use.manager;

import entity.player.Player;
import usecase_essence_use.data_preset_normal.collectibleNeedSetting;
import usecase_essence_use.data_preset_normal.statSetting;

public class essenceUseManager {
    private final healManager healCount;
    private final upgradeManager weaponUpgradeCount;
    private final upgradeManager armorUpgradeCount;
    private boolean inEssenceUse;
    private boolean inPage;

    public essenceUseManager(Player player, collectibleNeedSetting essenceNeed, statSetting statAdd){
        healCount = new healManager(player, essenceNeed);
        weaponUpgradeCount = new upgradeManager(player, "Weapon", essenceNeed, statAdd);
        armorUpgradeCount = new upgradeManager(player, "Armor", essenceNeed, statAdd);
        inEssenceUse = false;
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
    public void initializeManager(){
        this.armorUpgradeCount.UpgradeInfoUpdate();
        this.weaponUpgradeCount.UpgradeInfoUpdate();
        this.healCount.healInfoUpdate();
        this.inEssenceUse = true;
        this.inPage = false;
    }

    /**
     * update the infomation of the manager, you need to use the it before show info.
     */
    public void updateInfo(){
        this.armorUpgradeCount.UpgradeInfoUpdate();
        this.weaponUpgradeCount.UpgradeInfoUpdate();
        this.healCount.healInfoUpdate();
    }

    /**
     * set the status of the essenceUse Manager
     * @param inPage if the essenceUse have open certain page.
     */
    public void setInPage(boolean inPage){this.inPage = inPage;}

    public boolean isInPage() {
        return inPage;
    }

    /**
     * Change the status of the manager, let the action manager know that the data is new or not.
     */
    public void setNewDataFalse(){
        this.inEssenceUse = false;
    }

    public boolean isInEssenceUse() {
        return inEssenceUse;
    }
}

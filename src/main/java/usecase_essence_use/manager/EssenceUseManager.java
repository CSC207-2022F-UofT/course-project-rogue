package usecase_essence_use.manager;

import entity.player.Player;
import usecase_essence_use.data_preset_normal.CollectibleNeedSetting;
import usecase_essence_use.data_preset_normal.StatSetting;

public class EssenceUseManager {
    private final HealManager healCount;
    private final UpgradeManager weaponUpgradeCount;
    private final UpgradeManager armorUpgradeCount;
    private boolean inEssenceUse;
    private boolean inPage;

    public EssenceUseManager(Player player, CollectibleNeedSetting essenceNeed, StatSetting statAdd){
        healCount = new HealManager(player, essenceNeed);
        weaponUpgradeCount = new UpgradeManager(player, "Weapon", essenceNeed, statAdd);
        armorUpgradeCount = new UpgradeManager(player, "Armor", essenceNeed, statAdd);
        inEssenceUse = false;
        inPage = false;
    }

    public HealManager getHealManage() {
        return healCount;
    }

    public UpgradeManager getArmorUpgradeManage() {
        return armorUpgradeCount;
    }

    public UpgradeManager getWeaponUpgradeManage() {
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
        this.inPage = true;
    }

    /**
     * update the infomation of the manager, you need to use it before show info.
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

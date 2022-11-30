package usecase_essence_use;

import entity.player.Player;
import usecase_essence_use.heal.HealCalculator;
import usecase_essence_use.upgrade.UpgradeCalculator;

public class EssenceUseCalculator {
    private final HealCalculator healCount;
    private final UpgradeCalculator weaponUpgradeCount;
    private final UpgradeCalculator armorUpgradeCount;

    public EssenceUseCalculator(Player player){
        healCount = new HealCalculator(player);
        weaponUpgradeCount = new UpgradeCalculator(player, "Weapon");
        armorUpgradeCount = new UpgradeCalculator(player, "Armor");
    }

    public HealCalculator getHealManage() {
        return healCount;
    }

    public UpgradeCalculator getArmorUpgradeManage() {
        return armorUpgradeCount;
    }

    public UpgradeCalculator getWeaponUpgradeManage() {
        return weaponUpgradeCount;
    }


    /**
     * update the infomation of the Calculator in this class, please use it everytime you triger the class.
     */
    public void updateInfo(){
        this.armorUpgradeCount.UpgradeInfoUpdate();
        this.weaponUpgradeCount.UpgradeInfoUpdate();
        this.healCount.healInfoUpdate();
    }
}

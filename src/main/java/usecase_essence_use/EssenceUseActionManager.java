package usecase_essence_use;

import entity.player.Player;
import usecase_essence_use.data_preset_normal.collectibleNeedSetting;
import usecase_essence_use.data_preset_normal.statSetting;
import usecase_essence_use.essenceUseKey.*;
import usecase_essence_use.manager.essenceUseManager;
import usecase_essence_use.manager.essenceUseSpeakerManager;
import usecase_playeractions.ActionManager;

public class EssenceUseActionManager extends ActionManager {
    /**
     * Initialize the basic control class with no Observer
     */
    public EssenceUseActionManager(){}

    /**
     * Initialize the actions choice of the player.
     * The basic Upgrade and Heal actions will be initialized.
     * Sets up the default  observer of Heal and Upgrade
     */
    public void setDefaultKey(Player player){
        collectibleNeedSetting collectibleNeed = new collectibleNeedSetting();
        statSetting statSetting = new statSetting();
        essenceUseManager manager = new essenceUseManager(player, collectibleNeed, statSetting);
        essenceUseSpeakerManager speaker = new essenceUseSpeakerManager(player, manager);
        this.addObserver(new Upgrader(player, manager.getWeaponUpgradeManage(), "1", speaker));
        this.addObserver(new Upgrader(player, manager.getArmorUpgradeManage(), "2", speaker));
        this.addObserver(new Healer(player, manager, "H", speaker));
        this.addObserver(new essenceUseLeaver(player, manager, "L", speaker));
        this.addObserver(new upgradeSelect(player, manager,"U", speaker));
        this.addObserver(new essenceUseStarter(player, manager, "E", speaker));
    }


}

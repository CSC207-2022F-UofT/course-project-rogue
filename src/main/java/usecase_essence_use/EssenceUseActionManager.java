package usecase_essence_use;

import entity.player.Player;
import usecase_essence_use.data_preset_normal.CollectibleNeedSetting;
import usecase_essence_use.data_preset_normal.StatSetting;
import usecase_essence_use.essenceUseKey.*;
import usecase_essence_use.manager.EssenceUseManager;
import usecase_essence_use.manager.EssenceUseSpeakerManager;
import usecase_playeractions.ActionManager;

public class EssenceUseActionManager extends ActionManager {
    /**
     * Initialize the actions choice of the player.
     * The basic Upgrade and Heal actions will be initialized.
     * Sets up the default  observer of Heal and Upgrade
     */
    public void setDefaultKey(Player player){
        CollectibleNeedSetting collectibleNeed = new CollectibleNeedSetting();
        StatSetting statSetting = new StatSetting();
        EssenceUseManager manager = new EssenceUseManager(player, collectibleNeed, statSetting);
        EssenceUseSpeakerManager speaker = new EssenceUseSpeakerManager(player, manager);
        this.addObserver(new Upgrader(player, manager.getWeaponUpgradeManage(), "1", speaker));
        this.addObserver(new Upgrader(player, manager.getArmorUpgradeManage(), "2", speaker));
        this.addObserver(new Healer(player, manager, "H", speaker));
        this.addObserver(new EssenceUseLeaver(player, manager, "L", speaker));
        this.addObserver(new UpgradeSelect(player, manager,"U", speaker));
        this.addObserver(new EssenceUseStarter(player, manager, "C", speaker));
    }


}

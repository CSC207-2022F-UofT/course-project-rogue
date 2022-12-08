package usecase_essence_use.essenceUseKey;

import entity.player.Player;
import usecase_essence_use.manager.EssenceUseSpeakerManager;
import usecase_essence_use.manager.EssenceUseManager;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class EssenceUseStarter implements Observer {
    private final Player player;
    private final EssenceUseManager manager;
    private final String trigger;
    private final EssenceUseSpeakerManager speaker;


    /**
     * The constructor of healing. This class is to be triggered by the HealingUpgradingControl. And It will recover the
     * certain amount of HP that is determined by the HealInfo
     * @param player the player
     * @param trigger the trigger word, usually a big capital letter
     */
    public EssenceUseStarter(Player player, EssenceUseManager manager, String trigger, EssenceUseSpeakerManager speaker) {
        this.player = player;
        this.manager = manager;
        this.trigger = trigger;
        this.speaker = speaker;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(this.trigger) && player.getCanUpgrade() && player.getCanHeal() && !player.getUpgrading()
                && !manager.isInEssenceUse()) {
            manager.initializeManager();
            speaker.showEssenceUseInfo();
        }
    }
}

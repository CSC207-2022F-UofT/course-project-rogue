package usecase_essence_use.essenceUseKey;

import entity.player.Player;
import usecase_essence_use.manager.essenceUseManager;
import usecase_essence_use.manager.essenceUseSpeakerManager;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class upgradeSelect implements Observer{
    private final Player player;

    private final String trigger;

    private final essenceUseManager manager;

    private final essenceUseSpeakerManager speaker;

    /**
     * The constructor of healing. This class is to be triggered by the HealingUpgradingControl. And It will recover the
     * certain amount of HP that is determined by the HealInfo
     * @param player the player
     * @param trigger the trigger word, usually a big capital letter
     */

    public upgradeSelect(Player player, essenceUseManager manager,String trigger, essenceUseSpeakerManager speaker) {
        this.player = player;
        this.manager = manager;
        this.trigger = trigger;
        this.speaker = speaker;
    }


    @SuppressWarnings("deprecation")
    @Override
    public void update(Observable o, Object arg) {
        if(player.getCanUpgrade() && manager.isNewData() && arg.equals(this.trigger)) {
            player.setUpgrading(true);
            speaker.showUpgradeSelectPage();
        }
    }
}
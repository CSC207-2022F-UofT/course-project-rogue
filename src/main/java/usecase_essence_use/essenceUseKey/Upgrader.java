package usecase_essence_use.essenceUseKey;

import entity.player.Player;
import usecase_essence_use.manager.upgradeManager;
import usecase_essence_use.manager.essenceUseSpeakerManager;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Upgrader implements Observer{
    private final Player player;
    private final upgradeManager Manager;
    private final String trigger;

    private boolean inPage;

    private final essenceUseSpeakerManager speaker;

    /**
     * The constructor of healing. This class is to be triggered by the HealingUpgradingControl. And It will recover the
     * certain amount of HP that is determined by the HealInfo
     * @param player the player
     * @param Manager the healCalculator that the trigger connect to
     * @param trigger the trigger word, usually a big capital letter
     */

    public Upgrader(Player player, upgradeManager Manager, String trigger, essenceUseSpeakerManager speaker) {
        this.player = player;
        this.Manager = Manager;
        this.trigger = trigger;
        this.inPage = false;
        this.speaker = speaker;
    }


    @SuppressWarnings("deprecation")
    @Override
    public void update(Observable o, Object arg) {
        if(player.getUpgrading() && arg.equals(this.trigger)) {
            String verb;
            verb = String.format("upgrade %s", Manager.getEquipment().getName());
            this.inPage = true;
            speaker.showVerifyPage(verb);
        }
        if (inPage && player.getCanUpgrade() && arg.equals("Y")){
            String verb;
            verb = String.format("upgrade %s", Manager.getEquipment().getName());
            this.Manager.upgrade();
            speaker.showSuccessPage(verb);
        }
        if (inPage && player.getUpgrading() && arg.equals("N")){
            this.inPage = false;
            this.player.setUpgrading(false);
            speaker.showEssenceUseInfo();
        }
        if (inPage && !player.getCanUpgrade() && arg.equals("C")){
            this.inPage = false;
            this.player.setUpgrading(false);
            speaker.showEssenceUseInfo();
        }
    }
}
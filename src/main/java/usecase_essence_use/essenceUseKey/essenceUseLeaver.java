package usecase_essence_use.essenceUseKey;

import entity.player.Player;
import usecase_essence_use.manager.essenceUseManager;
import usecase_essence_use.manager.essenceUseSpeakerManager;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class essenceUseLeaver implements Observer {
    private final Player player;
    private final String trigger;
    private final essenceUseManager manager;

    private boolean inPage;

    private final essenceUseSpeakerManager speaker;

    /**
     * The constructor of healing. This class is to be triggered by the HealingUpgradingControl. And It will recover the
     * certain amount of HP that is determined by the HealInfo
     * @param player the player
     * @param trigger the trigger word, usually a big capital letter
     * @param speaker the outputBoundary
     */
    public essenceUseLeaver(Player player, essenceUseManager manager,String trigger, essenceUseSpeakerManager speaker) {
        this.player = player;
        this.trigger = trigger;
        this.manager = manager;
        this.inPage = false;
        this.speaker = speaker;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(this.trigger) && !manager.isInPage()) {
            this.inPage = true;
            this.manager.setInPage(true);
            this.speaker.showVerifyPage("Leave");
        } else if (inPage && arg.equals("Y")){
            this.speaker.showSuccessPage("Leave");
            this.player.setCanUpgrade(false);
            this.player.setCanHeal(false);
            this.player.setCanMove(true);
            this.manager.setInPage(false);
            this.inPage = false;
            this.manager.setNewDataFalse();
            this.player.setCanMove(true);
            this.speaker.showEssenceUseEnd();
        }else if (inPage && arg.equals("N")){
            this.speaker.showEssenceUseInfo();
            this.manager.setInPage(false);
            this.inPage = false;
    }
}}

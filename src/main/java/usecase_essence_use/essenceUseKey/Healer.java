package usecase_essence_use.essenceUseKey;

import entity.player.Player;
import usecase_essence_use.manager.EssenceUseManager;
import usecase_essence_use.manager.EssenceUseSpeakerManager;

import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")
public class Healer implements Observer {

    private final Player player;
    private final EssenceUseManager Manager;
    private final String trigger;

    private boolean inPage;

    private final EssenceUseSpeakerManager speaker;

    /**
     * The constructor of healing. This class is to be triggered by the HealingUpgradingControl. And It will recover the
     * certain amount of HP that is determined by the HealInfo
     * @param player the player
     * @param Manager the healCalculator that the trigger connect to
     * @param trigger the trigger word, usually a big capital letter
     */
    public Healer(Player player, EssenceUseManager Manager, String trigger, EssenceUseSpeakerManager speaker) {
        this.player = player;
        this.Manager = Manager;
        this.trigger = trigger;
        this.inPage = false;
        this.speaker = speaker;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(this.player.getCanHeal() && arg.equals(this.trigger) && !Manager.isInPage() &&
                Manager.getHealManage().getHPToHeal() != 0 && Manager.getHealManage().getRequireHP() != 0) {
            this.inPage = true;
            Manager.setInPage(true);
            this.speaker.showVerifyPage("Heal");
        } else if (inPage && player.getCanHeal() && arg.equals("Y")){
            this.Manager.getHealManage().heal();
            this.speaker.showSuccessPage("Heal");
            this.player.setCanHeal(false);
        }else if (inPage && player.getCanHeal() && arg.equals("N")){
            this.speaker.showEssenceUseInfo();
            this.inPage = false;
        } else if (inPage && !player.getCanHeal() && arg.equals("C")) {
            this.speaker.showEssenceUseInfo();
            this.inPage = false;
        }
    }
}
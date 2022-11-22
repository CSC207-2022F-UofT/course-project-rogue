package usecase_heal_and_upgrade;

import Interface.Visual_h_u;
import entity.Equipment;
import entity.Player;
import presenter.Presenter_bottom;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;


public class upgrading implements Observer{
    private Player player;
    private final String trigger;

    private int Essence_require;

    private CollectableCalculator EssenceCalculator;
    private StatCalculator StatCount;


    /**
     * The constructor of upgrading_control.
     * @param player the player
     */
    public upgrading(Player player, String trigger) {
        this.player = player;
        this.trigger = trigger;
        this.EssenceCalculator = new CollectableCalculator();
        this.Essence_require = this.EssenceCalculator.EssenceForUpgrade();
        this.StatCount = new StatCalculator();
    }

    /**
     * The basic part of the upgrading, it will return nothing but send messages to presenter.
     */
    private void upgrade() {

        Visual_h_u speaker = new Presenter_bottom();
        CollectibleUseManage ColHelper = new CollectibleUseManage(this.player, determine_Ess(), "upgrade");
        ColHelper.ItemBroadcast();
        //check if able to upgrade
        if (ColHelper.get_able()) {
            speaker.keypress_request("A", "S");
            //check which to upgrade
            if (input.get_upgrade_decision().equals("A")) {
                //situation: upgrade armor
                upgrade_helper("Armor", ColHelper);
            } else {
                //situation: upgrade sword
                upgrade_helper("Sword", ColHelper);
            }
        }
    }

    /**
     * The helper function of upgrade.
     * @param type "Armor" or "Sword", the name of the equipment
     * @param ColHelper control the change of the collectible item.
     */
    private void upgrade_helper(String type, CollectibleUseManage ColHelper){
        Visual_h_u speaker = new Presenter_bottom();
        Equipment armor = this.player.getEquipment(type);

        speaker.show_upgrade_choice(type);
        //Max Level check before upgrade
        if (!checkMaxLv(armor)) {
            speaker.Warn_MaxLv(type.toLowerCase(Locale.ROOT));
            return;
        }
        //final confirm
        speaker.keypress_request("Y","N");
        if (input.get_decision()) {
            this.player.getEquipment(type).addStatValue(determine_add());
            ColHelper.spendCollectible();
            speaker.show_result("upgrade");
        } else {
            speaker.notifyGiveUp("upgrade");
        }
    }

    /**
     * It will
     */
    public void ItemBroadcast(){
        Visual_h_u speaker = new Presenter_bottom();
        speaker.show_info(this.Essence.getNum(), this.Essence_need, this.Artifact.getNum(), this.Artifact_need,
                this.able, this.verb);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
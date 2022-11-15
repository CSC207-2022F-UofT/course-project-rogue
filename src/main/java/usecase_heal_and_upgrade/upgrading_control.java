package usecase_heal_and_upgrade;

import Interface.InputBoundary_h_u;
import Interface.Visual_h_u;
import controller.Controller;
import entity.Collectible;
import entity.Equipment;
import entity.Player;
import presenter.Presenter_bottom;
import usecase_event.NoEvent;

import java.util.Observable;
import java.util.Observer;


public class upgrading_control implements Observer {
    private final Player player;
    private final Map map;

    public upgrading_control(Player player, Map map) {
        this.player = player;
        this.map = map;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.map.getEvent(this.player.getPlayerLocation()) instanceof NoEvent && arg == "U" || arg == "u") {
            upgrade();
        }
    }

    /**
     * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
     * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
     * collectible items required for upgrading.
     *
     * @return the Essence for the upgrade need.
     */
    private int determine_Ess() {
        int i;
        i = 1;
        return i;
    }

    private int determine_Art() {
        /**
         * Determine the Artifact required to do the upgrading. This method will return a non-negative integer.
         * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
         * collectible items required for upgrading.
         */
        int i;
        i = 1;
        return i;
    }

    /**
     * Determine the equipment add value in the upgrading. This method will return a non-negative integer.
     *
     * @return
     */
    private int determine_add() {
        //I will set the initial value as 10 here.In the future, I hope I can let the difficulty of the game decide the
        //stats increase in upgrading.

        int i;
        i = 10;
        return i;
    }

    private boolean checkMaxLv(Equipment equipment) {
        return equipment.getTimesUpgraded() < 3;
    }


    private void upgrade() {
        /**
         * The basic part of the upgrading, it will return nothing but send messages to presenter.
         */
        Visual_h_u speaker = new Presenter_bottom();
        InputBoundary_h_u input = new Controller();
        CollectibleUseManage ColHelper = new CollectibleUseManage(this.player, determine_Ess(), determine_Art(),
                "upgrade");
        ColHelper.ItemBroadcast();
        //check if able to upgrade
        if (ColHelper.get_able()) {
            speaker.keypress_request("A", "S");
            //check which to upgrade
            if (input.get_upgrade_decision().equals("A")) {
                //situation: upgrade armor
                speaker.show_upgrade_choice("Armor");
                Equipment armor = this.player.getEquipment("Armor");
                //Max Level check before upgrade
                if (!checkMaxLv(armor)) {
                    speaker.Warn_MaxLv("armor");
                    return;
                }
                //final confirm
                speaker.keypress_request("Y","N");
                if (input.get_decision()) {
                    this.player.getEquipment("Armor").addStatValue(determine_add());
                    ColHelper.spendCollectible();
                    speaker.show_result("upgrade");
                } else {
                    speaker.notifyGiveUp("upgrade");
                }
            } else {
                //situation: upgrade sword
                speaker.show_upgrade_choice("Sword");
                Equipment sword = this.player.getEquipment("Sword");
                //Max Level check before upgrade
                if (!checkMaxLv(sword)) {
                    speaker.Warn_MaxLv("sword");
                    return;
                }
                //final confirm
                speaker.keypress_request("Y","N");
                if (input.get_decision()) {
                    sword.addStatValue(determine_add());
                    ColHelper.spendCollectible();
                    speaker.show_result("upgrade");
                } else {
                    speaker.notifyGiveUp("upgrade");
                }

            }
        }
    }
}
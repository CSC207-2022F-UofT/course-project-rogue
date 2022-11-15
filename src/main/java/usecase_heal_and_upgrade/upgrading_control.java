package usecase_heal_and_upgrade;

import Interface.InputBoundary_h_u;
import Interface.Visual_h_u;
import controller.Controller;
import entity.Equipment;
import entity.Player;
import presenter.Presenter_bottom;
import usecase_event.NoEvent;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;


public class upgrading_control implements Observer {
    private final Player player;
    private final Map map;

    /**
     * The constructor of upgrading_control.
     * @param player the player
     * @param map the map that player is in
     */
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

    /**
     * Determine the Artifact required to do the upgrading. This method will return a non-negative integer.
     * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
     * collectible items required for upgrading.
     * @return the Artifact for the upgrade need.
     */
    private int determine_Art() {

        int i;
        i = 1;
        return i;
    }

    /**
     * Determine the equipment add value in the upgrading. This method will return a non-negative integer.
     *
     * @return the number of stats to be added
     */
    private int determine_add() {
        //I will set the initial value as 10 here.In the future, I hope I can let the difficulty of the game decide the
        //stats increase in upgrading.

        int i;
        i = 10;
        return i;
    }

    /**
     *
     * @param equipment the equipment to be checked
     * @return the number of collectible items needed for upgrading
     */
    private boolean checkMaxLv(Equipment equipment) {
        return equipment.getTimesUpgraded() < 3;
    }

    /**
     * The basic part of the upgrading, it will return nothing but send messages to presenter.
     */
    private void upgrade() {

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
        InputBoundary_h_u input = new Controller();
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
}
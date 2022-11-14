package usecase_upgrading_equipments;

import Interface.InputBoundary;
import Interface.Visual;
import controller.Controller;
import entity.Collectible;
import entity.Player;
import presenter.Presenter_bottom;
import usecase_event.Event;
import usecase_event.NoEvent;
import usecase_map.Map;

import java.util.Observable;
import java.util.Observer;


public class upgrading implements Observer{
    private final Player player;
    private final Map map;

    public upgrading(Player player, Map map) {
        this.player = player;
        this.map = map;
    }

    @Override
    public void update(Observable o, Object arg) {
        Event event;
        event = this.map.getEvent(this.player.getPlayerLocation());

        if (event instanceof NoEvent && arg == "U" || arg == "u") {
            upgrade();
        }
    }


    private int determine_Ess(){
        /**
         * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
         * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
         * collectible items required for upgrading.
         */
        int i;
        i = 1;
        return i;
    }

    private int determine_Art(){
        /**
         * Determine the Artifact required to do the upgrading. This method will return a non-negative integer.
         * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
         * collectible items required for upgrading.
         */
        int i;
        i = 1;
        return i;
    }

    private int determine_add(){
        /**
         * Determine the equipment add value in the upgrading. This method will return a non-negative integer.
         * I will set the initial value as 10 here.In the future, I hope I can let the difficulty of the game decide the
         * stats increase in upgrading.
         */
        int i;
        i = 10;
        return i;
    }

    private boolean able_to_upgrade(int Essence_have, int Artifact_have, int Essence_need, int Artifact_need){
        /**
         *A small helper function
         */
        return Essence_need <= Essence_have && Artifact_need <= Artifact_have;
    }

    private String info_writer(int Essence_have, int Essence_need, int Artifact_have, int Artifact_need){
        if(able_to_upgrade(Essence_have,Artifact_have,Essence_need,Artifact_need)) {
            return "You have Essence " + Integer.toString(Essence_have) + "/" + Integer.toString(Essence_need)
                    + ". /n You have Artifact " + Integer.toString(Artifact_have) + "/" +
                    Integer.toString(Artifact_need) + "/n You can upgrade! /n Upgrade Armor or Sword? [A]/[N]";
        }
        return "You have Essence " + Integer.toString(Essence_have) + "/" + Integer.toString(Essence_need)
                + ". /n You have Artifact " + Integer.toString(Artifact_have) + "/" +
                Integer.toString(Artifact_need) + "/n You cannot upgrade! /n Try to grt more collections!";
    }


    private void upgrade() {
        /**
         * The basic part of the upgrading, it will return nothing but send messages to presenter.
         */
        Visual vision = new Presenter_bottom();
        InputBoundary input = new Controller();
        int Essence_need = determine_Ess();
        int Artifact_need = determine_Art();
        Collectible Essence = this.player.getCollectible("Essence");
        Collectible Artifact = this.player.getCollectible("Artifact");
        //check if able to upgrade
        if (able_to_upgrade(Essence.getNum(), Artifact.getNum(), Essence_need, Artifact_need)) {
            vision.show_upgrade_info(info_writer(Essence.getNum(),Essence_need, Artifact.getNum(), Artifact_need));
            //upgrade armor
            if(Character.toLowerCase(input.get_upgrade_decision(true)) == 'a'){
                vision.show_upgrade_info("You decide to upgrade Armor! upgrade? [Y]/[N]");
                if (Character.toLowerCase(input.get_upgrade_decision(true)) == 'y'){
                    this.player.getEquipment("Armor").addStatValue(determine_add());
                    this.player.changeCollectibleAmount("Essence", -Essence_need);
                    this.player.changeCollectibleAmount("Artifact", -Artifact_need);
                    return;
                }
                vision.show_upgrade_info("You choose not to upgrade. Good Luck!");
                return;
            }
            //upgrade sword
            vision.show_upgrade_info("You decide to upgrade Sword! upgrade? [Y]/[N]");
            if (Character.toLowerCase(input.get_upgrade_decision(true)) == 'y'){
                this.player.getEquipment("Sword").addStatValue(determine_add());
                this.player.changeCollectibleAmount("Essence", -Essence_need);
                this.player.changeCollectibleAmount("Artifact", -Artifact_need);
                return;
            }
            vision.show_upgrade_info("You choose not to upgrade. Good Luck!");
            return;
        }
        vision.show_upgrade_info(info_writer(Essence.getNum(),Essence_need, Artifact.getNum(), Artifact_need));
    }
}
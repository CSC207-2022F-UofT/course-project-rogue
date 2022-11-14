package usecase_healing;

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


public class healing implements Observer{
    private final Player player;
    private final Map map;

    public healing(Player player, Map map) {
        this.player = player;
        this.map = map;
    }

    @Override
    public void update(Observable o, Object arg) {
        Player player;
        Event event;
        event = this.map.getEvent(this.player.getPlayerLocation());

        if (event instanceof NoEvent && arg == "H" || arg == "h") {
            heal();
        }
    }


    private int determine_Ess(){
        /**
         * Determine the Essence required to do the healing. This method will return a non-negative integer.
         *
         * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
         * collectible items required for healing.
         *
        */
        int i;
        i = 1;
        return i;
    }

    private int determine_Art(){
        /**
         * Determine the Artifact required to do the healing. This method will return a non-negative integer.
         *
         * I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
         * collectible items required for healing.
         *
         */
        int i;
        i = 1;
        return i;
    }

    private boolean able_to_heal(int Essence_have, int Artifact_have, int Essence_need, int Artifact_need){
        /**
         *A small helper function
         */
        if (Essence_need>Essence_have || Artifact_need>Artifact_have){
            return false;
        }
        return true;
    }

    private boolean CheckFullHP(){
        return this.player.getMaxHitPoint() == this.player.getCurrHitPoint();
    }

    private String info_writer(int Essence_have, int Essence_need, int Artifact_have, int Artifact_need){
        if(able_to_heal(Essence_have,Artifact_have,Essence_need,Artifact_need)) {
            return "You have Essence " + Integer.toString(Essence_have) + "/" + Integer.toString(Essence_need)
                    + ". /n You have Artifact " + Integer.toString(Artifact_have) + "/" +
                    Integer.toString(Artifact_need) + "/n You can heal! /n Healing? [Y]/[N]";
        }
            return "You have Essence " + Integer.toString(Essence_have) + "/" + Integer.toString(Essence_need)
                    + ". /n You have Artifact " + Integer.toString(Artifact_have) + "/" +
                    Integer.toString(Artifact_need) + "/n You cannot heal! /n Try to grt more collections!";
        }


    private void heal() {
        /**
         * The basic part of the healing, it will return nothing but send message to presenter.
         */
        Visual vision = new Presenter_bottom();
        if (CheckFullHP()) {
            vision.show_heal_info("You are full, fool!");
            return;
        }
        InputBoundary input = new Controller();
        int Essence_need = determine_Ess();
        int Artifact_need = determine_Art();
        Collectible Essence = player.getCollectible("Essence");
        Collectible Artifact = player.getCollectible("Artifact");
        if (able_to_heal(Essence.getNum(), Artifact.getNum(), Essence_need, Artifact_need)) {
            vision.show_heal_info(info_writer(Essence.getNum(),Essence_need, Artifact.getNum(), Artifact_need));
            if (input.get_heal_decision()) {
                player.changeCurrHitPoint(player.getMaxHitPoint());
                player.changeCollectibleAmount("Essence", -Essence_need);
                player.changeCollectibleAmount("Artifact", -Artifact_need);
                vision.show_heal_info("Your healing success!!! HP is full now!!!");
                return;
            }
            vision.show_heal_info("You choose not to heal. Good Luck!");
            return;
        }
    }
}
package usecase_healing;

import entity.Collectible;
import entity.Player;
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


    private void heal(){
        /**
         * The basic part of the healing, it will return two string to return
         */
        int Essence_need;
        int Artifact_need;
        Collectible Essence;
        Collectible Artifact;
        String info_text;
        Essence = player.getCollectible("Essence");
        Artifact = player.getCollectible("Artifact");
        Essence_need = determine_Ess();
        Artifact_need = determine_Art();
        if (able_to_heal(Essence.getNum(),Artifact.getNum(),Essence_need,Artifact_need)) {
            info_text = "You have Essence " + Integer.toString(Essence.getNum()) + "/" + Integer.toString(Essence_need)
                    + ". /n You have Artifact " + Integer.toString(Artifact.getNum()) + "/" +
                    Integer.toString(Artifact_need) + "/n You can heal! /n Healing? [Y]/[N]";

            player.changeCurrHitPoint(player.getMaxHitPoint());
            player.changeCollectibleAmount("Essence", Essence_need);
            player.changeCollectibleAmount("Artifact", Artifact_need);
        }
        };

    }


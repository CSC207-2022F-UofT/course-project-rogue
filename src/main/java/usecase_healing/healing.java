package usecase_healing;

import entity.Collectible;
import entity.Player;
import usecase_event.Event;

import java.util.Observable;
import java.util.Observer;


public class healing implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        Player player;
        Event event;
        //player = getPlayer();
        //event = getEvent();

        //if(event instanceof NoEvent && arg == "H" || arg == "h"){
            //heal(player);

        //json_input();
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
        //i = get_difficulty()
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
        //i = get_difficulty()
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

    private boolean

    private void heal(Player player){
        int Essence_need;
        int Artifact_need;
        Collectible Essence;
        Collectible Artifact;
        boolean able_to_heal;
        boolean decide_to_heal;
        Essence = player.getCollectible("Essence");
        Artifact = player.getCollectible("Artifact");
        Essence_need = determine_Ess();
        Artifact_need = determine_Art();
        able_to_heal = able_to_heal(Essence.getNum(),Artifact.getNum(),Essence_need,Artifact_need);
        decide_to_heal = popup_window_heal(Essence.getNum(),Artifact.getNum(),Essence_need,Artifact_need, able_to_heal);
        if (decide_to_heal) {
            player.changeCurrHitPoint(player.getMaxHitPoint());
            player.changeCollectibleAmount("Essence", Essence_need);
            player.changeCollectibleAmount("Artifact", Artifact_need);
        }
        };

    }


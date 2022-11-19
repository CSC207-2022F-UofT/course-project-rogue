package usecase_fights;

import entity.Player;

import java.util.Observable;
import java.util.Observer;

/** A fight sequence. */
public class Fight implements Observer {
    private Player player;
    private final String trigger; // should be "Y"
    private FightDetails details;

    public Fight(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    public void setDetails(FightDetails details){
        this.details = details;
    }

    // then to get all the details just, details.drops, details.winchance, or something

    private String fight(){
        // I need the drops, damage and win chance calculated in fight event here... but how
        // maybe I have a fightHandler class that holds all the info?? and serialize it?? :( blegh

    }
    // if the input returned is Y, should call this method
    // if the input returned is N, call the flee method
        // this should change the state of Player that it is in a fight
        // determine win or loss
        // reduce player hp
        // check if monster has power
        // if yes get boolean
        // if win, give player drops, if mustBeat = true, call usePower
        // if lose and if mustBeat = false, call usePower
        // call presenter to display win result, damage taken, and the drops from monster
        // last thing should change state to not in a fight
        // trigger NoEvent - how?????? fuck it, just tell thomas to change the chances so that no event is more likely.
        // remove the whole taking a bit of damage after fleeing thing to compensate.

    @Override
    public void update(Observable o, Object arg) {
        if(player.getFighting() && trigger.equals(arg)){
            String result = this.fight();
            // call presenter
        }
    }



}

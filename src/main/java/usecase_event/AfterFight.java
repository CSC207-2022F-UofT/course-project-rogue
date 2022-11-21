package usecase_event;

import entity.Player;

import java.util.Observable;
import java.util.Observer;


public class AfterFight implements Observer {
    private final Player player;
    private final String trigger;
    public AfterFight(Player player, String trigger){
        this.player = player;
        this.trigger = trigger; // not sure yet, wanna do space bar but idk if that is possible
    }

    private void changeStates(){
        this.player.setFighting(false);
        this.player.setCanHeal(true);
        this.player.setCanUpgrade(true); // make canupgradeheal into one state?
        // canMove should still be no (i never changed it back in fighter class)
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.player.getFighting() && trigger.equals(arg)){
            this.changeStates();
            // call presenter to ask player if they want to heal or upgrade
        }
    }
}

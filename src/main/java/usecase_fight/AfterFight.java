package usecase_fight;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

/** An event that occurs after a fight. Prompts the user to heal or upgrade a weapon. */
public class AfterFight implements Observer {
    private final Player player;
    private final String trigger; // Continue key
    public AfterFight(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    /** Changes the Player fighting state to false and can heal/ can upgrade state to true. */
    private void changeStates(){
        this.player.setFighting(false);
        // canMove should still be false
    }

    /** Displays a prompt to the user to press [H] or [U]. */
    @Override
    public void update(Observable o, Object arg) {
        if (this.player.getFighting() && trigger.equals(arg)){
            this.changeStates();
            // call Henry's class
        }
    }
}

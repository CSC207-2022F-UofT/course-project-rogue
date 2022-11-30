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
        this.player.setCanHeal(true);
        this.player.setCanUpgrade(true);
        // canMove should still be false (I never changed it back in fighter class)
    }

    /** Displays a prompt to the user to press [H] or [U]. */
    @Override
    public void update(Observable o, Object arg) {
        if (this.player.getFighting() && trigger.equals(arg)){
            this.changeStates();
            String line1 = "Would you like to heal or upgrade a weapon?";
            String line3 = "[H]Heal     or     [U]Upgrade";
            // call presenter to ask player if they want to heal or upgrade
        }
    }
}

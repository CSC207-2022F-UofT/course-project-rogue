package usecase_fight;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;


public class AfterFight implements Observer {
    private final Player player;
    private final String trigger; // Continue key
    public AfterFight(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    private void changeStates(){
        this.player.setFighting(false);
        this.player.setCanHeal(true);
        this.player.setCanUpgrade(true);
        // canMove should still be false (I never changed it back in fighter class)
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.player.getFighting() && trigger.equals(arg)){
            this.changeStates();
            // call presenter to ask player if they want to heal or upgrade
        }
    }
}

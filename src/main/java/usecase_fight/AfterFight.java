package usecase_fight;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

/** A path occurring after a fight. Prompts the user to heal or upgrade a weapon. */
public class AfterFight extends FightPath implements Observer {
    private final Player player;
    private final String trigger;
    public AfterFight(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    /** Changes the Player fighting state to false and can heal/ can upgrade state to true. */
    private void changeStates(){
        this.player.setFighting(false);
        this.player.setCanHeal(true);
        this.player.setCanUpgrade(true);
    }

    /** Displays a prompt to the user to press [H] or [U]. */
    @Override
    public void update(Observable o, Object arg) {
        if (this.player.getFighting() && trigger.equals(arg)){
            this.changeStates();
            outputBoundary.updateText("You can now heal or upgrade a weapon!", "", "", "Press [H] to Heal and [U] to Upgrade Equipments");
        }
    }
}

package usecase_fight;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

/** A Fight. */
public class Fight implements Observer {

    /** The state of the Fight */
    private FightPath state;
    private final Player player;

    /** Trigger for Fighter state */
    private final String trigger1; // fight

    /** Trigger for Runner state */
    private final String trigger2; // run

    /** Trigger for Restarter and AfterFight state */
    private final String trigger3; // continue

    /** Create a new Fight with the given player and triggers. The Fight state is set to Fighter by default. */
    public Fight(Player player, String t1, String t2, String t3){
        this.player = player;
        this.trigger1 = t1;
        this.trigger2 = t2;
        this.trigger3 = t3;
        state = new Fighter(player);
    }

    /** Change the state of the Fight. */
    private void setState(FightPath state){
        this.state = state;
    }

    /**
     * Changes the state of the Fight depending on the given arg. Then, perform the fight action based on the current
     * state.
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (player.getFighting()){
            if (trigger1.equals(arg)){ // input is F, player is in a fight
                this.setState(new Fighter(player));
                state.takePath();
            } else if (trigger2.equals(arg)) { // input if R, player chooses to run
                this.setState(new Runner(player));
                state.takePath();
            } else if (trigger3.equals(arg)){ // input is C, player continues to AfterFight
                this.setState(new AfterFight(player));
                state.takePath();
            }
        } else if (player.getGameOver() && trigger3.equals(arg)) { // input is C, player in GameOver state
            this.setState(new Restarter());
            state.takePath();
        }
    }
}

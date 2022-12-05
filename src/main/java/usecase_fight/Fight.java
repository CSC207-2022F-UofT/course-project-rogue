package usecase_fight;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

public class Fight implements Observer {
    private FightPath state;
    private final Player player;
    private final String trigger1; // fight
    private final String trigger2; // run
    private final String trigger3; // continue

    public Fight(Player player, String t1, String t2, String t3){
        this.player = player;
        this.trigger1 = t1;
        this.trigger2 = t2;
        this.trigger3 = t3;
        state = new Fighter(player);
    }

    private void setState(FightPath state){
        this.state = state;
    }


    @Override
    public void update(Observable o, Object arg) {
        // check if the input is F, R, or C
        if (player.getFighting()){
            if (trigger1.equals(arg)){ // input is F, player is in a fight
                this.setState(new Fighter(player));
                state.takePath();
            } else if (trigger2.equals(arg)) {
                this.setState(new Runner(player));
                state.takePath();
            } else if (trigger3.equals(arg)){
                this.setState(new AfterFight(player));
                state.takePath();
            }
        } else if (player.getGameOver() && trigger3.equals(arg)) {
            // if player is in game over state, and the continue key is pressed, state in restarter
            this.setState(new Restarter());
            state.takePath();
        }
    }
}

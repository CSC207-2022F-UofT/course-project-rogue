package usecase_fight;

import entity.monster.Monster;
import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

/** A path in which a user runs away from a fight. */
public class Runner extends FightPath implements Observer {

    /** A result formatter */
    ResultFormatter rf = new ResultFormatter();

    /** Player that needs to flee. */
    private final Player player;

    /** Keystroke that triggers this runner. */
    private final String trigger; // "R"


    /**
     * Creates a new Runner with the given Player and trigger.
     * @param player Player
     * @param trigger Key stroke to trigger this runner.
     */
    public Runner(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }


    /**
     * Flee from a fight. Sets Player's fighting state to false and move state to true.
     */
    private void flee(){
        player.setFighting(false);
        player.setCanMove(true);

        Monster monster = player.getFight().getMonster();
        String[] result = rf.formatRun(monster);
        outputBoundary.updateText(result[0], result[1], result[2], result[3]);
    }

    /** Triggers this runner if Player is in a fight and if the user gives key input matching trigger. */
    @Override
    public void update(Observable o, Object arg) {
        if(player.getFighting() && trigger.equals(arg)){
            this.flee();
        }
    }
}

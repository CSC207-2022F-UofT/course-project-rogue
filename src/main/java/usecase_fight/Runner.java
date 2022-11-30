package usecase_fight;

import entity.monster.Monster;
import entity.player.Player;
import interface_adapters.OutputBoundary;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/** A runner that allows Player to flee from a fight. */
public class Runner implements Observer {

    /** Output Boundary interface. */
    OutputBoundary outputBoundary;

    /** Player that needs to flee. */
    private final Player player;

    /** Keystroke that triggers this runner. */
    private final String trigger; // "R"

    /**
     * Creates a new Runner with the given Player and trigger.
     * @param player Player
     * @param trigger Key stroke to trigger this runner.
     */
    public Runner(OutputBoundary outputBoundary, Player player, String trigger){
        this.outputBoundary = outputBoundary;
        this.player = player;
        this.trigger = trigger;
    }

    /**
     * Flee from a fight. Sets Player's fighting state to false and move state to true.
     * @return The result of the flee attempt.
     */
    private String flee(){
        player.setFighting(false);
        player.setCanMove(true);

        Monster monster = player.getFight().getMonster();
        Random rand = new Random();
        boolean success = rand.nextBoolean();
        if (success){
            return "You got away safely!";
        } else{
            double dmg = player.getFight().getDamage() * 0.05;
            int fleeDmg = (int) Math.round(dmg * 0.05);
            return String.format("%s hit you as you ran away. Took %d damage.", monster, fleeDmg);
        }
    }

    /** Triggers this runner if Player is in a fight and if the user gives key input matching trigger. */
    @Override
    public void update(Observable o, Object arg) {
        if(player.getFighting() && trigger.equals(arg)){
            String result = this.flee();
            outputBoundary.updateText(result, "", "", "You may continue your journey.");
        }
    }
}

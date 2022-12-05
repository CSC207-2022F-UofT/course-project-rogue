package usecase_fight;

import entity.monster.Monster;
import entity.player.Player;

/** A path in which a user runs away from a fight. */
public class Runner extends FightPath {

    /** A result formatter */
    ResultFormatter rf = new ResultFormatter();

    /** Player that needs to flee. */
    private final Player player;



    /**
     * Creates a new Runner with the given Player and trigger.
     * @param player Player
     */
    public Runner(Player player){
        this.player = player;
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
    public void takePath() {
        this.flee();
    }
}

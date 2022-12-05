package usecase_fight;

import entity.player.Player;


/** A path occurring after a fight. Prompts the user to heal or upgrade a weapon. */
public class AfterFight extends FightPath {
    private final Player player;

    public AfterFight(Player player){
        this.player = player;
    }

    /** Changes the Player fighting state to false and can heal/ can upgrade state to true. */
    private void changeStates(){
        this.player.setFighting(false);
        this.player.setCanHeal(true);
        this.player.setCanUpgrade(true);
    }

    /** Displays a prompt to the user to press [H] or [U]. */
    @Override
    public void takePath() {
        this.changeStates();
        outputBoundary.updateText("You can now heal or upgrade a weapon!", "", "", "Press [C] to continue");
    }
}

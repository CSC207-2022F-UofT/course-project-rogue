package usecase_fight.states;

/** A path in which the user loses the game. */
public class Restarter extends FightPath implements FightState {

    /**
     * Causes the game to go back to the main menu if the Player is in a game over state.
     */
    public void takePath() {
        outputBoundary.updateDead();
    }
}

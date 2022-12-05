package usecase_fight;

/** A path in which the user loses the game. */
public class Restarter extends FightPath {

    /**
     * Causes the game to go back to the main menu if the Player is in a game over state.
     */
    @Override
    public void takePath() {
        outputBoundary.updateDead();
    }
}

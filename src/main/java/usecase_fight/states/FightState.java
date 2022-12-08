package usecase_fight.states;

/** A fight state. */
public interface FightState {

    /** Take a fight path. The behavior of this method changes with different states. */
    void takePath();
}

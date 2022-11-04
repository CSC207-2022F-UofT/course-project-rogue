package usecase_event;

abstract class Event implements Triggerable{

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    public boolean enter() {

        return false;
    }
}

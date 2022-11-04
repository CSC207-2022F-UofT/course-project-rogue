package usecase_event;

abstract class Event implements Triggerable{
    public boolean enter() {
        /** Tells Map whether this tile could be stepped on by Player
         *
         * @returns True if player can step on it, false if it can's
         */
        return false;
    }
}

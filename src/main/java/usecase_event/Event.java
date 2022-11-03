package usecase_event;

abstract class Event implements Triggerable{
    public boolean enter() {
        return false;
    }
}

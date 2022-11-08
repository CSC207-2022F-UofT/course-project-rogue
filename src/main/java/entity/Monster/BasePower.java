package entity.Monster;

public abstract class BasePower {
    /** Whether the Monster must be beaten to use this Power. True iff the Monster must be beat, false otherwise. */
    boolean mustBeat;

    public BasePower(boolean cond){
        this.mustBeat = cond;
    }
}

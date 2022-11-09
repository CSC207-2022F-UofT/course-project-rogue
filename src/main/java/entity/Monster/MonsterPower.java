package entity.Monster;

public abstract class MonsterPower {
    /** Whether the Monster must be beaten to use this Power. True iff the Monster must be beat, false otherwise. */
    boolean mustBeat;

    public MonsterPower(boolean cond){
        this.mustBeat = cond;
    }
}
package entity.monster;

public abstract class MonsterPower extends Power {
    /** Whether the Monster must be beaten to use this Power. True iff the Monster must be beat, false otherwise. */
    private final boolean mustBeat;

    public MonsterPower(boolean cond){
        this.mustBeat = cond;
    }

    /**
     * @return Value of mustBeat.
     */
    public boolean isMustBeat() {
        return mustBeat;
    }
}

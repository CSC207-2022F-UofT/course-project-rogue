package entity.monster;

import entity.Character;

/** A Power of a Character. */
public abstract class Power {
    /** Uses the Power of a Character. */
    public abstract String usePower(Character character);

    // make as an abstract class instead?? tbh no need for interface
}

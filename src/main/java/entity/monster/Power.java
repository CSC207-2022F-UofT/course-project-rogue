package entity.monster;

import entity.Character;

/** A Power of a Character. */
public interface Power {
    /** Uses the Power of a Character. */
    String usePower(Character character);

    // make as an abstract class instead?? tbh no need for interface
}

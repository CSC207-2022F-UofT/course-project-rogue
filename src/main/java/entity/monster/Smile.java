package entity.monster;

import entity.Character;

/** A power that causes a monster to smile at the Player. */
public class Smile extends MonsterPower{

    /**
     * Creates a new Smile power that requires the Monster with this power to be beaten to use the power.
     */
    public Smile(){
        super(true);
    }

    /**
     * Smile at the Player and do nothing.
     *
     * @param player The Player that the Monster smiles at.
     * @return A string representing the action.
     */
    @Override
    public String usePower(Character player) {
        return "The bear smiled at you and left. Strange.";
    }

    @Override
    public String toString(){ return "Unknown"; }
}

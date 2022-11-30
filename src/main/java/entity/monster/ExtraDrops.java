package entity.monster;

import entity.Character;
import entity.player.Player;
import usecase_fight.FightSummary;

public class ExtraDrops extends MonsterPower{

    /**
     * Creates a new ExtraDrops power that requires the monster to be beaten to use it.
     */
    public ExtraDrops(){
        super(true); // must be beat to drop extra
    }

    /**
     * Drops two times the essence dropped in the fight.
     *
     * @param player The Player receiving the extra drops.
     * @return The result of the power use.
     */
    @Override
    public String usePower(Character player) {
        FightSummary summary = ((Player) player).getFight();
        int original = summary.getAmountDrop();
        summary.addAmountDrop(original); // doubles the essence drops
        return String.format("%d extra essence dropped!", original);
    }
}

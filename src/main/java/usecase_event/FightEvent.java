package usecase_event;

import entity.Monster.Monster;
import entity.Player;
import usecase_gamedata.MonsterFactory;

public class FightEvent extends Event{
    MonsterFactory factory;

    public FightEvent(MonsterFactory factory){
        this.factory = factory;
    }
    @Override
    public void trigger(Player player) {
        MonsterFactory monsterFactory = new MonsterFactory();
        // Monster monster = monsterFactory.getMonster()

        // obtain a monster, calculate win chance, damage, and drops
        // maybe i need a class to hold this info?? or will i just have to calculate twice...
        // call presenter, update text box to summarize these. Allow player option to fight or flee [Y] or [N]
        // + monster power
        // following this, the specific use cases will be called
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(){
        return true;
    }
}

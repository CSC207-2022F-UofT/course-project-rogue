package usecase_event;

import java.util.Random;
import entity.Player;
import usecase_gamedata.EquipmentFactory;
import usecase_gamedata.MonsterFactory;

public class RandomEvent extends Event{

    MonsterFactory monsterFactory;
    EquipmentFactory equipmentFactory;

    public RandomEvent(MonsterFactory mf, EquipmentFactory ef){
        this.monsterFactory = mf;
        this.equipmentFactory  = ef;
    }

    /**
     * Triggering this Event randomly Triggers Fight Event, no Event or Essence Event
     *
     * @param player the player triggering the Event
     */
    @Override
    public void trigger(Player player) {
        Random random = new Random();
        int random_prob = random.nextInt(101);
        if (random_prob < 70){
            FightEvent fightEvent = new FightEvent(monsterFactory, equipmentFactory);
            fightEvent.trigger(player);
        }
        else {
            EssenceEvent essenceEvent = new EssenceEvent();
            essenceEvent.trigger(player);
        }
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){

        return true;
    }

}

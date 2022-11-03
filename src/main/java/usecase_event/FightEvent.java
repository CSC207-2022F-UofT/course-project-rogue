package usecase_event;

import entity.Player;

public class FightEvent extends Event{
    @Override
    public Object trigger(Player player) {
        return null;
    }
    @Override
    public boolean enter(){
        return true;
    }
}

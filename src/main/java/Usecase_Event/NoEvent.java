package Usecase_Event;

import Entity.Player;

public class NoEvent implements Triggerable{
    @Override
    public Object trigger(Player player) {
        return null;
    }
}

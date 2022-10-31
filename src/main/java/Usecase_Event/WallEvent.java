package Usecase_Event;

import Entity.Player;

public class WallEvent extends Event implements Triggerable{

    @Override
    public Object trigger(Player player) {
        return null;
    }
}

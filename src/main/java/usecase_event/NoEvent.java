package usecase_event;

import entity.Player;

public class NoEvent extends Event{
    @Override
    public Object trigger(Player player) {
        return null;
    }
}

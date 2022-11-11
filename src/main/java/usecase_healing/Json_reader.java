package usecase_healing;

import entity.Player;
import usecase_event.Event;

public interface Json_reader {
    Player getPlayer();
    Event getEvent();

}

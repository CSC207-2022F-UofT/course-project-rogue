package usecase_event;

import entity.Player;

public interface Triggerable {
    Object trigger(Player player);
    //May Change this to Strings because we may need to return text box to the output boundary
}

package Interface;

import javafx.beans.Observable;

public interface InputBoundary_h_u extends Observable {
    /**
     * The method will return the player decide to upgrade sword or armor.
     * @param EquipmentChoice
     * @return return the choice keyword [A][S]
     */
    String get_upgrade_decision();

    /**
     * The method will return if player decide to upgrade/heal
     * @return whether player decide to upgrade
     */
    boolean get_decision();
    //The method will only return if the player will update.
    //This method will let the player choose whether to heal. It will let the player to press [Y] or [N].
    //If player press other letter or number, the method will print "I need to decide whether to heal first, please
    // press [Y] or [N]"
}

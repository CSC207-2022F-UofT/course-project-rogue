package usecase_upgrading_equipments;

public interface popup_window_upgrade {

    boolean upgrade_info_pop_up(int Essence_have, int Artifact_have, int Essence_need, int Artifact_need,
                             boolean upgrade_able);
    //This method will let the game popup a window. The window will show the numbers of collectible items the player
    //have for the upgrading required. And it will tell if the player can finish the upgrading action.
    //The return result will let the player decide if they will upgrade. The player will press [Y] or [N]
    //or click the button on the popup window.
    // It will return TURE for the yes decision and FALSE for no. If upgrade_able is False, it will return False anyway.

}

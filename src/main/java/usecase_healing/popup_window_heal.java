package usecase_healing;

public interface popup_window_heal {

    boolean heal_info_pop_up(int Essence_have, int Artifact_have, int Essence_need, int Artifact_need,
                             boolean heal_able);
    //This method will let the game popup a window. The window will show the numbers of collectible items the player
    //have for the healing required. And it will tell if the player can finish the healing action.
    //The return result will let the player decide if they will heal. The player will press [Y] or [N]
    //or click the button on the popup window.
    // It will return TURE for the yes decision and FALSE for no. If heal_able is False, it will return False anyway.

}

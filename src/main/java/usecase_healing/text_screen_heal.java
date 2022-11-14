package usecase_healing;

public interface text_screen_heal {

    void show_heal_info(String Text);
    //This method will be showed in the bottom text part of the game.
    //The window will show the numbers of collectible items the player have for the healing required.
    //And it will tell if the player can finish the healing action.
    //The return result will let the player decide if they will heal. The player will press [Y] or [N]
    //or click the button on the popup window.
    // It will return TURE for the yes decision and FALSE for no. If heal_able is False, it will return False anyway.

    boolean get_heal_decision();
    //The method will only return if the player will update.
    //This method will let the player choose whether to heal. It will let the player to press [Y] or [N].
    //If player press other letter or number, the method will print "I need to decide whether to heal first, please
    // press [Y] or [N]"
}

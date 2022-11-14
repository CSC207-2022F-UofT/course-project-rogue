package Interface;

public interface InputBoundary {
    char get_upgrade_decision();
    //The method will return the player decide to upgrade sword or armor. It will let the player press [A] or [S]
    //If player press other letters or numbers, the method will print "I need to decide what to upgrade, please
    // press [A] or [S]"
    //This method will let the player choose whether to upgrade. It will let the player press [Y] or [N].
    //If player press other letters or numbers, the method will print "I need to decide whether to upgrade, please
    // press [Y] or [N]"

    boolean get_heal_decision();
    //The method will only return if the player will update.
    //This method will let the player choose whether to heal. It will let the player to press [Y] or [N].
    //If player press other letter or number, the method will print "I need to decide whether to heal first, please
    // press [Y] or [N]"
}

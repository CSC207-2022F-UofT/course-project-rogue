package gamedata;

import java.util.HashMap;

/**
 * This class is used to store instances of entities.
 * @author John Chen
 */
public class GameInstance extends GameData{


    protected boolean stored;
    //without declaring public, protected, private, the default access level is anywhere in the GameData package.
    static HashMap<String, Object> entityInstance;
}

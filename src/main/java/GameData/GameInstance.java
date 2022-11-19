package GameData;

import FileReader.GameFileReader_interface;

import java.util.HashMap;

/**
 * This class is used to store instances of entities.
 * @author John Chen
 */
public abstract class GameInstance<Entity>{
    protected boolean stored;
    protected HashMap<String, Entity> entityInstance;

    public abstract Entity getInstance();

    public abstract void store(Entity instance);
}

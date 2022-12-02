package game_data;

import java.util.HashMap;


public abstract class GameInstance<Entity>{
    protected boolean stored;
    protected HashMap<String, Entity> entityInstance;

    public abstract Entity getInstance();

    public abstract void store(Entity instance);
}

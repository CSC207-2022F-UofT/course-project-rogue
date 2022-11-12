package GameData;
import FileReader.GameFileReader_interface;
import com.fasterxml.jackson.databind.node.ObjectNode;
import entity.Player;
import org.json.simple.parser.ParseException;
import usecase_gamedata.factory;

import java.io.IOException;
import java.util.HashMap;


public class PlayerInstances extends GameInstance<Player>{
    factory factory;
    public PlayerInstances(factory f) throws IOException, ParseException {
        this.entityInstance = new HashMap<String, Player>();
        this.stored = false;
        this.factory = f;
    }

    /**
     * @return  last stored instance of Player or make a new instance if it was not stored.
     */
    @Override
    public Player getInstance() {
        if(this.stored){
            return this.entityInstance.get("Basic Player");
        }else{
            return (Player) this.factory.create();
        }
    }

    /**
     * Persist the instance created or used.
     * @param instance : The instance of the Player we are storing
     */
    @Override
    public void store(Player instance) {
        entityInstance.put("Basic Player", instance);
        this.stored = true;
    }
}

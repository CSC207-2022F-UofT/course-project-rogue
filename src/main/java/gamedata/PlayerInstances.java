package gamedata;
import filereader.GameFileReader_interface;
import entity.Player;
import org.json.simple.parser.ParseException;
import usecase_gamedata.BasicPlayerFactory;
import java.io.IOException;
import java.util.HashMap;


public class PlayerInstances extends GameInstance implements EntityInstance_Interface<Player>{

    private GameFileReader_interface fileReader;
    BasicPlayerFactory factory;
    public PlayerInstances(GameFileReader_interface fileReader, BasicPlayerFactory factory) throws IOException, ParseException {
        this.fileReader =fileReader;
        entityData.put("Player", this.fileReader.getPlayerData());
        this.stored = false;
        this.factory = factory;
    }

    /**
     * @return  last stored instance of Player or make a new instance if it was not stored.
     */
    @Override
    public Player getInstance() {
        if(this.stored){
                return (Player) entityInstance.get("BasicPlayer");
        }else {
            try {
                //Create Player from data stored in entityData and return it
                HashMap<String, Object>[] playerDatas = fileReader.getPlayerData();
                for (HashMap<String, Object> playerData : playerDatas) {
                    entityInstance.put((String) playerData.get("Class"), playerData);
                }
                entityData.put("BasicPlayer", factory.create(entityInstance, "BasicPlayer"));
                return (Player) entityInstance.get("BasicPlayer");
            } catch (IOException | ParseException ex) {
                String msg = ex.getMessage();
                System.out.println(msg);
                return null;
            }
        }
    }

    /**
     * @param instance
     */
    @Override
    public void store(Player instance) {
        entityInstance.replace("BasicPlayer", instance);
        this.stored = true;
    }
}

package GameData;
import FileReader.GameFileReader_interface;
import entity.Player;
import org.json.simple.parser.ParseException;
import usecase_gamedata.PlayerFactory;
import java.io.IOException;


public class PlayerInstances extends GameInstance implements entityInstance_interface<Player>{

    private GameFileReader_interface fileReader;
    PlayerFactory factory;
    public PlayerInstances(GameFileReader_interface fileReader) throws IOException, ParseException {
        this.fileReader =fileReader;
        entityData.put("Player", this.fileReader.getPlayerData());
        this.stored = false;
        this.factory = new PlayerFactory();
    }

    /**
     * @return  last stored instance of Player or make a new instance if it was not stored.
     */
    @Override
    public Player getInstance() {
        if(this.stored){
            return (Player) entityInstance.get("Player");
        }else{
            //Create Player from data stored in entityData and return it
        }
    }

    /**
     * @param instance
     */
    @Override
    public void store(Player instance) {
        entityInstance.replace("Player", instance);
        this.stored = true;
    }
}

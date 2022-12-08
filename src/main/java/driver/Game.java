package driver;

import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import file_writer.GameFileWriter;
import file_writer.GameFileWriterInterface;
import interface_adapters.Controller;
import interface_adapters.OutputBoundary;
import usecase_essence_use.manager.EssenceUseInfoPass;
import usecase_event.Event;
import usecase_event.WinEvent;
import usecase_factories.EquipmentFactory;
import usecase_factories.MonsterFactory;
import usecase_factories.PlayerFactory;
import usecase_fight.FightPath;
import usecase_gamedata.MapFactory;
import usecase_playeractions.Map;
import user_interface.View;
import user_interface.ViewInterface;
import user_interface.Visual;

public class Game {

    public static void main(String[] args) {
        GameFileReaderInterface playerReader = new GameFileReader("data_base/Player.json");
        GameFileReaderInterface monsterReader = new GameFileReader("data_base/Monster.json");
        GameFileReaderInterface mapReader = new GameFileReader("data_base/Map.json");
        GameFileReaderInterface equipmentReader = new GameFileReader("data_base/Equipment.json");
        GameFileWriterInterface playerWriter = new GameFileWriter("data_base/Player_save.json");
        playerWriter.register(playerReader);
        playerReader.update("data_base/Player_save.json");

        //Use cases inject outputBoundary, fileReader, fileWriter
        PlayerFactory.setFileReader(playerReader);
        WinEvent.setFileWriter(playerWriter);
        MonsterFactory.setFileReader(monsterReader);
        EquipmentFactory.setFileReader(equipmentReader);
        MapFactory.setFileReader(mapReader);

        PlayerFactory playerFactory = new PlayerFactory();
        MapFactory mapFactory = new MapFactory();
        Controller controller = new Controller(playerFactory, mapFactory);
        ViewInterface vi = new View(controller);
        OutputBoundary outBound = new Visual(vi);
        Event.setOutputBoundary(outBound);
        Map.setOutputBoundary(outBound);
        MapFactory.setOutputBoundary(outBound);
        FightPath.setOutputBoundary(outBound);
        EssenceUseInfoPass.setOutputBoundary(outBound);

        vi.setVisible(true);
    }

}

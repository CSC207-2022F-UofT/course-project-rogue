package usecase_heal_and_upgrade;

import java.util.Observable;
import java.util.Observer;

public class EquipmentDecision implements Observer {
    boolean Update;
    String Choice;

    public EquipmentDecision(){
        this.Update =false;
        this.Choice = "";
    }
    @Override
    public void update(Observable o, Object arg) {
        this.Update = true;
    }
}

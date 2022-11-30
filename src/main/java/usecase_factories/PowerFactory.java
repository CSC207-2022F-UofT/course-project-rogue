package usecase_factories;

import entity.monster.Smile;
import entity.monster.ExtraDrops;
import entity.monster.Power;
import entity.monster.Steal;

/** A simple factory for Powers. */
public class PowerFactory {
    public Power getPower(String pwr) throws Exception {
        return switch (pwr) {
            case "Steal" -> new Steal();
            case "ExtraDrops" -> new ExtraDrops();
            case "Smile" -> new Smile();
            default -> throw new Exception("Power does not exist");
        };
    }
}

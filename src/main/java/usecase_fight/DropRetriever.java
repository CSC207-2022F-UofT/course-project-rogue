package usecase_fight;

import entity.Equipment;
import usecase_gamedata.EquipmentFactory;

import java.util.Optional;
import java.util.Random;

/** A Retriever that obtains the items dropped after a fight. */
public class DropRetriever {

    Random rand = new Random();

    /**
     * @return the Equipment drop of a fight.
     */
    public Optional<Equipment> getEquipment(){
        // determine whether equip drop
        boolean dropEquipment = this.isEquipmentDrop();

        // get equipment drop
        if(dropEquipment){
            int index = rand.nextInt(8); // index from 0 to 7
            Equipment equipment = EquipmentFactory.create(index);
            return Optional.of(equipment);
        }
        return Optional.empty();
    }

    /**
     * @return The number of essence that will be dropped.
     */
    public int getEssenceNum(){
        return rand.nextInt(10) + 1; // drop a random number of essence from 1 to 10 inclusive
    }


    /** Determines whether to drop equipment from fight.
     *
     * @return True iff an equipment will be dropped.
     */
    private boolean isEquipmentDrop() {
        int result = rand.nextInt(101);
        return result <= 10; // drops a piece of equipment w/ 10% chance
    }

}

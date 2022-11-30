package usecase_fight;

import entity.item.Equipment;
import usecase_factories.EquipmentFactory;

import java.util.Optional;
import java.util.Random;

/** A Retriever that obtains the items dropped after a fight. */
public class DropRetriever {
    EquipmentFactory ef;

    Random rand = new Random();

    public DropRetriever(EquipmentFactory ef) {
        this.ef = ef;
    }

    /**
     * @return the Equipment drop of a fight.
     */
    public Optional<Equipment> getEquipment(){
        boolean dropEquipment = this.isEquipmentDrop();

        // get equipment drop
        if(dropEquipment){
            int index = rand.nextInt(8); // index from 0 to 7
            Equipment equipment = ef.create(index);
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

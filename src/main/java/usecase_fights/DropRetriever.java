package usecase_fights;

import java.util.Random;

/** A Retriever that obtains the items dropped after a fight. */
public class DropRetriever {
    /**
     * Get the drops of a fight.
     */
    public void getDrops(){
        // determine whether we will drop weapon or armour, essence or artifact
        boolean dropEquipment = this.isEquipmentDrop();
        boolean dropArtifact = this.isArtifactDrop();
        if (dropArtifact){
            int artifact = this.getCollectibleNum("Artifact");
        } else{
            int essence = this.getCollectibleNum("Essence");
        }

        // if(dropEquipment){
            // choose a random index to create weapon
        // }
    }

    /**
     * @return Whether to drop an Artifact
     */
    private boolean isArtifactDrop() {
        Random rand = new Random();
        return rand.nextBoolean(); // randomly decides if Artifact is dropped
    }

    private boolean isEquipmentDrop() {
        Random rand = new Random();
        int result = rand.nextInt(101);
        return result <= 10; // drops a piece of equipment w/ 10% chance
    }

    /**
     *
     * @param collectibleType The type of Collectible that will be dropped.
     * @return The number of Collectibles that will be dropped.
     */
    private int getCollectibleNum(String collectibleType){
        Random rand = new Random();
        int bound = 0;
        if(collectibleType.equals("Essence")){
            bound = 10; // drops 1-10 essence inclusive
        } else if (collectibleType.equals("Artifact")) {
            bound = 2; // drops 1-2 artifact inclusive
        }
        return rand.nextInt(bound) + 1;
    }
}

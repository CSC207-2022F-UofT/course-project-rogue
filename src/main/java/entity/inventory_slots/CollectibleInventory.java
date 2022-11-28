package entity.inventory_slots;
import entity.item.Collectible;
import file_reader.deserialization.CollectibleInventoryDeserialization;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CollectibleInventoryDeserialization.class)
public class CollectibleInventory extends BasicInventory {

    private final Collectible artifact;
    private final Collectible essence;

    /** Creates the entity.item.Collectible Inventory Class, which holds only the Essence
     * and Artifact for the Player
     *
     * @param inventoryName: Name of Inventory as String
     * @param essence: entity.item.Collectible class of Player to upgrade equipment and heal
     * @param artifact entity.item.Collectible class of Player to win the game
     */
    public CollectibleInventory(String inventoryName, Collectible essence, Collectible artifact) {

        super(inventoryName);
        this.artifact = artifact;
        this.essence = essence;
    }


    /** Gets the artifact Collectible
     *
     * @return The collectible stored inside the inventory
     */
    public Collectible getArtifact(){

        return this.artifact;
    }

    /** Gets the essence Collectible
     *
     * @return The collectible stored inside the inventory
     */
    public Collectible getEssence(){
        return this.essence;
    }

    /** Changes the number of Essence in the inventory
     *
     * @param amount: Adds amoount to current amount, the boundary of amount is
     *                 -infinity < amount < infinity
     */
    public void changeEssenceAmount(int amount){
        this.essence.changeNum(amount);
    }

    /** Changes the number of Artifact in the inventory
     *
     * @param amount: Adds amoount to current amount, the boundary of amount is
     *                 -infinity < amount < infinity
     */

    public void changeArtifactAmount(int amount){
        this.artifact.changeNum(amount);
    }
}

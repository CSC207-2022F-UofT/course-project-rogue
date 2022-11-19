package entity;

import FileReader.deserialization.collectibleInventoryDeserialization;
import FileReader.deserialization.playerDeserialization;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;

@JsonDeserialize(using = collectibleInventoryDeserialization.class)
public class CollectibleInventory extends BasicInventory{

    private final HashMap<String, Collectible> inventory = new HashMap<>();

    /** Creates the entity.Collectible Inventory Class, which holds only the Essence
     * and Artifact for the Player
     *
     * @param inventoryName: Name of Inventory as String
     * @param essence: entity.Collectible class of Player to upgrade equipment and heal
     * @param artifact entity.Collectible class of Player to win the game
     */

    public CollectibleInventory(String inventoryName, Collectible essence, Collectible artifact) {

        super(inventoryName);
        this.inventory.put(essence.getName(), essence);
        this.inventory.put(artifact.getName(), artifact);
    }


    /** Gets the name of the inventory
     *
     * @return The collectible stored inside the inventory
     */
    public Collectible getCollectible(String collectibleType){

        return this.inventory.get(collectibleType);
    }

    /** Creates the entity.Collectible Inventory Class
     *
     * @param collectibleType: Type of collectible you want to get from inventory
     *                       which is either "Essence", or "Artifact" in this case.
     * @param amount: Adds amoount to current amount, the boundary of amount is
     *                 -infinity < amount < infinity
     */
    public void changeAmount(String collectibleType, int amount){

        Collectible collectible = getCollectible(collectibleType);
        collectible.changeNum(amount);
    }
}

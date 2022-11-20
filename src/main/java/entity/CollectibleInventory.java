package entity;

import java.util.HashMap;

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

    /** Changes the amount of the given collectible to the given amount.
     *
     * @param collectibleType: Type of collectible you want to get from inventory
     *                       which is either "Essence", or "Artifact" in this case.
     * @param amount: The number to be added to the collectible amount. Can be positive or negative.
     */
    public void changeAmount(String collectibleType, int amount){

        Collectible collectible = getCollectible(collectibleType);
        collectible.changeNum(amount);
    }
}

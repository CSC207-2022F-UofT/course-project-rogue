package entity;

import java.util.HashMap;

public class CollectibleInventory extends BasicInventory{

    private HashMap<String, Collectible> inventory = new HashMap<>();

    /** Creates the entity.Collectible Inventory Class
     *
     * @param inventoryName: Name of Inventory as String
     * @param essence: entity.Collectible class of Player to upgrade and heal
     * @param artifact entity.Collectible class of Player to win the game
     */
    public CollectibleInventory(String inventoryName, Collectible essence, Collectible artifact) {

        super(inventoryName);
        this.inventory.put("Essences", essence);
        this.inventory.put("Artifact", artifact);
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
     * @param amount: Adds amoount to current amount, the boundary of amount is
     *                 -infinity < amount < infinity
     */
    public void setInventory(String collectibleType, int amount){

        Collectible collectible = getCollectible(collectibleType);
        int currAmount = collectible.getNum();
        collectible.changeNum(currAmount + amount);
    }
}

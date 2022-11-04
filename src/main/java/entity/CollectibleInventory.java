package entity;

import java.util.HashMap;

public class CollectibleInventory extends BasicInventory{
    private String name;
    private HashMap<String, Collectible> inventory = new HashMap<String, Item>();
    public CollectibleInventory(String inventoryName, Collectible essence, Collectible artifact) {
        /** Creates the Collectible Inventory Class
         *
         * @param inventoryName: Name of Inventory as String
         * @param essence: Collectible class of Player to upgrade and heal
         * @param artifact Collectible class of Player to win the game
         * @return Creates the Collectible Inventory Class
         */

        super(inventoryName);
        this.inventory.put("Essences", essence);
        this.inventory.put("Artifact", artifact);
    }

    @Override
    public String getName() {
        /** Gets the name of the inventory
         *
         * @return the name of the inventory
         */
        return name;
    }

    public Collectible getCollectible(String collectibleType){
        /** Gets the name of the inventory
         *
         * @return The collectible stored inside the inventory
         */
        return this.inventory.get(collectibleType);
    }

    public void setInventory(String collectibleType, int amount){
        /** Creates the Collectible Inventory Class
         *
         * @param collectibleType: Type of collectible you want to get from inventory
         * @param amoount: Adds amoount to current amount, the boundary of amount is
         *                 -infinity < amount < infinity
         * @return Creates the Collectible Inventory Class
         */
        Collectible collectible = getCollectible(collectibyType);
        int currAmoount = collectible.getAmount();
        collectible.setAmount(currAmoount + amount);
    }
}

package Entity;

import java.util.Collections;
import java.util.HashMap;

public class CollectibleInventory extends BasicInventory{
    private String name;
    private HashMap<String, Collectible> inventory = new HashMap<String, Item>();
    public CollectibleInventory(String inventoryName, Collectible essence, Collectible artifact) {
        super(inventoryName);
        this.inventory.put("Essences", essence);
        this.inventory.put("Essences", artifact);
    }

    @Override
    public String getName() {
        return name;
    }

    public Collectible getCollectible(String collectibleType){
        return this.inventory.get(collectibleType);
    }

    public void setInventory(String collectibyType, int amount){
        Collectible collectible = getCollectible(collectibyType);
        int currAmoount = collectible.getAmount();
        collectible.setAmount(currAmoount + amount);
    }
}

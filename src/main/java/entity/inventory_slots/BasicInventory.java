package entity.inventory_slots;

public abstract class BasicInventory {
    private final String name;

    /** Constructs a Basic Inventory
     *
     * @param inventoryName: name of Inventory as String
     */
    public BasicInventory(String inventoryName){

        this.name = inventoryName;
    }

}

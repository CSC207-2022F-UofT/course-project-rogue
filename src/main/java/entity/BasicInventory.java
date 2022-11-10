package entity;

public abstract class BasicInventory {
    private final String name;

    /** Constructs a Basic Inventory
     *
     * @param inventoryName: name of Inventory as String
     */
    public BasicInventory(String inventoryName){

        this.name = inventoryName;
    }

    /** Gets the name of the inventory
     *
     * @return the name of the inventory
     */
    public String getName(){

        return this.name;
    }

}

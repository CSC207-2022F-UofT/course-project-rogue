package entity;

public abstract class BasicInventory {
    private String name;
    public BasicInventory(String inventoryName){
        /** Constructs a Basic Inventory
         *
         * @param inventoryName: name of Inventory as String
         * @return creates the basic inventory class
         */
        this.name = inventoryName;
    }
    public String getName(){
        /** Gets the name of the inventory
         *
         * @return the name of the inventory
         */
        return this.name;
    }

}

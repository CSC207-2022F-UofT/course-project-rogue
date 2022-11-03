package entity;

public abstract class BasicInventory {
    private String name;
    public BasicInventory(String inventoryName){
        this.name = inventoryName;
    }
    public String getName(){
        return this.name;
    }

}

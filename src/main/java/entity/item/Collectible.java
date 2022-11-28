package entity.item;


public class Collectible extends Item {

    /**
     * Creates a new Collectible object.
     * It should only be used for artifacts, since its num attribute will always start at 0.
     * @param collectibleType the type of this Collectible.
     */
    public Collectible(String collectibleType){
        super(collectibleType);
    }

    /**
     * Creates a new Collectible object.
     * It should only be used for essence, since they can be instantiated with a starting value.
     * @param collectibleType the type of this Collectible.
     * @param num the amount of this Collectible.
     */
    public Collectible(String collectibleType, int num){
        super(collectibleType, num);
    }
}

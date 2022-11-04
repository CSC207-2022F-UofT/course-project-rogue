package entity;

import entity.Item;

public class Collectible extends Item {

    /**
     * Creates a new entity.Collectible object.
     * @param collectibleType the type of this entity.Collectible.
     */
    public Collectible(String collectibleType){
        super(collectibleType);
    }

    /**
     * Creates a new entity.Collectible object.
     * @param collectibleType the type of this entity.Collectible.
     * @param num the amount of this entity.Collectible.
     */
    public Collectible(String collectibleType, int num){
        super(collectibleType, num);
    }

    /**
     * Sets the num of the entity.Collectible to the collectibleNum given.
     * @param collectibleNum the new value for num.
     */
    public void setCollectibleNum(int collectibleNum){
        int difference = collectibleNum - this.getNum();
        this.changeNum(difference);
    }
}

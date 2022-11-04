public class Collectible extends Item {

    /**
     * Creates a new Collectible object.
     * @param collectibleType the type of this Collectible.
     */
    public Collectible(String collectibleType){
        super(collectibleType);
    }

    /**
     * Creates a new Collectible object.
     * @param collectibleType the type of this Collectible.
     * @param num the amount of this Collectible.
     */
    public Collectible(String collectibleType, int num){
        super(collectibleType, num);
    }

    /**
     * Sets the num of the Collectible to the collectibleNum given.
     * @param collectibleNum the new value for num.
     */
    public void setCollectibleNum(int collectibleNum){
        int difference = collectibleNum - this.getNum();
        this.changeNum(difference);
    }
}

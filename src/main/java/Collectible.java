public class Collectible extends Item {

    /**
     * Creates a new Collectible object.
     * @param collectibleType the type of this Collectible.
     */
    public Collectible(String collectibleType){
        super(collectibleType, 0);
    }

    public void setCollectibleNum(int collectibleNum){
        int difference = collectibleNum - this.getNum();
        this.addNum(difference);
    }

}

package entity;

public abstract class Item {
    private final String name; // is this final??? // the name of the entity.Item
    private int num; // the number of items in entity.Item

    /**
     * Creates a new entity.Item object.
     * This constructor takes in a single String as and a single int as arguments..
     * @param name the name of the entity.Item.
     * @param num the number of items in the entity.Item object.
     */
    public Item(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Item(String name){
        this.name = name;
    }

    /**
     * Returns the name of the entity.Item.
     * @return the name of the entity.Item.
     */
    public String getName(){return this.name;}

    /**
     * Returns the number of items in the entity.Item object.
     * @return the number of items in the entity.Item object.
     */
    public int getNum(){return this.num;}

    /**
     * Decreases or increases num.
     * @param be_added a negative or positive integer to add to num. If be_added makes num negative, num is set to 0.
     */
    public void changeNum(int be_added) {
        this.num = Math.max(this.num + be_added, 0);
    }

    /**
     * Return the String representation of this entity.Item object.
     * @return the name of this entity.Item.
     */
    @Override
    public String toString(){
        return this.name;
    }
}

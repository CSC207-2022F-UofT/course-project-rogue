package entity;

public abstract class Item {
    private final String name; // the name of the Item
    private int num; // the number of items in Item

    /**
     * Creates a new Item object.
     * This constructor takes in a single String as and a single int as arguments..
     * @param name the name of the Item.
     * @param num the number of items in the Item object.
     */
    public Item(String name, int num) {
        this(name); this.num = num;
    }

    /**
     * Creates a new Item object.
     * This constructor takes in a single String for arguments.
     * @param name the name of the Item.
     */
    public Item(String name){
        this.name = name;
    }

    /**
     * Returns the name of the Item.
     * @return the name of the Item.
     */
    public String getName(){return this.name;}

    /**
     * Returns the number of items in the Item object.
     * @return the number of items in the Item object.
     */
    public int getNum(){return this.num;}

    /**
     * Sets the value of num to the number given.
     * @param n the new value of num.
     */
    public void setNum(int n){this.num = n;}

    /**
     * Decreases or increases num.
     * @param be_added a negative or positive integer to add to num. If be_added makes num negative, num is set to 0.
     */
    public void changeNum(int be_added) {
        this.num = Math.max(this.num + be_added, 0);
    }

    /**
     * Return the String representation of this Item object.
     * @return the name of this Item.
     */
    @Override
    public String toString(){
        return this.name;
    }

}

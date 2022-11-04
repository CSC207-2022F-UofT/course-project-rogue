public abstract class Item {
    private final String name; // is this final??? // the name of the Item
    private int num; // the number of items in Item

    /**
     * Creates a new Item object.
     * This constructor takes in a single String as and a single int as arguments..
     * @param name the name of the Item.
     * @param num the number of items in the Item object.
     */
    public Item(String name, int num) {
        this.name = name;
        this.num = num;
    }

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
     * Decreases or increases num.
     * @param be_added a negative or positive integer to add to num.
     */
    public void changeNum(int be_added) {
        this.num = this.num + be_added;
    }


    public boolean checkMinusAvailable(int be_minus){
        return this.num - be_minus >= 0;
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

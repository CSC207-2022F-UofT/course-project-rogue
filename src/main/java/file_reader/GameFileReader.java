package file_reader;

public class GameFileReader implements GameFileReaderInterface {

    private String dir;
    private String startingDir;
    public GameFileReader(String dir){
        this.dir = dir;
        this.startingDir = dir;
    }
    /**
     * @param key : the key of the value we are trying to find.
     * @param value : the value parameter "key" points to.
     * @return the jsonObject in string form found by iterative order with this key to value. Return
     * null if no such jsonObject exist.
     */
    @Override
    public String findInt(String key, int value) {
        return findInt_helper(key, value, this.dir);
    }

    /**
     * @param key : the key of the value we are trying to find.
     * @param value : the value parameter "key" points to.
     * @return the jsonObject in string form found by iterative order with this key to value. Return
     * null if no such jsonObject exist.
     */
    @Override
    public String findString(String key, String value){
        return findString_helper(key, value, this.dir);
    }

    /**
     * @param key : the key of the value we are trying to find.
     * @param value : the value parameter "key" points to.
     * @return the jsonObject in string form found by iterative order with this key to value. Return
     * null if no such jsonObject exist.
     */
    @Override
    public String findBoolean(String key, Boolean value){
        return findBoolean_helper(key, value, this.dir);
    }

    /**
     * @param dir : new directory that this GameFileReader reads.
     */
    @Override
    public void update(String dir) {
        this.dir = dir;
    }

}

package interface_adapters;

public interface InputBoundary{
    /**
     * Notify the observers that command s is being inputted.
     * @param s The command
     */
    void keyPressed(String s);
}

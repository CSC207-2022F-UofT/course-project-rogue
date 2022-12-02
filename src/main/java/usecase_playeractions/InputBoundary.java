package usecase_playeractions;

public interface InputBoundary{

    /**
     * Notify the observers that command s is being inputted.
     * @param s The command
     */
    public void keyPressed(String s);

}


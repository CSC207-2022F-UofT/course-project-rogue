package fileWriter;

import entity.Player;

public interface GameFileWriter_Interface {
    public void writeToFile(Player player);
    public void setDir(String dir);
    public String getDir();
}

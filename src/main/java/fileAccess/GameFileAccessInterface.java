package fileAccess;

import file_reader.GameFileReaderInterface;

public interface GameFileAccessInterface<Entity> {
    public void save(Entity entity);
    public void entityDies();
    public GameFileReaderInterface getFileReader();
    public GameFileWriter_Interface getFileWriter();
}

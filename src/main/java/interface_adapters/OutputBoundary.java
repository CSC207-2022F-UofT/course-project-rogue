package interface_adapters;

public interface OutputBoundary {
    void updateText(String line1, String line2, String line3, String line4);
    void updateHp(int hp);
    void updateEssenceCnt(int cnt);
    void updateArtifact(int cnt);
    void updatePlayerlocation(int[] location);
    void updateWin();
    void updateDead();
    void updateMap(int[][] map);
}

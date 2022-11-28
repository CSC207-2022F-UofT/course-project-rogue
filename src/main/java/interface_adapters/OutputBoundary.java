package interface_adapters;

public interface OutputBoundary {
    public void update_Text(String line1, String line2, String line3, String line4);
    public void update_Hp(int hp);
    public void update_EssenceCnt(int cnt);
    public void update_Artifact(int cnt);
    public void update_Playerlocation(int[] location);
    public void update_Win();
    public void update_Dead();
    public void update_Map(int[][] map);
}

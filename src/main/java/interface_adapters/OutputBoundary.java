package interface_adapters;

public interface OutputBoundary {
    public void update_Text(String line1, String line2, String line3, String line4);
    public void update_Hp(int hp);
    public void update_EssenceCnt(int cnt);
    public void update_Artifact(String s);
    public void update_Playerlocation(int[] location);
    public void update_Win();

    public void update_GameOver();
    public void update_Map(String map);
}

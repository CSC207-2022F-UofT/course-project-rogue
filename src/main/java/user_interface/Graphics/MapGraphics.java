package user_interface.Graphics;

import java.awt.*;

public class MapGraphics {
    private int x, y, length;
    private Grid[][] events;

    public MapGraphics(int x, int y, int length, String[][] events){
        this.x = x;
        this.y = y;
        this.length = length;
        this.events = new Grid[events.length][events[0].length];
        int L = length / events[0].length;
        for(int i = 0; i < events.length; i++){
            for(int o = 0; o < events[i].length; o++){
                int s = x + o * L;
                int t = y + i * L;
                this.events[i][o] = new Grid(s, t, L, "pictures/wall.jpg");
            }
        }
    }

    /**
     * This method is called in a view model to be included as a drawing
     * @param g : graphics passed in to be drawn
     */
    public void draw(Graphics g){
        for(int i = 0; i < this.events.length; i++){
            for(int o = 0; o < this.events[i].length; o++){
                this.events[i][o].draw(g);
            }
        }
    }
}

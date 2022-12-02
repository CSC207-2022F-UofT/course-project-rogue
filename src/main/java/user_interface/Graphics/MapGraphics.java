package user_interface.Graphics;

import java.awt.*;

public class MapGraphics {
    private int x, y, length;
    private Grid[][] events;

    static int[] playerLocation = new int[]{-1,-1};

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
                this.events[i][o] = new Grid(s, t, L, eventHelper(events[i][o]));
            }
        }
    }

    /**
     * This method act as a function that maps the name of event to the corresponding image directory.
     * Notice some events does not have graphics to represent them.(Any other event name not being mapped
     * in this method is intentionally not shown on screen).
     * @param eventName : The name of Event in string
     * @return the directory that stores the picture representing this event.
     */
    private String eventHelper(String eventName){
        switch (eventName){
            case "WallEvent":
                return "pictures/wall.jpg";
            case "WinEvent":
                return "pictures/WinDoor.png";
            default:
                return "pictures/Blank.jpg";
        }
    }

    public MapGraphics(){
    }

    /**
     * Setting the new location of player.
     * @param location : the new location of player
     */
    public void setPlayerLocation(int[] location){
        MapGraphics.playerLocation[0] = location[0];
        MapGraphics.playerLocation[1] = location[1];
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

    /**
     * Mirror the state of another instance of MapGraphics instance
     * @param oldMap : the MapGraphics instance to copy from.
     */
    public void duplicate(MapGraphics oldMap){
        this.x = oldMap.x;
        this.y = oldMap.y;
        this.length = oldMap.length;
        this.events = new Grid[oldMap.events.length][oldMap.events[0].length];
        for(int i = 0; i < events.length; i++){
            for(int o = 0; o < events[i].length; o++){
                Grid g = new Grid();
                g.duplicate(oldMap.events[i][o]);
                this.events[i][o] = g;
            }
        }
    }
}

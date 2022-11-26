package user_interface.Graphics;

import java.awt.image.BufferedImage;

public class Grid {

    /** x,y : Coordinates of this grid
     *  width, height : size of this grid to be drawn
     */
    private int x, y, width, height;
    BufferedImage image;

    public Grid(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }



}

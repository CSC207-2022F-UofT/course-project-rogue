package user_interface.Graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Grid {

    /** x,y : Coordinates of this grid
     *  length : size of this grid to be drawn (length * length is a square.)
     */
    private int x, y, length;
    BufferedImage image;


    public Grid(int x, int y, int length, String dir){
        this.x = x;
        this.y = y;
        this.length = length;
        try {
            this.image = ImageIO.read(new File(dir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  This method is called when a grid is needed to be represented on the map visual.
     * @param g : the graphics passed in to be drawn.
     */
    public void draw(Graphics g){
        g.drawImage(this.image, this.x, this.y, this.length, this.length, null);
    }



}

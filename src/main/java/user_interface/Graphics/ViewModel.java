package user_interface.Graphics;

import usecase_playeractions.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewModel {

    private int hp;
    private int af;
    private int es;

    private String text1 = "";
    private String text2 = "";
    private String text3 = "";
    private String text4 = "";

    //length should always be 650;
    private MapGraphics map = null;

    private Dimension size;

    public void duplicate(ViewModel oldModel){
        this.text1 = oldModel.text1;
        this.text2 = oldModel.text2;
        this.text3 = oldModel.text3;
        this.text4 = oldModel.text4;
        this.hp = oldModel.hp;
        this.es = oldModel.es;
        this.map = new MapGraphics();
        this.map.duplicate(oldModel.map);
    }

    /**
     * @return True if instance variable map is not initialized.
     */
    private boolean checkReady(){
        return this.map != null;
    }

    public void draw(Graphics g, Dimension size, JPanel gameFrame){
        this.size = size;
        try {
            BufferedImage img = ImageIO.read(new File("pictures/b9db1d7d93c1709.png"));
            g.drawImage(img,0,size.height-300,size.width,300,gameFrame);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.setColor(new Color(0x69030303, true));
        g.fillRect(0,0,size.width-600,size.height-300);
        g.setColor(new Color(0xFF090909, true));
        g.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,30));
        g.drawString("HP:      "+hp,30,120);
        g.drawString("Artifact:      "+af,30,240);
        g.drawString("Essence:      "+es,30,360);

        g.setColor(new Color(0xA6287886, true));
        g.fillRect(0,size.height-300,size.width,300);
        g.setColor(new Color(0xFF090909, true));
        g.drawString(text1 ,100,size.height-220);
        g.drawString(text2 ,100,size.height-170);
        g.drawString(text3 ,100,size.height-120);
        g.drawString(text4 ,100,size.height-70);
        if (this.checkReady()) {
            this.map.draw(g);
        }
    }

    public void setPlayerLocation(int[] l){
        this.map.setPlayerLocation(l);
    }
    public void setMap(String[][] map){
        this.map = new MapGraphics( 877, 0, 650, map);
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAf(int af) {
        this.af = af;
    }

    public void setEs(int es) {
        this.es = es;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

}

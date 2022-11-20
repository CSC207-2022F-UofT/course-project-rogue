package user_interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.text.View;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel{
    boolean start = false;
    private JButton startbutton = new JButton("START GAME");
    private JButton quitbutton = new JButton("QUIT");
    int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;
    int hp = 100;
    int af = 99;
    int es = 66;
    String text1 = "Welcome the great adventurer to this evil world.";
    String text2 = "Welcome the great adventurer to this evil world.";
    String text3 = "Welcome the great adventurer to this evil world.";
    String text4 = "Welcome the great adventurer to this evil world.";


    public Menu() {
        JPanel panel = new JPanel();
        panel.setLayout(null);


        startbutton.setFocusable(true);
        quitbutton.setFocusable(true);

        startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = !start;
                startbutton.setVisible(false);
                quitbutton.setVisible(false);
                repaint();
            }
        });
        quitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                System.out.println(keycode);
                if (keycode == 32){
                    hp-=10;
                    text1 = text1 + "w";
                    repaint();
                }
                if (keycode == 27){
                    int d = JOptionPane.showConfirmDialog(null,"Back to Menu?","Menu",JOptionPane.CLOSED_OPTION);
                    if (d == JOptionPane.OK_OPTION){
                        start = !start;
                        startbutton.setVisible(true);
                        quitbutton.setVisible(true);
                        repaint();
                    }
                }
            }
        });


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size=this.getParent().getSize();

        if (start == false){
//            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("C:\\Users\\ZHY\\Desktop\\.idea\\course-project-rogue\\src\\main\\java\\user_interface\\1.jpg"));
            try {
                BufferedImage img = ImageIO.read(new File("pictures/b9db1d7d93c1709.png"));
                g.drawImage(img,0,0,size.width,size.height,this);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            g.setColor(new Color(0xF10707));
            g.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,100));
            g.drawString("Welcome to Adventure !",150,200);

            startbutton.setBounds(500,350,300,100);
            startbutton.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,40));
            add(startbutton);
            quitbutton.setBounds(500,600,300,100);
            quitbutton.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,40));
            add(quitbutton);
        }

        if (start != false){
            try {
                BufferedImage img = ImageIO.read(new File("pictures/b9db1d7d93c1709.png"));
                g.drawImage(img,0,size.height-300,size.width,300,this);
                //g.drawImage(img,0,0,size.width-1000,size.height-300,this);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.setColor(new Color(0x698C8989, true));
            g.fillRect(0,0,size.width-1000,size.height-300);
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
        }

    }


}


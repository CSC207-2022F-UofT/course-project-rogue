package user_interface;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends JPanel{
    boolean start = false;
    private JButton startbutton = new JButton("START GAME");
    private JButton quitbutton = new JButton("QUIT");
    int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;


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


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (start == false){
            Dimension size=this.getParent().getSize();
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/user_interface/1.jpg"));
            g.drawImage(image,0,0,size.width,size.height,this);

            g.setColor(new Color(0xF8F6F6));
            g.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,100));
            g.drawString("Welcome to Adventure !",150,200);

            startbutton.setBounds(500,350,300,100);
            startbutton.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,40));
            add(startbutton);
            quitbutton.setBounds(500,600,300,100);
            quitbutton.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,40));
            add(quitbutton);
        }

    }


}





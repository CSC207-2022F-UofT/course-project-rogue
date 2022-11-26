package user_interface.Graphics;

import user_interface.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JPanel{
    boolean start = false;
    private JButton startbutton = new JButton("START GAME");
    private JButton quitbutton = new JButton("QUIT");
    int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;

    private ViewModel viewModel;

    public GameFrame() {
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
        this.viewModel = new ViewModel();

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
            this.viewModel.draw(g, size, this);
        }

    }
    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}


package user_interface.graphics;

import user_interface.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JPanel{
    boolean start = false;
    private final JButton startbutton = new JButton("START GAME");
    private final JButton quitbutton = new JButton("QUIT");

    private final View view;
    private ViewModel viewModel;

    public GameFrame(View v) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        view = v;
        startbutton.setFocusable(true);
        quitbutton.setFocusable(true);

        startbutton.addActionListener(e -> {
            view.startButtonClicked();
            startbutton.setVisible(false);
            quitbutton.setVisible(false);
            repaint();
        });
        quitbutton.addActionListener(e -> System.exit(0));
        this.setFocusable(true);
        this.viewModel = new ViewModel();
    }

    public void addListener(View view){
        this.addKeyListener(view);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size=this.getParent().getSize();

        if (!start){
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

        if (start){
            this.viewModel.draw(g, size, this);
        }

    }
    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
        repaint();
    }
    public void goToMenu(){
        startbutton.setVisible(true);
        quitbutton.setVisible(true);
        MapGraphics.playerLocation[0] = -1;
        MapGraphics.playerLocation[1] = -1;
        this.start = false;
        repaint();
    }

    public void setStart(boolean s){
        this.start = s;
    }
}


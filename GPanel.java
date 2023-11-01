package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GPanel extends JPanel implements ActionListener {


    int x =0;
    int enemy_x,enemy_y=0;
    int xVel =2;
    int yVel =2;
    Image background_img;
    Image rat_img;
    Image skull_img;
    Image zombie_img;
    Timer timer;
    GPanel(int Frame_x, int Frame_y) {
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        rat_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
        skull_img = new ImageIcon("src\\gra\\graphics\\skull.png").getImage();
        zombie_img = new ImageIcon("src\\gra\\graphics\\zombie.png").getImage();
        timer = new Timer(10,this);
        timer.start();
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.drawImage(background_img, 0, 0, this.getWidth(), this.getHeight(), null);
        gr2D.drawImage(rat_img, enemy_x, enemy_y, null);
    }

    private void Loop(Timer timer){
        timer.stop();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Colision()){
                    x+=1;
                    System.out.println(x);
                }
            }
        });
        if(enemy_x>this.getWidth() - rat_img.getWidth(null) || enemy_x< 0){
            xVel *= -1;
        }
        if(enemy_y>this.getHeight() - rat_img.getHeight(null)|| enemy_y<0){
            yVel *= -1;
        }
        enemy_x += xVel;
        enemy_y += yVel;
        timer.start();
        repaint();
    }
    private boolean Colision(){
        int cur_x = MouseInfo.getPointerInfo().getLocation().x;
        int cur_y = MouseInfo.getPointerInfo().getLocation().y;
        boolean hit = false;
        Rectangle hitbox= new Rectangle(enemy_x,enemy_y,rat_img.getWidth(null),rat_img.getHeight(null));
        if(hitbox.contains(cur_x,cur_y)){
            hit = true;
        }
        return hit;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Loop(timer);
    }
}
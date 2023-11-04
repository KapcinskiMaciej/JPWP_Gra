package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.exit;

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
    int time=0;
    GPanel(int Frame_x, int Frame_y) {
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        rat_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
        skull_img = new ImageIcon("src\\gra\\graphics\\skull.png").getImage();
        zombie_img = new ImageIcon("src\\gra\\graphics\\zombie.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cur_x = e.getX();
                int cur_y = e.getY();
                if(Colision(cur_x,cur_y)){
                    x+=1;
                    System.out.println("trafienie " + x);
                }
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.drawImage(background_img, 0, 0, this.getWidth(), this.getHeight(), null);
        gr2D.drawImage(rat_img, enemy_x, enemy_y, null);
    }
    private void Loop(){
        if(enemy_x>this.getWidth() - rat_img.getWidth(null) || enemy_x< 0){
            xVel *= -1;
        }
        if(enemy_y>this.getHeight() - rat_img.getHeight(null)|| enemy_y<0){
            yVel *= -1;
        }
        enemy_x += xVel;
        enemy_y += yVel;
        repaint();
    }
    private boolean Colision(int cur_x, int cur_y){
        boolean hit = false;
        Rectangle hitbox= new Rectangle(enemy_x,enemy_y,rat_img.getWidth(null),rat_img.getHeight(null));
        if(hitbox.contains(cur_x,cur_y)){
            hit = true;
        }
        return hit;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        time+=1;
        Loop();
        //if(time>1000){
       //     exit(1);
       // }
    }
}
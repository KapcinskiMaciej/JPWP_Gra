package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.exit;

public class GPanel extends JPanel implements ActionListener {



    int enemy_x,enemy_y=0;
    int xVel =20;
    int yVel =20;
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
    boolean Colision(int cur_x, int cur_y){
        boolean hit = false;
        if(cur_x >= enemy_x && cur_x <= enemy_x+rat_img.getWidth(null) && cur_y >= enemy_y &&
                cur_y <= enemy_y+rat_img.getHeight(null)){
            hit = true;
        }
        return hit;
    }

    /*private void Wordcheck(){
        String word;
        GLoop gloop = new GLoop(;
        if(word == gloop.){

        }
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        time+=1;
        Loop();
        //if(time>1000){
        //     exit(1);
        // }
    }
}
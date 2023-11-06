package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;



public class GPanel extends JPanel implements ActionListener {



    int enemy_x,enemy_y=0;
    int xVel =3;
    int yVel =5;
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
        boolean hit = cur_x >= enemy_x && cur_x <= enemy_x + rat_img.getWidth(null) && cur_y >= enemy_y &&
                cur_y <= enemy_y + rat_img.getHeight(null);
        return hit;
    }

    public void Wordset(TextField txtup){
        GLoop gloop = new GLoop();
        Random r = new Random();
        ArrayList<String> keys = new ArrayList<>(gloop.words.keySet());
        String outpword = gloop.words.get(keys.get(r.nextInt(keys.size())));
        //txtup.setText(gloop.words.get(outpword));
        txtup.setText(outpword);
    }
    public boolean Wordcheck(TextField txtdown, TextField txtup){
        boolean contains = false;
        String inpword = txtdown.getText();
        GLoop gloop = new GLoop();
        if(Objects.equals(gloop.words.get(inpword), txtup.getText())){
            contains=true;
        }
        return contains;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Loop();
    }
}
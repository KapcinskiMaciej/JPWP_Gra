package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class GPanel extends JPanel implements ActionListener {
    int enemy_x,enemy_y=0;
    int xVel=5;
    int yVel=3;
    int dmg;
    Image background_img,rat_img,skull_img,zombie_img,curimg;
    Timer timer;
    int gamestatus = 1;
    int level = 1;
    GPanel(int Frame_x, int Frame_y) {
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        rat_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
        skull_img = new ImageIcon("src\\gra\\graphics\\skull.png").getImage();
        zombie_img = new ImageIcon("src\\gra\\graphics\\zombie.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        Level(level);
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.drawImage(background_img, 0, 0, this.getWidth(), this.getHeight(), null);
        gr2D.drawImage(Images(curimg, level), enemy_x, enemy_y, null);
    }
    private void Loop(int status){
        if(status == 1) {

            if (enemy_x > this.getWidth() - Images(curimg, level).getWidth(null) || enemy_x < 0) {
                xVel *= -1;
            }
            if (enemy_y > this.getHeight() - Images(curimg, level).getHeight(null) || enemy_y < 0) {
                yVel *= -1;
            }
            enemy_x += xVel;
            enemy_y += yVel;
            repaint();
        }
    }
    boolean Colision(int cur_x, int cur_y) {
        return cur_x >= enemy_x && cur_x <= enemy_x + Images(curimg, level).getWidth(null) && cur_y >= enemy_y &&
                cur_y <= enemy_y + Images(curimg, level).getHeight(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Loop(gamestatus);
    }
    void WhatNext(JProgressBar hp){
        gamestatus = 0;
        int answer = JOptionPane.showConfirmDialog(null,
             "Pokonano przeciwnika! Chcesz kontynuować? (Gram dalej! - Yes, Chce zakończyć grę - No)",
             "GRATULACJE!!!",JOptionPane.YES_NO_OPTION);
        switch (answer) {
            case 0 -> {
                hp.setValue(100);
                System.out.println("Gramy dalej");
                level+=1;
                Level(level);
            }
            case 1 -> System.exit(0);
        }
    }
    Image Images(Image curimg, int level){
        switch(level){
            case 1, 3 -> {
                curimg = rat_img;
            }
            case 2 -> curimg = skull_img;
        }
        repaint();
        return curimg;
    }
    void Level(int level){
        switch(level){
            case 1 -> {
                dmg =50;
                enemy_y=0;
                enemy_x=0;
                xVel = 3;
                yVel = 5;
            }
            case 2 -> {
                dmg = 25;
                enemy_y=0;
                enemy_x=0;
                xVel = 6;
                yVel = 10;
            }
            case 3 -> {
                dmg = 20;
                enemy_y=0;
                enemy_x=0;
                xVel = 12;
                yVel = 20;
            }
        }
        gamestatus =1;
    }
}
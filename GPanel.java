package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GPanel extends JPanel implements ActionListener {
    Image background_img,curimg;
    Timer timer;
    GEnemy enemy = new GEnemy();
    GWords gwords = new GWords();
    GPanel(int Frame_x, int Frame_y) {
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        Level(gwords.level);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.drawImage(background_img, 0, 0, this.getWidth(), this.getHeight(), null);
        gr2D.drawImage(enemy.Images(curimg, this.gwords.level), enemy.x, enemy.y, null);
    }
    private void Loop(int status){
        if(status == 1) {

            if (enemy.x > this.getWidth() - enemy.Images(curimg, gwords.level).getWidth(null) || enemy.x < 0) {
                enemy.xVel *= -1;
            }
            if (enemy.y > this.getHeight() - enemy.Images(curimg, gwords.level).getHeight(null) || enemy.y < 0) {
                enemy.yVel *= -1;
            }
            enemy.x += enemy.xVel;
            enemy.y += enemy.yVel;
            repaint();
        }
    }
    boolean Colision(int cur_x, int cur_y) {
        return cur_x >= enemy.x && cur_x <= enemy.x + enemy.Images(curimg, gwords.level).getWidth(null) &&
                cur_y >= enemy.y && cur_y <= enemy.y + enemy.Images(curimg, gwords.level).getHeight(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Loop(gwords.gamestatus);
    }
    void WhatNext(){
        gwords.gamestatus = 0;
        if(gwords.level == 3){
            JOptionPane.showConfirmDialog(null,"GRATULACJE!!! UDAŁO CI SIE UKOŃCZYĆ GRĘ!!!",
                    "KONIEC",JOptionPane.DEFAULT_OPTION);
            System.exit(0);
        }
        int answer = JOptionPane.showConfirmDialog(null,
             "Pokonano przeciwnika! Chcesz kontynuować? (Gram dalej! - Yes, Chce zakończyć grę - No)",
             "GRATULACJE!!!",JOptionPane.YES_NO_OPTION);

        switch (answer) {
            case 0 -> {
                gwords.level+=1;
                Level(gwords.level);
            }
            case 1 -> System.exit(0);
        }
    }
    void Level(int level){
        switch(level){
            case 1 -> {
                gwords.lifes = 3;
                enemy.dmg =50;
                enemy.y=0;
                enemy.x=0;
                enemy.xVel = 6;
                enemy.yVel = 5;
            }
            case 2 -> {
                gwords.lifes = 3;
                enemy.dmg = 25;
                enemy.y=0;
                enemy.x=0;
                enemy.xVel = 10;
                enemy.yVel = 11;
            }
            case 3 -> {
                gwords.lifes = 3;
                enemy.dmg = 20;
                enemy.y=0;
                enemy.x=0;
                enemy.xVel = 15;
                enemy.yVel = 16;
            }
        }
        gwords.gamestatus =1;
    }
}
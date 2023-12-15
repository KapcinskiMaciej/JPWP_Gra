package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GPanel extends JPanel implements ActionListener {
    Image background_img,curimg;
    Timer timer;
    GEnemy enemy = new GEnemy();
    GLoop gloop = new GLoop();
    GPanel(int Frame_x, int Frame_y) {
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        timer = new Timer(10,this);
        timer.start();
        Level(gloop.level);
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.drawImage(background_img, 0, 0, this.getWidth(), this.getHeight(), null);
        gr2D.drawImage(enemy.Images(curimg, gloop.level), enemy.x, enemy.y, null);
    }
    private void Loop(int status){
        if(status == 1) {

            if (enemy.x > this.getWidth() - enemy.Images(curimg, gloop.level).getWidth(null) || enemy.x < 0) {
                enemy.xVel *= -1;
            }
            if (enemy.y > this.getHeight() - enemy.Images(curimg, gloop.level).getHeight(null) || enemy.y < 0) {
                enemy.yVel *= -1;
            }
            enemy.x += enemy.xVel;
            enemy.y += enemy.yVel;
            repaint();
        }
    }
    boolean Colision(int cur_x, int cur_y) {
        return cur_x >= enemy.x && cur_x <= enemy.x + enemy.Images(curimg, gloop.level).getWidth(null) &&
                cur_y >= enemy.y && cur_y <= enemy.y + enemy.Images(curimg, gloop.level).getHeight(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Loop(gloop.gamestatus);

    }
    void WhatNext(){
        gloop.gamestatus = 0;
        if(gloop.level == 3){
            JOptionPane.showConfirmDialog(null,"GRATULACJE!!! UDAŁO CI SIE UKOŃCZYĆ GRĘ!!!",
                    "KONIEC",JOptionPane.DEFAULT_OPTION);
            System.exit(0);
        }
        int answer = JOptionPane.showConfirmDialog(null,
             "Pokonano przeciwnika! Chcesz kontynuować? (Gram dalej! - Yes, Chce zakończyć grę - No)",
             "GRATULACJE!!!",JOptionPane.YES_NO_OPTION);

        switch (answer) {
            case 0 -> {
                System.out.println("Gramy dalej");
                gloop.level+=1;
                Level(gloop.level);
            }
            case 1 -> System.exit(0);
        }
    }
    void Level(int level){
        switch(level){
            case 1 -> {

                enemy.dmg =50;
                enemy.y=0;
                enemy.x=0;
                enemy.xVel = 6;
                enemy.yVel = 5;
            }
            case 2 -> {

                enemy.dmg = 25;
                enemy.y=0;
                enemy.x=0;
                enemy.xVel = 10;
                enemy.yVel = 11;
            }
            case 3 -> {

                enemy.dmg = 20;
                enemy.y=0;
                enemy.x=0;
                enemy.xVel = 15;
                enemy.yVel = 16;
            }
        }
        gloop.gamestatus =1;
    }
}
package gra;

import javax.swing.*;
import java.awt.*;

public class GEnemy {
    int x,y,xVel, yVel=0;
    int dmg;
    Image rat_img,skull_img,zombie_img;

    GEnemy(){
        rat_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
        skull_img = new ImageIcon("src\\gra\\graphics\\skull.png").getImage();
        zombie_img = new ImageIcon("src\\gra\\graphics\\zombie.png").getImage();

    }
    Image Images(Image curimg, int level){
        switch(level){
            case 1 -> curimg = rat_img;
            case 2 -> curimg = skull_img;
            case 3 -> curimg = zombie_img;
        }
        return curimg;
    }
}

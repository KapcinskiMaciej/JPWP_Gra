package gra;

import javax.swing.*;
import java.awt.*;
/*
* Klasa definiująca bezpośrednio przeciwników z którymi
* gracz zmaga się w trakcie gry. Przeciwnik definiowany jest przez:
* wytrzymałość na obrażenia, prędkość poruszania, swoje współżędne oraz
* wygląd(zdjęcie).
* */
public class GEnemy {
    int x,y,xVel, yVel=0;
    int dmg;
    Image rat_img,skull_img,alien_img;

    GEnemy(){
        //załadowanie zewnętrznych plików graficznych (PNG)
        rat_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
        skull_img = new ImageIcon("src\\gra\\graphics\\skull.png").getImage();
        alien_img = new ImageIcon("src\\gra\\graphics\\alien.png").getImage();
    }
    //metoda definiująca "przebranie" przeciwnika w zależności od poziomu
    //na jakim jest gracz
    Image Images(Image curimg, int level){
        switch(level){
            case 1 -> curimg = rat_img;
            case 2 -> curimg = skull_img;
            case 3 -> curimg = alien_img;
        }
        return curimg;
    }
}

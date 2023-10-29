package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GImages extends JComponent {
    Image background_img;
    Image rat_img;
    Image skull_img;
    Image zombie_img;
    int enemy_x = 423;
    int enemy_y = 310;

    GImages(){
        addMouseListener(listener);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        rat_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
        skull_img = new ImageIcon("src\\gra\\graphics\\skull.png").getImage();
        zombie_img = new ImageIcon("src\\gra\\graphics\\zombie.png").getImage();
    }
    public MouseListener listener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            System.out.println("cos");
        }
    };

}



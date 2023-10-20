package gra;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {

    Image background_img;
    Image enemy_img;
    GPanel (int Frame_x, int Frame_y){
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\gra\\graphics\\background.png").getImage();
        enemy_img = new ImageIcon("src\\gra\\graphics\\rat.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D gr2D=(Graphics2D)g;
        gr2D.drawImage(background_img, 0,0,this.getWidth(),this.getHeight(),null);
        gr2D.drawImage(enemy_img,423,310,null);
    }
}

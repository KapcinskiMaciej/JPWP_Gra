package Gra;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {

    Image background_img;
    GPanel (int Frame_x, int Frame_y){
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("src\\Gra\\background.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D gr2D=(Graphics2D)g;
        gr2D.drawImage(background_img, 0,0,null);
    }
}

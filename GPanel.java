package Gra;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {

    Image background_img;
    GPanel (int Frame_x, int Frame_y){
        this.setSize(Frame_x, Frame_y);
        background_img = new ImageIcon("background.png").getImage();
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        //Graphics2D gr2D=(Graphics2D) g;
        //gr2D.drawRect(5,5,500,500);
        g.drawImage(background_img, 0,0,null);
    }
}

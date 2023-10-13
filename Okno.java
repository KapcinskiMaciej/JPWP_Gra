package Gra;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    public int f_x=1280;
    public int f_y=720;
    GPanel panel;
    JLabel
    public Okno(String nazwa_okna){
        super(nazwa_okna);


        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    private void Interface(int f_x, int f_y){
        panel = new GPanel(f_x, f_y);
        add(panel);
    }
}

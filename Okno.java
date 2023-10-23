package gra;

import javax.swing.*;
import java.awt.*;
public class Okno extends JFrame{
    int f_x=1280;
    int f_y=720;
    public Okno(String nazwa_okna){
        super(nazwa_okna);

        GPanel panel = new GPanel(f_x, f_y);
        add(panel, BorderLayout.CENTER);
        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}

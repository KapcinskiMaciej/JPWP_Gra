package Gra;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    public int rozmiar_x=1280;
    public int rozmiar_y=720;
    GPanel panel;
    public Okno(String nazwa_okna){
        super(nazwa_okna);
        panel = new GPanel(rozmiar_x, rozmiar_y);

        this.setSize(rozmiar_x,rozmiar_y);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }
}

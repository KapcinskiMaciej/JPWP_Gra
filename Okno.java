import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    public int rozmiar_x=1280;
    public int rozmiar_y=720;
    JPanel p1;

    public Okno(String nazwa_okna){
        super(nazwa_okna);
        setSize(rozmiar_x, rozmiar_y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

    }
}

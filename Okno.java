package gra;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    public int f_x=1280;
    public int f_y=720;

    public Okno(String nazwa_okna){
        super(nazwa_okna);

        Interface(f_x,f_y);
        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


    }

    private void Interface(int f_x, int f_y){
        setLayout(new BorderLayout());
        GPanel panel = new GPanel(f_x, f_y);
        JLabel label = new JLabel();
        TextField txt = new TextField();
        Font myfont = new Font("Open Sans",Font.BOLD,20);
        txt.setFont(myfont);
        Button btnstart, btncheck;
        btnstart = new Button("START");
        btncheck = new Button("CHECK");

        label.setBackground(Color.blue);
        label.setLayout(new GridLayout(1,3));
        label.add(btnstart);
        label.add(txt);
        label.add(btncheck);
        label.setPreferredSize(new Dimension(f_x,40));
        add(panel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

    }
}

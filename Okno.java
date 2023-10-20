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
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        GPanel panel = new GPanel(f_x, f_y);
        JLabel labeldown = new JLabel();
        JLabel labelup = new JLabel();
        JTextField txtdown = new JTextField("Tutaj wpisz slowo",1);
        TextArea txtup = new TextArea("Wyswietlane slowo");
        JProgressBar hp = new JProgressBar(0,100);
        Font myfont = new Font("Open Sans",Font.BOLD,20);
        txtup.setEditable(false);
        txtdown.setFont(myfont);
        hp.setValue(100);
        Button btnstart, btncheck;
        btnstart = new Button("START");
        btncheck = new Button("CHECK");
        // dolny label
        labeldown.setBackground(Color.black);
        labeldown.setLayout(new GridLayout(1,3));
        labeldown.add(btnstart);
        labeldown.add(txtdown);
        labeldown.add(btncheck);
        labeldown.setPreferredSize(new Dimension(f_x,40));
        //gorny label
        labelup.setBackground(Color.black);
        labelup.setLayout(new GridLayout(1,2));
        labelup.setPreferredSize(new Dimension(f_x,40));
        labelup.add(txtup);
        labelup.add(hp);

        add(panel, BorderLayout.CENTER);
        add(labeldown, BorderLayout.SOUTH);
        add(labelup, BorderLayout.NORTH);
    }
}

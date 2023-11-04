package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Okno extends JFrame{
    int f_x=1280;
    int f_y=720;
    int hpval = 50;
    Button btnstart;
    JProgressBar hp;
    int x =0;
    public Okno(String nazwa_okna){
        super(nazwa_okna);

        Interface(f_x);
        GPanel panel = new GPanel(f_x, f_y);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cur_x = e.getX();
                int cur_y = e.getY();
                if(panel.Colision(cur_x,cur_y)){
                    x+=1;
                    System.out.println("trafienie " + x);
                    hpval-=10;
                }
            }
        });
        add(panel, BorderLayout.CENTER);

        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void Interface(int f_x) {
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        btnstart = new Button("RESTART");

        JTextField txtdown = new JTextField("Tutaj wpisz slowo", 1);
        JTextField txtup = new JTextField("Wyswietlane slowo");
        hp = new JProgressBar(0, 100);
        Font myfont = new Font("Open Sans", Font.BOLD, 20);

        txtdown.setFont(myfont);
        txtup.setEditable(false);
        txtup.setFont(myfont);
        hp.setValue(hpval);

        Labels(btnstart, txtdown, txtup, hp, f_x);
    }
    public void Labels(Button btnstart, JTextField txtdown, JTextField txtup, JProgressBar hp, int f_x) {
        JLabel labeldown = new JLabel();
        JLabel labelup = new JLabel();

        //donly label
        labeldown.setBackground(Color.black);
        labeldown.setLayout(new GridLayout(1, 3));
        labeldown.add(btnstart);
        labeldown.add(txtdown);
        labeldown.setPreferredSize(new Dimension(f_x, 40));
        //gorny label
        labelup.setBackground(Color.black);
        labelup.setLayout(new GridLayout(1, 2));
        labelup.setPreferredSize(new Dimension(f_x, 40));
        labelup.add(txtup);
        labelup.add(hp);

        add(labeldown, BorderLayout.SOUTH);
        add(labelup, BorderLayout.NORTH);
    }

    void Health(){}
}

package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Okno extends JFrame{
    int f_x=1280;
    int f_y=720;
    JProgressBar hp;
    int hpval=100;
    public Okno(String nazwa_okna){
        super(nazwa_okna);
        GPanel panel = new GPanel(f_x, f_y);
        TextField txtup = new TextField();
        TextField txtdown = new TextField("Tutaj wpisz slowo", 1);
        Interface(f_x,hpval,txtup,txtdown);
        add(panel, BorderLayout.CENTER);
        panel.Wordset(txtup);
        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cur_x = e.getX();
                int cur_y = e.getY();
                Hit(cur_x,cur_y,panel,txtdown,txtup);
            }
        });
    }

    private void Interface(int f_x, int hpval,TextField txtup,TextField txtdown) {
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        Button btnstart = new Button("RESTART");
        Font myfont = new Font("Open Sans", Font.BOLD, 20);
        hp = new JProgressBar(0, 100);
        hp.setStringPainted(true);
        hp.setForeground(Color.red);
        hp.setBackground(Color.lightGray);
        hp.setValue(hpval);
        hp.setFont(myfont);
        txtdown.setFont(myfont);
        txtup.setEditable(false);
        txtup.setFont(myfont);
        Labels(btnstart, txtdown, txtup, hp, f_x);
    }
    private void Labels(Button btnstart, TextField txtdown, TextField txtup, JProgressBar hp, int f_x) {
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

    private void Hit(int cur_x,int cur_y, GPanel panel, TextField txtdown, TextField txtup){
        if(panel.Colision(cur_x,cur_y) && panel.Wordcheck(txtdown,txtup)){
            hpval-=20;
            System.out.println(hpval);
            hp.setValue(hpval);
            Dead(hpval);
            panel.Wordset(txtup);
        }
    }
    private void Dead(int hpval){
        if(hpval<=0){
            System.out.println("koniec");
        }
    }

}

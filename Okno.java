package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Okno extends JFrame{
    int f_x=1280;
    int f_y=720;
    JProgressBar hp;
    public Okno(String nazwa_okna){
        super(nazwa_okna);
        GPanel panel = new GPanel(f_x, f_y);
        GLoop gloop = new GLoop();
        TextField txtup = new TextField();
        TextField txtdown = new TextField("Tutaj wpisz slowo", 1);
        Interface(f_x,txtup,txtdown);
        add(panel, BorderLayout.CENTER);
        gloop.Wordset(txtup);
        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cur_x = e.getX();
                int cur_y = e.getY();
                Hit(cur_x,cur_y,panel,txtdown,txtup, gloop);
            }
        });
    }

    private void Interface(int f_x,TextField txtup,TextField txtdown) {
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        Button btnstart = new Button("RESTART");
        Font myfont = new Font("Open Sans", Font.BOLD, 20);
        hp = new JProgressBar(0, 100);
        hp.setStringPainted(true);
        hp.setForeground(Color.red);
        hp.setBackground(Color.lightGray);
        hp.setValue(100);
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

    private void Hit(int cur_x,int cur_y, GPanel panel, TextField txtdown, TextField txtup, GLoop gloop){
        if(panel.Colision(cur_x,cur_y) && gloop.Wordcheck(txtdown,txtup)){
            hp.setValue(hp.getValue()-panel.dmg);
            Dead(panel, hp);
            gloop.Wordset(txtup);
        }
    }
    private void Dead(GPanel panel, JProgressBar hp){
        if(hp.getValue()<=0){
            panel.WhatNext();
            hp.setValue(100);
        }
    }
}
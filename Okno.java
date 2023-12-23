package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Okno extends JFrame implements ActionListener{
    JMenuItem exit = new JMenuItem("EXIT");
    Okno(String nazwa_okna){
        super(nazwa_okna);
        int f_x = 1280;
        int f_y=720;
        JProgressBar hp = new JProgressBar(0, 100);
        GPanel panel = new GPanel(f_x, f_y);
        GLoop gloop = new GLoop();
        TextField txtup = new TextField();
        TextField txtdown = new TextField("Tutaj wpisz slowo", 1);
        Interface(f_x,txtup,txtdown, hp, exit);
        add(panel, BorderLayout.CENTER);
        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        gloop.Wordset(txtup,gloop.curwords);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cur_x = e.getX();
                int cur_y = e.getY();
                Hit(cur_x,cur_y,panel,txtdown,txtup, gloop, hp);
            }
        });
    }

    private void Interface(int f_x,TextField txtup,TextField txtdown, JProgressBar hp, JMenuItem exit) {
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        Font myfont = new Font("Open Sans", Font.BOLD, 20);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        menu.setFont(myfont);
        menu.setPreferredSize(new Dimension(f_x/2, 40));
        menu.add(exit);
        exit.addActionListener(this);
        menuBar.add(menu);
        hp.setStringPainted(true);
        hp.setForeground(Color.red);
        hp.setBackground(Color.lightGray);
        hp.setValue(100);
        hp.setFont(myfont);
        txtdown.setFont(myfont);
        txtup.setEditable(false);
        txtup.setFont(myfont);
        Labels(menuBar, txtdown, txtup, hp, f_x);
    }
    private void Labels(JMenuBar menu, TextField txtdown, TextField txtup, JProgressBar hp, int f_x) {
        JLabel labeldown = new JLabel();
        JLabel labelup = new JLabel();

        //donly label
        labeldown.setBackground(Color.black);
        labeldown.setLayout(new GridLayout(1, 3));
        labeldown.add(menu);
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

    private void Hit(int cur_x,int cur_y, GPanel panel, TextField txtdown, TextField txtup, GLoop gloop, JProgressBar hp)
    {
        if(panel.Colision(cur_x,cur_y) && gloop.Wordcheck(txtdown,txtup,gloop.curwords)){
            hp.setValue(hp.getValue()-panel.enemy.dmg);
            Dead(panel, hp);
            gloop.Wordset(txtup, gloop.curwords);
        }
    }
    private void Dead(GPanel panel, JProgressBar hp){
        if(hp.getValue()<=0){
            panel.WhatNext();
            hp.setValue(100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(1);
        }
    }
}
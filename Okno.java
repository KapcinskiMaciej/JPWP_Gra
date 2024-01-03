package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
* Klasa okno, odpowiedzialna bezpośrednio za rozłożenie,
* oraz finalny wygląd okna oraz paneli znajdujących się wewnątrz.
* Zawiera również wszystkie funkcje chociażby za kolizję przeciwnika z kursorem myszy,
* wykrywanie pokonania przeciwnika czy korzystanie z funkcji menu.
*/
public class Okno extends JFrame{
    //pola definiujące rozmiar okna
    int f_x = 1280;
    int f_y=720;
    Okno(String nazwa_okna){
        super(nazwa_okna);
        //definicja składowych okna oraz konifguracja
        GPanel panel = new GPanel(f_x, f_y);
        TextField txtup = new TextField();
        TextField txtdown = new TextField("Tutaj wpisz slowo", 1);
        TextField txtcenter = new TextField();
        JMenuItem exit = new JMenuItem("EXIT");
        JMenuItem restart = new JMenuItem("RESTART");
        JProgressBar hp = new JProgressBar(0, 100);
        Interface(f_x,txtup,txtdown, hp, exit, restart, txtcenter);
        add(panel, BorderLayout.CENTER);
        this.setSize(f_x,f_y);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //ustawianie słowa początkowego
        panel.gwords.Wordset(txtup, panel.gwords.words, txtcenter);
        //klikanie myszką
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cur_x = e.getX();
                int cur_y = e.getY();
                Hit(cur_x,cur_y,panel,txtdown,txtup, panel.gwords, hp, txtcenter);
            }
        });
        //funkcja exit
        exit.addActionListener(e -> {
            if(e.getSource()==exit){
                System.exit(1);
            }
        });
        //funkcja reset
        restart.addActionListener(e -> {
            if(e.getSource()==restart){
                panel.gwords.level=1;
                panel.Level(panel.gwords.level);
                hp.setValue(100);
                repaint();
            }
        });

    }

    private void Interface(int f_x,TextField txtup,TextField txtdown, JProgressBar hp, JMenuItem exit,
                           JMenuItem restart, TextField txtcenter) {
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        Font myfont = new Font("Open Sans", Font.BOLD, 20);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        //ustawienie właściwości menu
        menu.setFont(myfont);
        menu.setPreferredSize(new Dimension(f_x/2, 40));
        menu.add(exit);
        menu.add(restart);
        menuBar.add(menu);
        //ustawienie właściwości paska życia
        hp.setStringPainted(true);
        hp.setForeground(Color.red);
        hp.setBackground(Color.lightGray);
        hp.setValue(100);
        hp.setFont(myfont);
        //ustawienie właściwości pól tekstowych
        txtdown.setFont(myfont);
        txtup.setEditable(false);
        txtup.setFont(myfont);
        txtcenter.setEditable(false);
        txtcenter.setFont(myfont);
        // wywołanie funkcji odpowiedzialnej za konfiguracje składowych interfejsu
        Labels(menuBar, txtdown, txtup, hp, f_x, txtcenter);
    }
    private void Labels(JMenuBar menu, TextField txtdown, TextField txtup, JProgressBar hp, int f_x,
                        TextField txtcenter) {
        JLabel labeldown = new JLabel();
        JLabel labelup = new JLabel();

        //dolny label
        labeldown.setBackground(Color.black);
        labeldown.setLayout(new GridLayout(1, 3));
        labeldown.add(menu);
        labeldown.add(txtdown);
        labeldown.setPreferredSize(new Dimension(f_x, 40));
        //górny label
        labelup.setBackground(Color.black);
        labelup.setLayout(new GridLayout(1, 3));
        labelup.setPreferredSize(new Dimension(f_x, 40));
        labelup.add(txtup);
        labelup.add(txtcenter);
        labelup.add(hp);
        //dodawanie labeli
        add(labeldown, BorderLayout.SOUTH);
        add(labelup, BorderLayout.NORTH);
    }
    private void Hit(int cur_x, int cur_y, GPanel panel, TextField txtdown, TextField txtup
            , GWords gwords, JProgressBar hp, TextField txtcenter)
    {
        //wykrywanie kolizji
        if(panel.Colision(cur_x,cur_y) && gwords.Wordcheck(txtdown,txtup,gwords.words)){
            hp.setValue(hp.getValue()-panel.enemy.dmg);
            Dead(panel, hp);
            gwords.Wordset(txtup, gwords.words, txtcenter);
        }
        //warunek nie trafienia lub/i wpisania niepoprawnego słowa
        else{
            panel.gwords.lifes-=1;
            Dead(panel, hp);
            panel.gwords.Wordset(txtup,panel.gwords.words, txtcenter);
        }
    }
    private void Dead(GPanel panel, JProgressBar hp){
        //warunek na pokonanie przeciwnika
        if(hp.getValue()<=0){
            panel.WhatNext();
            hp.setValue(100);
        }
        //warunek na utratę szans przez gracza
        if(panel.gwords.lifes<=0){
            panel.gwords.gamestatus = 0;
            JOptionPane.showConfirmDialog(null,"Przegrałeś, uzyskano zbyt dużą liczbę " +
                            "niepoprawnych trafień/słów. Zrestartuj grę lub wyjdź (MENU)",
                    "KONIEC",JOptionPane.DEFAULT_OPTION);
            //System.exit(0);
        }
    }
}
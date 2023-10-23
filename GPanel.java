package gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GPanel extends JPanel{
    int x = 100;
    Button btnstart, btncheck;
    JProgressBar hp;
    Image background_img;
    Image rat_img;
    Image skull_img;
    Image zombie_img;


    GPanel (int Frame_x, int Frame_y){
        this.setSize(Frame_x, Frame_y);
        Interface(Frame_x,Frame_y);

    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D gr2D=(Graphics2D)g;
        gr2D.drawImage(background_img, 0,0,this.getWidth(),this.getHeight(),null);
        gr2D.drawImage(rat_img,423,310,null);
    }
    private void Interface(int f_x, int f_y){
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        btnstart = new Button("START");
        btncheck = new Button("CHECK");
        JTextField txtdown = new JTextField("Tutaj wpisz slowo",1);
        TextArea txtup = new TextArea("Wyswietlane slowo");
        hp = new JProgressBar(0,100);
        Font myfont = new Font("Open Sans",Font.BOLD,20);

        txtdown.setFont(myfont);
        txtup.setEditable(false);
        hp.setValue(x);

        Labels(btnstart,btncheck,txtdown,txtup,hp,f_x);
    }
    private void Labels(Button btnstart, Button btncheck, JTextField txtdown, TextArea txtup, JProgressBar hp,int f_x){
        JLabel labeldown = new JLabel();
        JLabel labelup = new JLabel();
        //donly label
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

        add(labeldown, BorderLayout.SOUTH);
        add(labelup, BorderLayout.NORTH);
    }
}

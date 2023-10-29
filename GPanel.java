package gra;

import javax.swing.*;
import java.awt.*;
public class GPanel extends JPanel {
    int x = 100;
    Button btnstart;
    JProgressBar hp;
    GImages imgs = new GImages();
    GPanel(int Frame_x, int Frame_y) {
        this.setSize(Frame_x, Frame_y);
        Interface(Frame_x);
    }
    public void Interface(int f_x) {
        //definicje skladowych interfejsu
        setLayout(new BorderLayout());
        btnstart = new Button("START");

        JTextField txtdown = new JTextField("Tutaj wpisz slowo", 1);
        JTextField txtup = new JTextField("Wyswietlane slowo");
        hp = new JProgressBar(0, 100);
        Font myfont = new Font("Open Sans", Font.BOLD, 20);

        txtdown.setFont(myfont);
        txtup.setEditable(false);
        txtup.setFont(myfont);
        hp.setValue(x);

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
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gr2D = (Graphics2D) g;
        gr2D.drawImage(imgs.background_img, 0, 0, this.getWidth(), this.getHeight(), null);
        gr2D.drawImage(imgs.rat_img, imgs.enemy_x, imgs.enemy_y, null);
    }
}

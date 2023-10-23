package gra;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GLoop implements ActionListener {

    Button btncheck;


    GLoop(){
        btncheck.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btncheck){

        }
    }
}

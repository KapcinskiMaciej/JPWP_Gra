package gra;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class GLoop {
    HashMap<String,String> words = new HashMap<>();
    GLoop(){
        AddWord(words);
    }

    private void AddWord(HashMap<String,String> words){
        words.put("Flower","Kwiat");
        words.put("House","Dom");
        words.put("Car","Auto");
        words.put("Leg","Noga");
    }
    void Wordset(TextField txtup){
        Random r = new Random();
        ArrayList<String> keys = new ArrayList<>(this.words.keySet());
        String outpword = this.words.get(keys.get(r.nextInt(keys.size())));
        //txtup.setText(gloop.words.get(outpword));
        txtup.setText(outpword);
    }
    boolean Wordcheck(TextField txtdown, TextField txtup){
        boolean contains = false;
        String inpword = txtdown.getText();
        if(Objects.equals(this.words.get(inpword), txtup.getText())){
            contains=true;
        }
        return contains;
    }
}
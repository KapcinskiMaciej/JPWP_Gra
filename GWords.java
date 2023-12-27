package gra;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;



public class GWords {
    int level = 1;
    int lifes = 3;
    int gamestatus = 1;
    HashMap<String,String> words = new HashMap<>();
    GWords(){
        AddWord(words);
    }
    private void AddWord(HashMap<String,String> words){
        words.put("Flower","Kwiat");
        words.put("House","Dom");
        words.put("Car","Auto");
        words.put("Leg","Noga");
        words.put("Egg","Jajko");
        words.put("Bread","Chleb");
        words.put("Eye","Oko");
        words.put("Mouth","Usta");
        words.put("Ear","Ucho");
        words.put("Attic","Strych");
        words.put("Roof","Dach");
        words.put("Fireplace","Kominek");
        words.put("Washing Machine","Pralka");
        words.put("Capacitor","Kondensator");
        words.put("Resistor","Rezystor");

    }
    void Wordset(TextField txtup, HashMap<String,String> words, TextField txtcenter){

        Random r = new Random();
        ArrayList<String> keys = new ArrayList<>(words.keySet());
        String outpword = words.get(keys.get(r.nextInt(keys.size())));
        txtup.setText(outpword);
        txtcenter.setText("Pozostałe szanse: " + lifes);
    }
    boolean Wordcheck(TextField txtdown, TextField txtup, HashMap<String,String> words){
        boolean contains = false;
        String inpword = txtdown.getText();
        if(Objects.equals(words.get(inpword), txtup.getText())){
            contains=true;
        }
        return contains;
    }
}
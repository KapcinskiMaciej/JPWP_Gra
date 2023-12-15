package gra;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;



public class GLoop {
    int level = 1;
    int gamestatus = 1;


    HashMap<String,String> words = new HashMap<>();
    HashMap<String,String> words2 = new HashMap<>();
    HashMap<String,String> words3 = new HashMap<>();
    GLoop(){

        AddWord(words);
        AddWord2(words2);
        AddWord3(words3);
    }

    private void AddWord(HashMap<String,String> words){
        words.put("Flower","Kwiat");
        /*words.put("House","Dom");
        words.put("Car","Auto");
        words.put("Leg","Noga");
        words.put("Egg","Jajko");
        words.put("Bread","Chleb");
        words.put("Eye","Oko");
        words.put("Mouth","Usta");
        words.put("Ear","Ucho");*/
    }
    private void AddWord2(HashMap<String,String> words2){
        words2.put("Attic","Strych");
        /*words2.put("Roof","Dach");
        words2.put("Fireplace","Kominek");
        words2.put("Washing Machine","Pralka");*/
    }
    private void AddWord3(HashMap<String,String> words3){
        words3.put("Capacitor","Kondensator");
        /*words2.put("Roof","Dach");
        words2.put("Fireplace","Kominek");
        words2.put("Washing Machine","Pralka");*/
    }

    void Wordset(TextField txtup){
        Random r = new Random();
        ArrayList<String> keys = new ArrayList<>(words.keySet());
        String outpword = words.get(keys.get(r.nextInt(keys.size())));
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
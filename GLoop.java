package gra;

import java.util.HashMap;
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
}
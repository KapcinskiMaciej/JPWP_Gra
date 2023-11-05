package gra;

import java.util.HashMap;
public class GLoop {
    HashMap<String,String> words = new HashMap<>();
    GLoop(){
        AddWord(words);
    }

    private void AddWord(HashMap<String,String> words){
        words.put("Kwiat","Flower");
        words.put("Dom","House");
        words.put("Banan","Banana");
        words.put("Noga","Leg");
    }
}
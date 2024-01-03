package gra;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
/*
* Klasa definiująca zasób słowny z którego gracz jest odpytywany.
* Zawiera informację na temat aktualnego poziomu, pozostałych szans
* oraz statusie rozgrywki.
*/
public class GWords {
    int level = 1;
    int lifes = 3;
    int gamestatus = 1;
    //definicja Hashmap'y ze słowami
    HashMap<String,String> words = new HashMap<>();
    GWords(){
        AddWord(words);
    }
    //metoda pozwalająca na szybką i łatwą modyfikacje/dodanie słów oraz kluczy do puli
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
    //metoda odpowiedzialna za losowanie słów z Hashmap'y oraz
    //ustawianie liczy żyć i wylosowanego słowa w odpowiednim miejscu
    void Wordset(TextField txtup, HashMap<String,String> words, TextField txtcenter){

        Random r = new Random();
        ArrayList<String> keys = new ArrayList<>(words.keySet());
        String outpword = words.get(keys.get(r.nextInt(keys.size())));
        txtup.setText(outpword);
        txtcenter.setText("Pozostałe szanse: " + lifes);
    }
    //metoda sprawdzająca poprawność/istnienie wpisanego słowa klucz z pola tekstowego
    boolean Wordcheck(TextField txtdown, TextField txtup, HashMap<String,String> words){
        boolean contains = false;
        String inpword = txtdown.getText();
        if(Objects.equals(words.get(inpword), txtup.getText())){
            contains=true;
        }
        return contains;
    }
}
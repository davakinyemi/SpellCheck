/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import static java.lang.System.out;

/**
 *
 * @author dav
 */
public class SpellCheck {
    private final Dictionary dictionary;
    private ArrayList<String> words;
    
    public SpellCheck(){
        dictionary = new Dictionary();
        words = new ArrayList<>();
    }
            
    private ArrayList searchWord(String word){
        ArrayList<String> wordList;
        char s = word.toUpperCase().charAt(0);
        int asciiVal = (int) s;
        
        if(asciiVal >= 65 && asciiVal <= 90){
            wordList = (ArrayList) dictionary.getLexiconMap().get(s);
            wordList.stream().filter((c) -> (c.equals(word))).forEach((c) -> {
                words.add(c);
            });
        } else {
            out.println("First character of word is not an alphabet");
            return null;
        }
        
        if(words.isEmpty()){
            
        }
        
        return words;
    }
    
    private ArrayList similarWords(){
        
        return null;
    }
    
    public ArrayList check(String word){   
        return searchWord(word);
    }
}

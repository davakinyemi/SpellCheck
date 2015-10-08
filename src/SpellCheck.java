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
    private ArrayList<String> words, wordList; 
    
    public SpellCheck(){
        dictionary = new Dictionary();
        words = new ArrayList<>();
    }
            
    private ArrayList searchWord(String word){
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
            words = getSimilarWords(word);
            if(words.isEmpty())
                out.println("Sorry, word could not be found. Try a different spelling");
        } 
        
        return words;
    }
    
    private ArrayList getSimilarWords(String word){
        String sCode = Soundex.encode(word);
        wordList.stream().filter((s) -> (Soundex.encode(s).equals(sCode))).forEach((s) -> {
            words.add(s);
        });
        return words;
    }
    
    public ArrayList check(String word){   
        return searchWord(word);
    }
}

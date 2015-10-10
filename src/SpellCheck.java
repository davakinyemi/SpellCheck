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
    private final Dictionary dictionary; // dictionary instance
    private ArrayList<String> words, wordList; // arraylists to store words 
    
    public SpellCheck(){
        dictionary = new Dictionary();
        words = new ArrayList<>();
    }
            
    private String searchWord(String word){
        char s = word.toUpperCase().charAt(0);
        int asciiVal = (int) s;
        
        if(asciiVal >= 65 && asciiVal <= 90){ // if character is an alphabet
            wordList = (ArrayList) dictionary.getLexiconMap().get(s);
            wordList.stream().filter((c) -> (c.equals(word))).forEach((c) -> {
                words.add(c);
            });
        } else {
            out.println("First character of word is not an alphabet");
            return null;
        }
        
        if(words.isEmpty()){ // if word is not found
            useSoundex(word); // use soundex to get list of similar words
            useJaroWinkler(word); // use jarowinkler to narrow down list of words
            if(wordList.isEmpty())
                out.println("Sorry, word could not be found. Try a different spelling");
            return word.toUpperCase() + ": " + wordList.toString();
        } 
        
        return word.toUpperCase() + ": " + words.toString();
    }
    
    private void useJaroWinkler(String word){
        wordList.clear();
        words.stream().filter((s) -> (new JaroWinkler().similarity(s, word) >= 0.85)).forEach((s) -> {
            wordList.add(s);
        });
    }
    
    private void useSoundex(String word){
        String sCode = Soundex.encode(word);
        wordList.stream().filter((s) -> (Soundex.encode(s).equals(sCode))).forEach((s) -> {
            words.add(s);
        });
    }
    
    public String check(String word){   
        return searchWord(word);
    }
}

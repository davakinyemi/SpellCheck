/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import static java.lang.System.out;
import java.io.*;
/**
 *
 * @author dav
 */
public class Dictionary {
    private final HashMap<Character, ArrayList> lexiconMap;
    private final static String filePath = "/home/dav/TheOdinProject/javaWorkspace/SpellChecker/words";    
    private final File lexicon;
    
    public Dictionary(){
        lexiconMap = new HashMap<>();
        lexicon = new File(filePath);
        prepareHashMap();
    }   
    
    private void prepareHashMap(){
        char c;
        for(int i = 65; i <= 90; i++){
            c = (char) i;
            lexiconMap.put(c, new ArrayList<>());
        }
        loadFile();
    }
    
    private void loadFile(){
            try (BufferedReader reader = new BufferedReader(new FileReader(lexicon))) {
                String line;
                while((line = reader.readLine()) != null){
                    addWords(line);
                }
	} catch (IOException ex){
            System.out.println("couldn't read the file");
	}
    }
    
    private void addWords(String word){
        char c = word.toUpperCase().charAt(0);
        int asciiVal = (int) c;
        if(asciiVal >= 65 && asciiVal <= 90)
            lexiconMap.get(c).add(word);
    }
    
    public HashMap getLexiconMap(){
        return lexiconMap;
    }
    
}

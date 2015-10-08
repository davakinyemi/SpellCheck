/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.System.out;

/**
 *
 * @author dav
 */
public class SpellCheckSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Dictionary dict = new Dictionary();
        //out.println(dict.getLexiconMap().toString());
        //out.println(Soundex.encode("bucket") + " " + Soundex.encode("buket"));  
        SpellCheck sp = new SpellCheck();
        out.println(sp.check("buket"));
        
    }
    
}

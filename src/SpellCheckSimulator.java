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
        out.println(new SpellCheck().check("buket"));
        out.println(new SpellCheck().check("bible"));
        out.println(new SpellCheck().check("joket"));
    }
    
}

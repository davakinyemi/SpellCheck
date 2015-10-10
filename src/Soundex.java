 /* 
 ** The first letter of the code is the same the same as the first 
 ** letter of the original string. Thereafter, numbers are assigned 
 ** as follows:
 **
 **      0 AEIOUHWY
 **      1 BFPV
 **      2 CGJKQSXZ
 **      3 DT
 **      4 L
 **      5 MN
 **      6 R
 **
 ** Then the following transformations are applied
 **   1. zeros are removed
 **   2. runs of the same digit are removed
 **   3. digits after the 1st 3 are discarded and zeros are added
 **      so that there are exactly 3 digits in the code.
 **
 ** An input string may have different side-by-side letters that map
 ** to the same number on the Soundex coding guide. For example, the
 ** c, k and s in Jackson all map to the number 2. These letters with
 ** the same code should be treated as only one letter. In the name 
 ** Jackson, the k and s should be disregarded. This rule also applies 
 ** to the first letter of the string, even though it is not coded.
 ** For example, the P and f in Pfister both map to the number 1. Thus
 ** in this name, the f should be disregarded.
 */
  
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.BufferedReader;
  
  public final class Soundex {
     
     private static final char[] mapping = {
        '0','1','2','3','0','1','2','0','0','2','2','4','5','5','0','1','2','6','2','3','0','1','0','2','0','2'
     };
  
     private static char codeOf (char c) {
        return (mapping[c-'A']);
     }
  
     private static final int CODE_LENGTH = 4;
  
     public static String encode(String s) {
  
  
        // Loop to read all input lines
        read_loop: for (;;) {
           if (s==null) break;
  
           // Check for a blank line
           if (s.length() <= 0) {
              System.out.println ("Bad input line.");
              return "0";
           }
           
           s = s.replaceAll("'", "");
           
           // Transform input string to all caps
           final char [] input = s.toUpperCase().toCharArray();
  
           // Check the input line for non-alpha characters
           for (int i = 0; i < input.length; i++) {
              if ((int) input[i] < 65 || (int) input[i] > 90) {
                 return "0";
              }
           }
   
           int code_index=0;
           char[] code = new char[CODE_LENGTH];
  
           // The 1st character of code is 1st letter of input
           code[code_index++] = input[0];
  
           // Save the digit that the first character maps to
           char prev_c = codeOf (input[0]);
  
           // Transform the remaining letters in the string
           for (int i = 1; i<s.length() && code_index<CODE_LENGTH; i++) {
              final char c = codeOf (input[i]);
              if (c != '0' && c != prev_c) {
                 code[code_index++] = c;
               }
              prev_c = c;
           }
  
           // Right pad with '0's to get three digits
           for (int i = code_index; i < CODE_LENGTH; i++) {
              code[i] = '0';
           }
           return String.valueOf(code);
        }
        return null;
     }
  }
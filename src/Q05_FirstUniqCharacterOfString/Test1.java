// First Unique Characters

package Q05_FirstUniqCharacterOfString;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 First unique character of a string. E.g. aabdcce . Output : d
 */

public class Test1 {
  static final int max_size = 200;
  
  public static void main(String[] args) {
   String s = "aabbcdef";
   firstUniqueCharacter(s); 
    
  }
  
  static void firstUniqueCharacter(String s){
      char[] charIndex = new char[max_size];
      int countIndex = -1;
    
    for(int i = 0; i< s.length(); i++){
        charIndex[s.charAt(i)]++;
    }
    
    for(int i = 0; i< s.length(); i++) {
        if(charIndex[s.charAt(i)] == 1) {
          countIndex = i;
          break;
        }  
    }
    
    System.out.println("first unique character is : "+ s.charAt(countIndex));
    
  }
}

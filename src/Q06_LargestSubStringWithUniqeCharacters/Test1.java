package Q06_LargestSubStringWithUniqeCharacters;

import java.util.LinkedHashMap;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 Largest substring with unique characters e.g. aaabcbdeaf Output : cbdeaf
 */

public class Test1 {
  public static void main(String s[]){
    String input = "aaabcbdeaf";
    longestSubString(input);    
  }
  
  static void longestSubString(String s){
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    String substring = "";
    char[] ch = s.toCharArray();
    for(int i = 0 ; i < ch.length; i++){
      if(!map.containsKey(ch[i])){
        map.put(ch[i],i);
      }else{
        i = map.get(ch[i]);
        map.clear();
      }
      
     // substring = map.keySet().toString();
    }
  
    for(Character key : map.keySet()){
      substring = substring + key;
    }
    
    System.out.println("longest substring with unique Character is: "+ substring);
  }
}

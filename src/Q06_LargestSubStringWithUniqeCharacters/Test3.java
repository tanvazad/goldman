package Q06_LargestSubStringWithUniqeCharacters;

import java.util.LinkedHashMap;

public class Test3 {
  public static void main(String s[]){
    String input = "aaabcbdeaf";
    
    longestSubString(input);    
  }
  
  static void longestSubString(String s){
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    String substring = "";
    char[] ch = s.toCharArray();
    
    for(int i = 0 ; i < ch.length; i++){
      if(map.containsKey(ch[i])){
    	  i = map.get(ch[i]);
          map.clear();
        
      }else{
    	map.put(ch[i],i);
      }
    }
  
    for(Character key : map.keySet()){
      substring = substring + key;
    }
    
    System.out.println("longest substring with unique Character is: "+ substring);
  }
}

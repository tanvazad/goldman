package Q33_FindUniqueTuples_Substring;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Test2{

  public static void main(String[] args){
    String s = "aabcd"; 
    uniqueTuples(s,2); 
  }
  
  public static void uniqueTuples(String input, int k){
    Set<String> set =  new HashSet<String>();
    for(int i=0; i<input.length()-1;i++){
      String sb = "";
     for(int j=i;j<k+i;j++){
      
       sb = sb + input.charAt(j);
       
     }
      set.add(sb.toString());
      sb = "";
    }
   /* set.forEach(value ->{
      System.out.println(value);
    });*/
  }   
}


package Q30_ApacheLogs;

import java.util.HashMap;

public class Test2 {

   public static void main(String[] args) {
      String lines =   "10.0.0.1-frank [10/dec/17 10:14:27] ,10.0.0.1-frank [10/dec/17 10:14:28],10.0.0.2-nancy [10/dec/17 10:14:28],10.0.0.1-frank [10/dec/17 10:14:27";
      String[] arr = lines.split(",");

      HashMap<String,Integer> hm = new HashMap<String,Integer>();
      for(String s : arr) {
         String[] s2 = s.split("-");
            if ( hm.containsKey(s2[0].trim()))
               hm.put(s2[0], hm.get(s2[0].trim())+1);
            else
               hm.put(s2[0].trim(), 1);

      }
      int max=0;
      String temp="";
      for(String s1 : hm.keySet())
      {
    	  if(max<hm.get(s1))
    	  {
    		  max=hm.get(s1);
    		  temp = s1;
    	  }
      }
      
      System.out.println(temp);
   }
}

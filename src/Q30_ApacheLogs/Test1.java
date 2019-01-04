package Q30_ApacheLogs;

import java.util.*;

public class Test1 {

   /*public static String findApacheLog(String[] lines) {
      Map<String, Long> output = Arrays.asList(lines).stream()
            .map(data -> Arrays.asList(data.split("-")))
            .map(data -> data.get(0))
            .collect(Collectors.groupingBy(
               Function.identity(), Collectors.counting()));
      
   //output.entrySet().stream().forEach(data -> System.out.println(data.getKey()+"--->"+data.getValue()));
      String key = Collections.max(output.entrySet(), Map.Entry.comparingByValue()).getKey();
      System.out.println("ip "+ key + " repeated Value "+ output.get(key));
      return key;
   }*/


   public static void main(String[] args) {
      String lines =   "10.0.0.1-frank [10/dec/17 10:14:27] ,10.0.0.1-frank [10/dec/17 10:14:28],10.0.0.2-nancy [10/dec/17 10:14:28],10.0.0.1-frank [10/dec/17 10:14:27";
      String[] arr = lines.split(",");

      HashMap<String,Integer> hm = new HashMap<String, Integer>();
      for(String s : arr) {
         String[] s2 = s.split("-");
            if ( hm.containsKey(s2[0].trim()))
               hm.put(s2[0], hm.get(s2[0].trim())+1);
            else
               hm.put(s2[0].trim(), 1);

      }
      System.out.println(hm);
      /*List<String> list =captureValues(lines);
      System.out.println(Arrays.toString(list));*/
   }


      //String ipAddress = findApacheLog(lines);
   // System.out.println(ipAddress);


}

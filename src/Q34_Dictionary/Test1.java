package Q34_Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    static String findLongestMeaningString(String str) {
        int maxLen = Integer.MAX_VALUE;
        String temp1 = "";
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                try
                {
                    if (isDisctionary(str.substring(i, j))) {
                        temp1 = str.substring(i, j);
                        map.put(temp1,temp1.length());
                    }
                }
                catch (Exception ex){}
            }
        }
        int max=0;
        String result="";
        for(String key : map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static boolean isDisctionary(String str1) {

        String[] dict = {"apple", "this", "is", "better", "book", "a"};
        for (String str : dict) {
            if (str.equals(str1))
                return true;
        }
        return false;
    }

    public static void main(String args[]) {

        String str1 = "thisisaasdjakslbetterbook";
        System.out.println("meaningful char is : " + Test1.findLongestMeaningString(str1));

    }
}

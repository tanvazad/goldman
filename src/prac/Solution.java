package prac;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static HashMap<String,Integer> perm = new HashMap<String,Integer>();;
    static int  max=Integer.MAX_VALUE;
    
    static int maxValue(String t) {
        // Complete this function
        for(String s : perm.keySet()){
            if(max>perm.get(s)){
                max=perm.get(s);
            }
        }
        return max;        
    }

    public static void main(String[] args) {
       // Scanner in = new Scanner(System.in);
        String t = "aaaaaa";
        permute(t,0,t.length());
        int result = maxValue(t);
        System.out.println(result);
      //  in.close();
    }
    static int count=0;
    static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);                
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
 

    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }     
   
}

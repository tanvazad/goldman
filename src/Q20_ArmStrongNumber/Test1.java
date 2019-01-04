package Q20_ArmStrongNumber;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Test1 {
  public static void main(String[] args) {
   // int input[] = {5, 3, 1, 4, 7, 8};
    int input = 153;
      boolean armstrong = getArmStrongNumber(input);
      if(armstrong){
        System.out.println("this is an armstrong no.");
      } else {
          System.out.println("this is not an armstrong no.");
      }
  }
  
  static boolean getArmStrongNumber(int input) {  
    int result = 0;
    int number = input;
    int mod = 0;
      while(number > 0){
          mod = number % 10;
          number = number / 10 ;
          result = result + (mod * mod * mod);
        }
      if(result == input){
          return true;
      } else {
        return false;
      }
  }
}
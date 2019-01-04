package Q15_NumberPowerOfAnotherNumber;

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
    
    int x = 3;
    int y = 9;
   
    boolean isPower = checkIfNumberIsPower(x,y);
    
    System.out.print(isPower);
    
  }
  
 static boolean checkIfNumberIsPower(int x, int y){
  
    if(x==1)
      return (y ==1);
    
    int pow = 1;
    while(pow<y)
      pow = pow * x;
    
    return (pow==y);
    
  }
  
}
package Q02_2ndSamllestOfSortedRotatedArray;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
 second smallest Element In Sorted Rotated Array
 */

public class Test3 {
  public static void main(String[] args) {
    int[] arr = {3,4,5,6,1,2};
    secondSmallestElementInSortedRotatedArray(arr);
  }
  
  static void secondSmallestElementInSortedRotatedArray(int[] arr) {
      int secondSmallest;
      int index = 0;
      for(int i = 0; i < arr.length; i++){
        if(arr[i] > arr[i+1]){
        	index = i+1;
          break;
        }
      }
      
    if(index == arr.length - 1){
        secondSmallest = arr[0]; 
    } else {
        secondSmallest = arr[index + 1];
    }
    
    System.out.println("Second smallest no. is : " + secondSmallest);
  }
}

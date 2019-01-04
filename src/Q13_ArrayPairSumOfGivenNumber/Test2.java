package Q13_ArrayPairSumOfGivenNumber;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
	  public static void main(String[] args) {
	    
	    int[] input = {1,2,3,4,5,6,7,8};
	    int sum = 10;
	    int countOfPairs  = getCountOfPairsForTheGivenSum(input,sum);
	    System.out.println("Pair count:"+countOfPairs);
	    
	    }

	  static int getCountOfPairsForTheGivenSum(int[] input,int sum){
	    
	    Map<Integer,Integer>  numbersFromInputArray = new HashMap<>();
	    int length = input.length;
	    int count= 0;
	    
	    if(length<2){
	     System.out.println("Input array length is less than 2.");
	       return 0;
	    }
	    //store numbers from input array into map
	    for(int i=0; i<length;i++){
	      int key = input[i];
	      if(numbersFromInputArray.containsKey(key)){
	          numbersFromInputArray.put(key,numbersFromInputArray.get(key)+1);
	      }else{
	    	  numbersFromInputArray.put(key,1);
	      }
	    }
	    
	    //check for the sum - numbers in array to find the count
	    for(int i=0; i<length;i++){
	      int remainingSum = sum-input[i];
	      if(numbersFromInputArray.containsKey(remainingSum))
	          count++;
	    }
	    
	    return count/2;
	  }
	  
	}
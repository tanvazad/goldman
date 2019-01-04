// Second Greatest Elements

package Q01_2ndSmallestOfUnsortedArray;

public class Test3 {
	  public static void main(String[] args) {
	   int[] arr = {3,7,1,5,2};
	   secondSmallest(arr);
	  }
	  
	  static void secondSmallest(int[] arr){
	    
	    int first, second ;
	    first = second = Integer.MIN_VALUE;
	    for(int i = 0; i < arr.length; i++){
	        if(arr[i] > first){
	          second = first;
	          first = arr[i];
	        } else if(arr[i] > second && arr[i] != first){
	            second = arr[i];
	        }
	    }
	    
	    if(second == Integer.MIN_VALUE){
	      System.out.println("there is no second smallest");
	    }else {
	        System.out.println("second smallest no. is: "+ second);
	    }
	  
	  }
	}

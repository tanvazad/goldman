// Second Smallest Elements

package Q01_2ndSmallestOfUnsortedArray;

public class Test22 {
	  public static void main(String[] args) {
	   int[] arr = {10};
	   int c= secondSmallest(arr);
	   System.out.println(c);
	  }
	  
	  static int secondSmallest(int[] arr){
	    
	    int first, second ;
	    first = second = arr[0];
	    if(arr.length==1)
	    	 return -1;
	    if(arr.length>2)
	    {
	    	 for(int i = 1; i < arr.length; i++){
	 	        if(arr[i] < first){
	 	          second = first;
	 	          first = arr[i];
	 	        } else if(arr[i] < second && arr[i] != first){
	 	            second = arr[i];
	 	        }
	 	    }
	    	 if(second == first ){
	   	      return -1;
	   	    }else {
	   	        return second;
	   	    }
	    }
	    else
	    {
	    	if(arr[0]>arr[1])
	    		 return arr[0];
	    	else
	    		 return arr[1];
	    }
	   
	   
	  }
	}

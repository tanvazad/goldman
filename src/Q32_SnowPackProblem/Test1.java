package Q32_SnowPackProblem;


public class Test1 {
  
 static int findSnow(int arr[], int n)
 {
     // initialize output
     int result = 0;
       
     // maximum element on left and right
     int left_max = 0, right_max = 0;
       
     // indices to traverse the array
     int lo = 0, hi = n-1;
       
     while(lo <= hi) 
     {
         if(arr[lo] < arr[hi])
         {
             if(arr[lo] > left_max)
  
             // update max in left
             left_max = arr[lo];
             else
  
             // snow on curr element = 
             // max - curr
             result += left_max - arr[lo];
             lo++;
         }
         else
         {
             if(arr[hi] > right_max)
              
             // update right maximum
             right_max = arr[hi];
              
             else
             result += right_max - arr[hi];
             hi--;
         }
     }
       
     return result;
 }
  
 /* Driver program to test above function */
 public static void main(String[] args) 
 {
   //  int arr[] = {0, 1, 0, 2, 1, 0, 1,3, 2, 1, 2, 1};
     int arr[] = {0, 1, 3, 0, 1, 2, 0,4, 2, 0, 3, 0};
     int n = arr.length;
      
     System.out.println("Maximum snow that "
                    + "can be accumulated is "
                    + findSnow(arr, n));
      
 }
}
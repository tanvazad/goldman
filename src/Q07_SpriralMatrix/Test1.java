package Q07_SpriralMatrix;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Test1 {
  
  static void printSpiral(int[][] matrix){
    
    int row = 0;
    int col = 0;
    
    int rowLen = matrix.length - 1;
    int colLen = matrix[0].length - 1;
    
    while(row < rowLen && col < colLen){
      
      // first row
      for(int i = col; i <= colLen; i++){
          System.out.print(matrix[row][i] + " ");
      }
      
      //last column
      for(int i = row+1;i<= rowLen; i++){
         System.out.print(matrix[i][colLen] + " ");
      }
      
      // last row
      if(row+1 <= rowLen){
        for(int i = colLen-1; i >= col; i--){
            System.out.print(matrix[rowLen][i] + " ");
        }
      }
      
      //first column
       if(col+1 <= colLen){
          for(int i = rowLen-1;i> row; i--){
             System.out.print(matrix[i][col] + " ");
          }
       }
            
      
      row++;
      col++;
      rowLen--;
      colLen--;
    
    }
  
  }
  
  public static void main(String[] args) {
  
    int matrix[][] = {{1,2,3,10},
                      {4,5,6,11},
                      {7,8,9,12},
                      {13,14,15,16}};
    printSpiral(matrix);
    
  }
}
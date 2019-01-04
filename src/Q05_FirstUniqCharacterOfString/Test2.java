// First Unique Characters

package Q05_FirstUniqCharacterOfString;

public class Test2 {
  static final int max_size = 200;
  
  public static void main(String[] args) {
   String s = "aabbcdef";
   firstUniqueCharacter(s); 
    
  }
  
  static void firstUniqueCharacter(String s){
      char[] ch = new char[max_size];

      for(int i=0;i<s.length();i++)
      {
    	  ch[s.charAt(i)]++;
      }
   
      int count=-1;
     for(int i=0; i<s.length(); i++)
     {
    	 if(ch[s.charAt(i)]==1)
    	 {
    		 count=i;
    		 break;
    	 }
     }
    
     if(count!= -1)
    	 System.out.println("first unique character is : "+ s.charAt(count));
     else
    	 System.out.println("No Unique Element");
    
  }
}

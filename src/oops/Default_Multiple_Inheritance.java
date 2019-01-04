package oops;
interface MyInterface1{  
	 
    static void newMethod(){  
        System.out.println("Newly added default method");  
    }  
    void existingMethod(String str);  
}  
interface MyInterface2{  
	 
    static void newMethod(){  
        System.out.println("Newly added default method");  
    }  
    void disp(String str);  
} 
public class Default_Multiple_Inheritance implements MyInterface1, MyInterface2{ 
	// implementing abstract methods
    public void existingMethod(String str){           
        System.out.println("String is: "+str);  
    }  
    public void disp(String str){
    	System.out.println("String is: "+str); 
    }
    //Implementation of duplicate default method
    public  void newMethod(){  
        System.out.println("Implementation of default method");  
    }  
    public static void main(String[] args) {  
    	Default_Multiple_Inheritance obj = new Default_Multiple_Inheritance();
    	
    	//calling the default method of interface
        obj.newMethod();     
  
  
    }  
}
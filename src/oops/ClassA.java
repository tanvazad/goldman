package oops;

public class ClassA {

	public static void main(String args[]) {

		MyInterface myInterface = () -> {           
                  System.out.println("xx");
				};
		myInterface.myMethod();


	}

	
}

class A {
	public void m1(String s1,String s2) {
		System.out.println("void m1");
	}
	
}

class B extends A {
	
	public void m1(String s1,String s2) {
		System.out.println("void m1 from class B" );		
	}
	public String m2(String s1,String s2) {
		System.out.println("String");
		return "Sring m1";
	}
}

interface MyInterface{ void myMethod();}	
package Q25_StairCaseProblem;


public class Test2 {

	public static void main(String[] args) {				
		int steps=3;
		System.out.println(getNoOfWays(steps));
	}

	private static int getNoOfWays(int n) {		
		int noOfWays=fib(n);		
		return noOfWays;
	}

	private static int fib(int n) {		
		if(n<=1) return 1;
		return fib(n-1)+fib(n-2);	
	}	
}

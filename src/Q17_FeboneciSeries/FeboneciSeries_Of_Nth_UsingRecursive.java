// Using Recursive
package Q17_FeboneciSeries;


public class FeboneciSeries_Of_Nth_UsingRecursive {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(fib(n));
	}

	static int fib(int n) {
		if(n<2)
			return n;
		else
		{
			return fib(n-1) + fib(n-2);
		}
	}	
}

//1 1 2 3 5 8 13 21 34

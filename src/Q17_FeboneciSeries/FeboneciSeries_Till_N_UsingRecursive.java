// Using Recursive
package Q17_FeboneciSeries;

public class FeboneciSeries_Till_N_UsingRecursive {

	public static void main(String[] args) {
		int n = 6;
		for (int i = 0; i <= n; i++)
			System.out.println(fib(i));
	}

	static int fib(int n) {
		if (n < 2)
			return n;
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}

// 1 1 2 3 5 8 13 21 34

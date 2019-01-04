// Using Iterative

package Q17_FeboneciSeries;


public class FeboneciSeries_Till_N_UsingIterative {

	public static void main(String[] args) {
		int n = 6;
		fib(n);
	}

	static void fib(int n) {
		int f1 = 0, f2 = 1, f3;
        System.out.print(f2+" ");
        for (int i = 2; i <= n; i++)
        {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            System.out.print(f2+" ");
        }
	}	
}

//1 1 2 3 5 8 13 21 34

package Q17_FeboneciSeries;

public class Test6 {
	public static void fibonaciRecursion(int a, int b, int count) {
		if (count >= 1) {
			int c = a + b;
			a = b;
			b = c;
			System.out.println(c);
			fibonaciRecursion(a, b, count - 1);
		}
	}

	public static void fibonaci(int a, int b) {
		for (int i = 0; i < 10; i++) {
			int c = a + b;
			a = b;
			b = c;
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int count = 10;
		// Fibonaci.fibonaci(a, b);
		Test6.fibonaciRecursion(a, b, count);

	}

}
// The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...

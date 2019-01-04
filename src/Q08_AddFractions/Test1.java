package Q08_AddFractions;


public class Test1 {
	public static void main(String[] args) {
		// 2/3 + 3/4
		int num1 = 2;
		int deno1 = 3;
		int num2 = 3;
		int deno2 = 4;

		addFraction(num1, deno1, num2, deno2);

	}

	private static void addFraction(int num1, int deno1, int num2, int deno2) {

		int x = (num1 * deno2) + (num2 * deno1);
		int y = deno1 * deno2;

		int gcd = GCD(x, y);

		int num = x / gcd;
		int deno = y / gcd;
		System.out.print("(" + num1 + "/" + deno1 + ") + (" + num2 + "/" + deno2 + ") = " + num); 
		System.out.println((deno == 1)? "":"/"+deno);

	}

	private static int GCD(int x, int y) {
		if (x == 0 || y == 0)
			return 0;
		if (x == y)
			return x;
		if (x > y)
			return GCD(x - y, y);
		return GCD(x, y - x);
	}
}

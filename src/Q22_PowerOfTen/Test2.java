package Q22_PowerOfTen;


public class Test2 {

	public static void main(String[] args) {

		double n = -0.001;
		boolean negative = false;
		n = Math.abs(n);
		System.out.println(isPowerOfTen(n));
	}

	private static boolean isPowerOfTen(double n) {
		if (n < 1 && n!=0) {
			while (n < 1)
				n = n * 10;
		}
		// n=1
		int pow = 1;
		while (pow < n) {
			pow *= 10;
		}
		return pow == n;
	}
}

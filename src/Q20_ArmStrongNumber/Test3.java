package Q20_ArmStrongNumber;

public class Test3 {
	public static void atoi(String data) {
		checkNumber(data);
		char[] c = data.toCharArray();
		int result = 0;
		for (int i = 0; i < c.length; i++) {
			int dt = c[i];
			result = (result * 10) + (dt - '0');
		}
		System.out.println(result);
	}

	public static void checkNumber(String data) {
		try {
			int dt = Integer.parseInt(data);
			if (dt < 0) {
				throw new RuntimeException("Given input an Negative Number ");
			}
		} catch (NumberFormatException e) {
			throw new RuntimeException("Given input Not an Integer ");
		}
	}

	public static void main(String[] args) {
		String data = "524";
		Test3.atoi(data);
	}

}

package Q19_AskiToInteger;

public class Test1 {

	public static void main(String[] args) {
		String s = "5";
		String s1 = "2";
		int res = atoi(s) + atoi(s1);

		System.out.println("atoi:" + res);

	}

	static int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;

		str = str.trim();
		int i = 0;
		double result = 0;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		return (int) result;
	}

}
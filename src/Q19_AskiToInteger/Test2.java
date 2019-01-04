package Q19_AskiToInteger;

public class Test2 {

	public static void main(String[] args) {
		String s = "123";
		atoi(s);
	}

	static void atoi(String str) {
		str = str.trim();
		
		char ch[] = str.toCharArray();
		
		for(char c: ch)
			System.out.print((int) c+" ");
	}
}
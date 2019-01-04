package Q14_Panagram;

public class Test2 {

	public void panagaram(String str) {
		StringBuffer sf = new StringBuffer();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (str.indexOf(ch) < 0) {
				sf.append(ch);
			}
		}
		System.out.print(sf.toString());
	}

	public static void main(String[] args) {
		Test2 panagramObj = new Test2();
		String str = "Sapient Consulting";
		panagramObj.panagaram(str);

	}
}

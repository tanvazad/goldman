package Q14_Panagram;

public class Test1 {

	public void panagaram(String str) {
		StringBuffer sf = new StringBuffer();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (str.indexOf(ch) < 0) {
				sf.append(ch);
			}
		}
		System.out.print("Result >>>>" + sf.toString());
	}

	public static void main(String[] args) {
		Test1 panagramObj = new Test1();
		String str = "Sapient Consulting";
		panagramObj.panagaram(str);

	}
}

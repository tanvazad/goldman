package Q30_ApacheLogs;

import java.util.HashMap;

public class Test3 {

	public static void main(String[] args) {
		String lines = "10.0.0.1-frank [10/dec/17 10:14:27] ,10.0.0.2-frank [10/dec/17 10:14:28],10.0.0.2-nancy [10/dec/17 10:14:28]";
		String[] arr = lines.split(",");

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int max = 0;
		String temp = "";
		for (String s : arr) {
			String[] s2 = s.split("-");
			String t = s2[0].trim();
			if (hm.get(t) != null) {
				hm.put(t, hm.get(t) + 1);
				if (hm.get(t) >= max) {
					max = hm.get(t);
					temp = t;
				}
			} else
				hm.put(t, 1);

		}
		System.out.println(temp);
		System.out.println(max);
	}
}

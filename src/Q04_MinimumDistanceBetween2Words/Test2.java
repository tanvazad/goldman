package Q04_MinimumDistanceBetween2Words;

import java.util.Arrays;

public class Test2 {
	static String p = "Hi ABCD       is my DEF";

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "DEF";
		minDist(s1, s2);

	}

	static void minDist(String s1, String s2) {
		String[] arr = p.split("\\s+");
		System.out.println(Arrays.toString(arr));
		int s1pos = 0;
		int s2pos = p.length() + 1;
		int minDis = p.length() + 1;

		int cur = 0, d = 0;
		for (String word : arr) {
				
			if (word.equals(s1)) {
				s1pos = cur + (int) Math.ceil(word.length() / 2.0);
			}
			if (word.equals(s2)) {
				s2pos = cur + (int) Math.ceil(word.length() / 2.0);
			}
			d = Math.abs(s2pos - s1pos);

			if (d < minDis) {
				minDis = d;
			}
			cur = cur + word.length() + 1;
		}
		System.out.println("This is the distance : " + minDis);
	}

}
package Q13_ArrayPairSumOfGivenNumber;

import java.util.HashSet;
import java.util.Set;

public class Test4 {
	public static void main(String arg[]) {
		firstWay();
	}

	public static void firstWay() {
		int sum = 10;
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int diff = sum - a[i];
			if (set.contains(diff))
				count++;
			else
				set.add(a[i]);
		}

		System.out.println(count);

	}
}
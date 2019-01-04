package Q13_ArrayPairSumOfGivenNumber;

import java.util.LinkedHashMap;
import java.util.Map;


public class Test3 {
	public static void main(String arg[]) {
		firstWay();
	}

	public static void firstWay() {
		int num = 12;
		int a[] = { 1,2,3,4,5,6,7,8,9,10,11,12,-6,-8,18,11};
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}

//		if (map.get(num / 2) == 1)
//			map.remove(num / 2);

		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			temp = num - a[i];
			if (map.get(temp)!=null) {
				System.out.println(a[i] + " - " + temp);
			}
		}
	}
}
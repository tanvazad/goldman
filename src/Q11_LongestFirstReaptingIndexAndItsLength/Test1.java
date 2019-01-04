package Q11_LongestFirstReaptingIndexAndItsLength;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test1 {
	public static void main(String[] args) {

		String input = "aabbbbddc";
		Entry<Character, Integer> entry = findLongestRepeatingChar(input);
		char ch = entry.getKey();
		int length = entry.getValue();
		int index = input.indexOf(ch);

		System.out.println("[" + index + ", " + length + "]");

	}

	private static Entry<Character, Integer> findLongestRepeatingChar(String input) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] array = input.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		Map.Entry<Character, Integer> temp = null;
		int maxLength = Integer.MIN_VALUE;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (maxLength < entry.getValue()) {
				temp = entry;
				maxLength = entry.getValue();
			}
		}
		return temp;
	}

}

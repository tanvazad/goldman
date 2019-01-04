package Q03_Anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa", "aab", "acd", "bba", "aba", "cad", "bab", "baa", "dac");
		anagram(list);
	}

	public static void anagram(List<String> list) {

		Map<String, List<String>> map = new HashMap();

		for (String s : list) {
			char[] charr = s.toCharArray();
			Arrays.sort(charr);
			String key = String.valueOf(charr);
			List<String> l = null;
			if (map.containsKey(key)) {
				l = map.get(key);
			} else {
				l = new ArrayList();
			}
			l.add(s);
			map.put(key, l);
		}
		System.out.println(map);
	}

}

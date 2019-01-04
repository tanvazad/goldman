// First Unique Characters

package Q05_FirstUniqCharacterOfString;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test3 {
	static final int max_size = 200;

	public static void main(String[] args) {
		String s = "aabbcdecf";
		firstUniqueCharacter(s);

	}

	static void firstUniqueCharacter(String s) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		int count=-1;
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				count=i;
				break;
			}
		}
		
		if(count!= -1)
		{
			System.out.println("First Unique Elements = "+s.charAt(count));
		}
		else
		{
			System.out.println("No Unique Elements");
		}
	}
}

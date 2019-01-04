package Q33_FindUniqueTuples_Substring;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Test3 {

	public static void main(String[] args) {
		String s = "aabcaabd";
		uniqueTuples(s, 4);
	}

	public static void uniqueTuples(String input, int k) {
		Set<String> set = new LinkedHashSet<String>();
		for (int i = 0; i < input.length() - 1; i++) {
			String sb = "";
			for (int j = i; j < k + i; j++) {
				try {
					sb = sb + input.charAt(j);
				} catch (Exception ex) {
					sb = "";
				}
			}
			if (sb.length() != 0)
				set.add(sb.toString());
		}
		/*set.forEach(value -> {
			System.out.println(value);
		});*/
	}
}

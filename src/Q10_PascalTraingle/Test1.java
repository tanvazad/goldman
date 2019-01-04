package Q10_PascalTraingle;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Test1 {
	public static void main(String[] args) {
		int DEFAULT_ROWS = 10;
		int row = 3;
		int position = 2;
		int element = getElementFromPascalTree(DEFAULT_ROWS, row, position);
		System.out.println("At row:" + row + ", position:" + position + "-->" + element);
	}

	static int getElementFromPascalTree(int default_rows, int row, int position) {
		if (position > row) {
			return 0;
		}
		if (position == 1 || row == position) {
			return 1;
		}
		return getElementFromPascalTree(default_rows, row - 1, position)
				+ getElementFromPascalTree(default_rows, row - 1, position - 1);
	}
}
/*  
1
1 1
1 2 1
1 3 3 1


*/
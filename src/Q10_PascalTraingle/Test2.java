package Q10_PascalTraingle;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Test2 {
	public static void main(String[] args) {
		int DEFAULT_ROWS = 10;
		int row = 3;
		int position = 2;
		int element = getElementFromPascalTree(row, position);
		System.out.println("At row:" + row + ", position:" + position + "-->" + element);
	}

	static int getElementFromPascalTree(int row, int cols) {
		if (cols > row) {
			return 0;
		}
		if (cols == 1 || row == cols) {
			return 1;
		}
		return getElementFromPascalTree(row - 1, cols) + getElementFromPascalTree(row - 1, cols - 1);
	}
}
/*  
1
1 1
1 2 1
1 3 3 1


*/
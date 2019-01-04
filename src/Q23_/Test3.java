package Q23_;

public class Test3 {
	public static void main(String arg[]) {
		int[] arr = { 2,4,5,6,8 };
		int min = minimumSubArrayLength(arr, 11);
		
		System.out.println(min);
	}

	private static int minimumSubArrayLength(int[] arr, int sum) {
		int minLength = arr.length + 1;

		for (int start = 0; start < arr.length; start++) {
			int currentSum = arr[start];
			if (currentSum > sum)
				return 1;
			for (int end = start + 1; end < arr.length; end++) {
				currentSum += arr[end];
				if (currentSum > sum && (end - start + 1) < minLength)
					minLength = (end - start + 1);
			}
		}
		return minLength;
	}
}

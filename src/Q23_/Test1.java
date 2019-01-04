package Q23_;

public class Test1 {

	public int smallestSubArray(int[] arr, int sum) {

		int length = arr.length;
		int currSum = 0;
		int minLength = length;

		for (int start = 0; start < length; start++) {
			currSum = arr[start];
			if (currSum > sum) {
				return 1;
			}

			for (int end = start + 1; end < length; end++) {
				currSum = currSum + arr[end];
				if (currSum > sum && (end - start + 1) < minLength) {
					minLength = end - start + 1;
				}
			}
		}
		System.out.println(minLength);

		return minLength;

	}

	public int smallestSubArraySum1(int[] arr, int sum) {
		int start = 0;
		int end = 0;

		int length = arr.length;
		int minLength = length + 1;
		int curSum = 0;
		while (end < length) {
			while (curSum <= sum && end < length) {
				curSum = curSum + arr[end++];
				while (curSum > sum) {
					int currentLength = end - start;
					if (currentLength < minLength) {
						minLength = currentLength;
					}
					curSum = curSum - arr[start++];
				}
			}
		}
		System.out.println(minLength);
		return minLength;
	}

	public int smallestSubArraySum(int arr[], int sum) {

		int start = 0;
		int end = 0;
		int length = arr.length;
		int minLength = arr.length + 1;
		int curSum = 0;

		while (end < length) {

			while (curSum <= sum && end < length) {
				curSum = curSum + arr[end++];

				while (curSum > sum) {

					int currentLength = end - start;

					if (currentLength < minLength) {
						minLength = currentLength;
					}

					curSum = curSum - arr[start++];

				}

			}

		}

		System.out.println(minLength);

		return minLength;

	}

	public static void main(String[] args) {

		Test1 obj = new Test1();
		int[] arr = { 1, 3, 4, 5, 7, 8, 40, 34, 56, 20, 1, 3, 1, 1, 1, 1, 1, 1, 1 };
		obj.smallestSubArraySum(arr, 114);
	}

}

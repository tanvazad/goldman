package Q11_LongestFirstReaptingIndexAndItsLength;

public class Test3 {
	public static void main(String[] args) {

		String input = "aabbbbddcddcddcddddddd";
		findLongestRepeatingChar(input);
	}

	private static void findLongestRepeatingChar(String input) {
		
		int count1=0,count2=0,index=-1;
		char a[] = input.toCharArray();
		for(int i=0;i<input.length();i++)
		{
			if(i!=input.length()-1 && a[i]==a[i+1])
				count1++;
			else if(count2<count1)
			{
				index=i;
				count2=count1;
				count1=0;
			}
			else
				count1=0;
		}
		
		System.out.println((index-count2)+" - "+(count2+1));
	}

}

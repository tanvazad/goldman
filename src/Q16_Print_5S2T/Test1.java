package Q16_Print_5S2T;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test1 {

	public static void main(String arg[])
	{
		String s1="SSSSSTTPPQ";
		doLogic(s1);
	}

	private static void doLogic(String s1) {

		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<s1.length();i++)
		{
			if(map.containsKey(s1.charAt(i)))
			{
				map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
			}else
			{
				map.put(s1.charAt(i),1);
			}
		}
		
		for(Character c1 : map.keySet())
		{
			System.out.print(map.get(c1)+""+c1);
		}
	}
}
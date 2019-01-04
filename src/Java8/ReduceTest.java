package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {

	public static void main(String[] args) {
		
		List<Integer> ids = Arrays.asList(1,2,3,4,5);		
		Optional<String> str = ids.stream().
				map(i-> Integer.toString(i)).reduce((String i, String j) -> i + "," + j);	
		System.out.println(str.get());
		
		String[] myArray = { "this", "is", "a", "sentence" };		
		String result = Arrays.stream(myArray)
		                .reduce("", (a,b) -> a + b);
		System.out.println(result);
	}
}
package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class ForEachExample {
	
	public static void main(String[] args) {		
		int x = 0;
		//x += 4;
		
		int[] array = new int[] {1,2,3,4,5};
		
		for (int i : array) {
			//x =556;
			System.out.print(i);
		}
		
		Arrays.stream(array).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				// TODO Auto-generated method stub
				//x =556;
				System.out.println(x);
				System.out.print(value);				
			}			
		});
		
		IntConsumer y = value-> System.out.println(value);;
		Arrays.stream(array).forEach(y);
		
		List<String> names = Arrays.asList("a","b","c");
		List<Employee> names1  = names.stream().map(name -> {
			System.out.println("---- "+ name);
			Employee emp = lookup(name);		
			return emp;
		}).collect(Collectors.toList());
	}
	
	private static Employee lookup(String name) {
		return new Employee();
	}
	private static class Employee {
		private int id;
		private String name;
	}
}

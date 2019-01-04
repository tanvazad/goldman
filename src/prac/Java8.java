package prac;

import java.util.HashMap;
import java.util.Map;

public class Java8 {
	
	public static void main(String args[]){
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,12);
        hashMap.put(2,11);
        hashMap.put(9,10);
        hashMap.put(11,19);
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .limit(10);

    }
}

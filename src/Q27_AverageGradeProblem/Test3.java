package Q27_AverageGradeProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test3 {

	public static void averageProblem(String arr[][]) {

		Map<String, List<Float>> map = new HashMap<String, List<Float>>();
		TreeMap<Float, String> m = new TreeMap<Float, String>();
		List<Float> lst = null;

		for (String[] outerArr : arr) {

			String key = outerArr[0];
			Float value = Float.parseFloat(outerArr[1]);

			if (!map.containsKey(key)) {
				lst = new LinkedList<Float>();
			} else {
				lst = map.get(key);
			}
			lst.add(value);
			map.put(key, lst);
		}
		System.out.println("Map >>>" + map);

		for (String key : map.keySet()) {

			List<Float> lst1 = map.get(key);
			int count = lst1.size();

			float sum = 0;

			for (Float key2 : lst1) {
				sum = sum + key2;
			}

			float value = sum / count;
			m.put(value, key);

		}
		System.out.println("Tree Map  >>>" + m);
		System.out.println(" Best Average Grade >>>>>" + m.lastKey());

	}

	public static void main(String[] args) {

		String[][] arr = { { "sobby", "87.08" }, { "arush", "37" }, { "charles", "22" }, { "tony", "20" },
				{ "tony", "20" }, { "tony", "250" } };
		Test3.averageProblem(arr);

	}

}

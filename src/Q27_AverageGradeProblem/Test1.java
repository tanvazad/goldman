package Q27_AverageGradeProblem;


import java.util.HashMap;
import java.util.Map;

public class Test1 {

	static class Grade {
		int count;
		int totalGrade;

		public int getTotalGrade() {
			return totalGrade;
		}

		public void setTotalGrade(int totalGrade) {
			this.totalGrade = totalGrade;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}		
		
	}

	public static void main(String[] args) {

		String[][] s = { { "sobby", "87" }, { "arush", "37" }, { "charles", "22" }, { "tony", "20" },
				{ "tony", "20" }, { "tony", "250" } };
		Map<String, Grade> map = new HashMap<>();
		for (int i = 0; i < s.length; i++) {
			String name = s[i][0];
			int fGrade = Integer.parseInt(s[i][1]);
			if (map.containsKey(name)) {
				Grade grade = map.get(name);				
				grade.setCount(grade.getCount() + 1);
				grade.setTotalGrade(grade.getTotalGrade() + fGrade);
				map.put(name, grade);
			} else {
				Grade grade = new Grade();
				grade.setCount(1);
				grade.setTotalGrade(fGrade);
				map.put(name, grade);
			}
		}

		float bestGrade = 0;
		String name = "";
		for (Map.Entry<String, Grade> entry : map.entrySet()) {
			Grade v = entry.getValue();
			int count = v.getCount();
			float totalGrade = v.getTotalGrade();
			float average = totalGrade / count;
			if (bestGrade < average) {
				bestGrade = average;
				name = entry.getKey();
			}
		}
		System.out.println(name + " has the best grade:" + Math.floor(bestGrade));

	}

}

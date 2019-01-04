package Q24_NewtonRaphsonSquareRoot;

public class Test1 {

	public static void main(String[] args) {
		float sqroot = 0;
		float f = 18;
		float temp = f / 2;
		while (true) {
			sqroot = temp - ((temp * temp - f) / (2 * temp));
			float absValue = Math.abs(sqroot - temp);
			if (absValue < .0001) {
				System.out.println("sqroot:" + sqroot);
				break;
			} else {
				temp = sqroot;
			}
		}
	} 
}
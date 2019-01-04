package Q31_WalkingRobot;


/* Problem statement
 Given a robot which can only move in four directions, UP(U), DOWN(D), LEFT(L), RIGHT(R). Given a string consisting of instructions to move.
  Output the co-ordinates of robot after the executing the instructions. Initial position of robot is at origin(0, 0).

Examples:

Input : move = "UDDLRL" 
Output : (-1, -1)
Move U : (0, 0)--(0, 1)
Move D : (0, 1)--(0, 0)
Move D : (0, 0)--(0, -1)
Move L : (0, -1)--(-1, -1)
Move R : (-1, -1)--(0, -1)
Move L : (0, -1)--(-1, -1)

Therefore final position after the complete
movement is: (-1, -1)

Input : move = "UDDLLRUUUDUURUDDUULLDRRRR"
Output : (2, 3) 
 *  */



public class Test2 {
		public static void main(String[] args) {
			String move = "UDDLLRUUUDUURUDDUULLDRRRR";
		    finalPosition(move);
		}
		
		static void finalPosition(String move) {
			 int l = move.length();
			 char[] moveArrray = move.toCharArray();
			 int countUp = 0, countDown = 0, countLeft = 0, countRight = 0;
			 
			    // traverse the instruction string 'move'
			    for (int i = 0; i < l; i++) {
			 
			        // for each movement increment its
			        // respective counter
			        if (moveArrray[i] == 'U')
			            countUp++;
			        else if (moveArrray[i] == 'D')
			            countDown++;
			        else if (moveArrray[i] == 'L')
			            countLeft++;
			        else if (moveArrray[i] == 'R')
			            countRight++;
			    }
			    
			    System.out.println("Final Position: (" + (countRight - countLeft) +","+ (countUp - countDown)+")");
		}
}

package practise.ds.tree.treeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeftTopRightView {

	static int max_level = 0;

	public static void main(String args[]){

		BinaryTree tree = new BinaryTree();
		// create root
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node( 3);
		tree.root.left.left = new Node( 4);
		tree.root.right.left = new Node( 6);
		tree.root.right.right = new Node( 7);
		tree.root.right.left.left = new Node( 9);

		System.out.println("Elements from left view:");
		leftElement(tree.root,1);//o(n) time complexity
		System.out.println();
		System.out.println("Elements from left view in iterative way:");
		printLeftView(tree.root);
		System.out.println();
		System.out.println("Elements from right view in iterative way:");
		printRightView(tree.root);

	}


	private static  void leftElement(Node root, int level) {


		if(root==null) return;
		// If this is the first node of its level
		if (max_level < level)
		{
			System.out.print(" " + root.key);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftElement(root.left, level+1);
		// System.out.println(level);
		leftElement(root.right, level+1);

	}

	private static  void printLeftView(Node root) {

		if (root == null)
			return;

		Queue<Node> st = new LinkedList<>();
		st.add(root);

		while (!st.isEmpty()) 
		{   
			// number of nodes at current level
			int n = st.size();

			// Traverse all nodes of current level 
			for (int i = 1; i <= n; i++) {
				Node temp = st.poll();

				// Print the right most element at 
				// the level
				if (i == 1)
					System.out.print(temp.key + " ");

				// Add left node to queue
				if (temp.left != null)
					st.add(temp.left);

				// Add right node to queue
				if (temp.right != null)
					st.add(temp.right);
			}
		}

	}

	private static void printRightView(Node root) 
	{
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) 
		{   
			// number of nodes at current level
			int n = queue.size();

			// Traverse all nodes of current level 
			for (int i = 1; i <= n; i++) {
				Node temp = queue.poll();

				// Print the right most element at 
				// the level
				if (i == n)
					System.out.print(temp.key + " ");

				// Add left node to queue
				if (temp.left != null)
					queue.add(temp.left);

				// Add right node to queue
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
	}
}

/*
 * 			1
 * 		2       3
 *    4       6    7 
 *    		9
 */

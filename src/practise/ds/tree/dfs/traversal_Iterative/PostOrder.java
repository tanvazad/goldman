package practise.ds.tree.dfs.traversal_Iterative;

import java.util.Stack;

/**
 * Created by AZADTANN on 4/9/2018.
 */
public class PostOrder {
    Stack<Node> nodeStack = new Stack<Node>();
    Stack<Node> nodeStack2 = new Stack<Node>();
    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();
        // create root
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node( 3);
        tree.root.left.left = new Node( 4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right=new Node(11);
        tree.root.left.left.left= new Node(8);
        tree.root.right.left = new Node( 6);
        tree.root.right.right = new Node( 7);
        tree.root.right.left.right = new Node( 9);

        System.out.println("\nPost-order traversal of binary tree is ");
        PostOrder postOrder = new PostOrder();
        postOrder.printPostorder(tree.root);


    } 
    void printPostorder(Node node) {
        // Create two stacks

        if(node == null)return;
        // push root to first stack
        nodeStack.push(node);

        // Run while first stack is not empty
        while (!nodeStack.isEmpty())
        {
            // Pop an item from s1 and push it to s2
            Node temp = nodeStack.pop();
            nodeStack2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                nodeStack.push(temp.left);
            if (temp.right != null)
                nodeStack.push(temp.right);
        }

        // Print all elements of second stack
        while (!nodeStack2.isEmpty())
        {
            Node temp = nodeStack2.pop();
            System.out.print(temp.key + " ");
        }

    }
}

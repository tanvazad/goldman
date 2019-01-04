package practise.ds.tree.dfs.traversal_Iterative;

import java.util.Stack;

public class InOrder {

    Stack<Node> nodeStack = new Stack<Node>();
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

        System.out.println("\nInorder traversal of binary tree is ");

        InOrder inOrder = new InOrder();
        inOrder.printInorder(tree.root);

    }

    void printInorder(Node node) {
        if(node == null)return;

        //first node to be visited will be the left one
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
        // traverse the tree
        while (nodeStack.size() > 0) {
            // visit the top node
            node = nodeStack.pop();
            System.out.print(node.key + " ");
            if (node.right != null) {
                node = node.right;

                // the next node to be visited is the leftmost
                while (node != null) {
                    nodeStack.push(node);
                    node = node.left;
                }
            }
        }
    }

}

package practise.ds.tree.dfs.traversal_Recurssive;


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
        //left subtree
        printInorder(node.left);
        //now deal with the node
        System.out.print(node.key+" ");
        //right subtree
        printInorder(node.right);

    }
}

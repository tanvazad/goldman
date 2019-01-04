package practise.ds.tree.dfs.traversal_Recurssive;

import java.util.Stack;

/**
 * Created by AZADTANN on 4/9/2018.
 */
public class PostOrder {

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

        PostOrder postOrder = new PostOrder();
        postOrder.printPostorder(tree.root);


    }

    // print in different traversal order
    void printPostorder(Node node) {
        if(node == null)return;
        //left subtree
        printPostorder(node.left);
        //right subtree
        printPostorder(node.right);
        //now deal with the node
        System.out.print(node.key+" ");

    }
}

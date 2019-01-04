package practise.ds.tree.bfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BTreeRightShibling {


    static class Node {
        int data;
        Node left, right, parent;

        public Node(int data, Node parent) {
            this.data = data;
            left = null;
            right = null;
            this.parent = parent;
        }
    }

    // Method to find right sibling
    static void findRightSibling(Node node, int data)
    {
        int dummy=Integer.MAX_VALUE;
        Queue<Integer>  q = new LinkedBlockingQueue<Integer>();
      /*  q.add(node.data);
        q.add(dummy);*/
        while( node.right!=null)  {
            node = node.right;
            q.add(node.data);
        }
    }

    // Driver Program to test above functions
    public static void main(String args[])
    {
        Node root = new Node(1, null);
        root.left = new Node(2, root);
        root.right = new Node(3, root);
        root.left.left = new Node(4, root.left);
        root.left.right = new Node(6, root.left);
        root.left.left.left = new Node(7, root.left.left);
        root.left.left.left.left = new Node(10, root.left.left.left);
        root.left.right.right = new Node(9, root.left.right);
        root.right.right = new Node(5, root.right);
        root.right.right.right = new Node(8, root.right.right);
        root.right.right.right.right = new Node(12, root.right.right.right);

        // passing 10
      findRightSibling(root.left.left.left, 0);
    }
}
    /*
                    1
                 2     3
               4   6      5
             7       9      8
          10                   12

     */
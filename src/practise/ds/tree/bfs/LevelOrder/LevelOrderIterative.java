package practise.ds.tree.bfs.LevelOrder;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LevelOrderIterative {

    Queue<Node> q = new LinkedBlockingQueue<Node>();
    public static void main(String args[]){

        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        LevelOrderIterative tree1=new LevelOrderIterative();
        tree1.printLevelOrderIterative(tree.root);
    }
    //iterative in BFS
    public void printLevelOrderIterative(Node root) {
        if (root == null)
            return;
        else
            q.offer(root);//or q.add(root.data)
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp != null) {
                System.out.print(" " + temp.data);
            }
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
    }
}
/*
          1
       2    3
      4  5   *
 */
package practise.ds.tree.bfs.LevelOrder;



class Node {
    Node left, right;
    int data;

    public Node(int data) {
        left = right = null;
        this.data = data;
    }

}

public class BinaryTree {

    //Root of Binary tree
    Node root;

    public BinaryTree() {
        root = null;
    }
}
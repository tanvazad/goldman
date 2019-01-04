package practise.ds.tree.bfs.LevelOrder;


public class BFSLevelOrderRecursive {

    //print level order traversal of Binary tree
    void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }
    //DFS  print Level Order
    private void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.data + " ");

        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    //DFS height
    private int height(Node root) {
        if (root == null)
            return 0;
        else 
        	return Math.max(height(root.left), height(root.right)) + 1; 
    }

    public static void main(String args[]){

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        BFSLevelOrderRecursive tree1 = new BFSLevelOrderRecursive();
        tree1.printLevelOrder(tree.root);
    }
}

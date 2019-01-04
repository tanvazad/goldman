package practise.ds.tree.treeProblems;


public class FindRootElementsWith2Child {

    public static void main(String args[]){

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

        System.out.println("Elements with two childs:");

        checkElement(tree.root);
    }

    private static void checkElement(Node root) {

        if(root.left!=null && root.right!=null){
            System.out.print(" "+root.key);
            checkElement(root.left);
            checkElement(root.right);
        }
    }
    private static void checkElementIterative(Node root) {

        /*if(root.left!=null && root.right!=null){
            System.out.print(" "+root.key);
            checkElement(root.left);
            checkElement(root.right);
        }*/
    }
}
/*
                 1
              2     3
             4 5   6  7
            8   11 9
 */
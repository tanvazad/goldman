package practise.ds.tree.treeProblems;


public class PrintSiblingOrNot {

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

        System.out.println("Elements which are siblings:");
        checkSibling(tree.root);
        System.out.println("Elements which are not siblings:");
        checkNotSibling(tree.root);
    }

    private static void checkSibling(Node root) {

        if(root.left!=null && root.right!=null){
            System.out.print(" "+root.left.key+","+root.right.key);
            checkSibling(root.left);
            checkSibling(root.right);
        }


    }
    private static void checkNotSibling(Node root) {

        if(root==null)return;
        if((root.left!=null && root.right==null)){
            System.out.print(" "+root.left.key);
        }
        if(root.right!=null && root.left==null){
            System.out.print(" "+root.right.key);

        }
        checkNotSibling(root.left);
        checkNotSibling(root.right);

    }
}

/*
                 1
              2     3
             4 5   6  7
            8   11 9
 */

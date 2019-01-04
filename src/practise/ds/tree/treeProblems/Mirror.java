package practise.ds.tree.treeProblems;

/**
 * Created by AZADTANN on 4/9/2018.
 */
public class Mirror {

    public static void main(String args[]){

        BinaryTree tree = new BinaryTree();
        // create root
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node( 3);
        tree.root.left.left = new Node( 4);
        tree.root.left.right = new Node(5);

        BinaryTree tree1 = new BinaryTree();
        // create root
        tree1.root = new Node(1);
        tree1.root.left = new Node(3);
        tree1.root.right = new Node( 2);
        tree1.root.left.left = new Node( 5);
        tree1.root.left.right = new Node(4);

        System.out.println("Elements which are mirror:"+checkMirror(tree.root,tree1.root));

    }

    private static boolean checkMirror(Node r1, Node r2) {

        if(r1!=null && r2!=null){
            return (r1.left ==r2.right) && (r2.left==r1.left);
        }
        if((r1==null && r2!=null)|| r2==null && r1!=null){
            return false;
        }
        return false;
    }
}

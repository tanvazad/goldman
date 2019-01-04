package practise.ds.tree.treeProblems;

class Node
{
    int key;

    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {

    Node root;
    public BinaryTree(int key)
    {
        root = new Node(key);
    }

    public BinaryTree()
    {
        root = null;
    }


}


/*
         1
       2     3
     4  5   6  7
    8   11   9
 */

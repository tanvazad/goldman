package practise.ds.LinkedList;

public class TreeNode {

  private TreeNode leftChild;
  private TreeNode rightChild;
  private int data;
  private TreeNode parent;
  private TreeNode neighbour;
 

 
  public TreeNode getNeighbour() {
    return neighbour;
  }

  public void setNeighbour(TreeNode neighbour) {
    this.neighbour = neighbour;
  }

  public TreeNode getParent() {
    return parent;
  }

  public void setParent(TreeNode parent) {
    this.parent = parent;
  }

  public TreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(TreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public TreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(TreeNode rightChild) {
    this.rightChild = rightChild;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}

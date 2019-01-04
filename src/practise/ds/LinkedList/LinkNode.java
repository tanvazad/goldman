package practise.ds.LinkedList;

public class LinkNode {

  private int data;
  
  public LinkNode() {
    // TODO Auto-generated constructor stub
  }

  public LinkNode(int x) {
    this.data = x;
    next = null;
  }


  public LinkNode getNext() {
    return next;
  }

  public void setNext(LinkNode next) {
    this.next = next;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  private LinkNode next;
}

package practise.ds.LinkedList;

public class Node {

	int data;
	Node next, back;	// For LinkedList
	Node left, right;	// For Tree
	Node()
	{
		this.data=0;
		
		this.next = null;
		this.back = null;
		
		this.left = null;
		this.right= null;
		
	}
	
	Node(int data)
	{
		this.data = data;
		
		this.next = null;
		this.back = null;
		
		this.left = null;
		this.right= null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getBack() {
		return back;
	}

	public void setBack(Node back) {
		this.back = back;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

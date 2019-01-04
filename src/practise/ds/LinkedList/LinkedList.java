package practise.ds.LinkedList;


public class LinkedList {
	
	private Node head, curr;

	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getCurrent() {
		return curr;
	}

	public void setCurrent(Node curr) {
		this.curr = curr;
	}

	public void add(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = curr = temp;
		} else {
			curr.next = temp;
			curr = temp;
		}
	}

	public void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int size(Node head)
	{
		Node temp = head;
		int count=0;
		while(temp!=null)
		{
			temp = temp.next;
			count++;
		}
		return count;
	}

	void delete(int key) {

		Node temp = head, prev=null;

		//head case
		if(temp!=null && temp.data==key){
			head=temp.next;
			return;
		}
		//search for key to be deleted
		while(temp!=null && temp.data!=key){
			prev = temp;
			temp=temp.next;
		}
		if(temp == null) return;

		prev.next=temp.next;

	}
}

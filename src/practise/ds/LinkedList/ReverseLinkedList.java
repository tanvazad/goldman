package practise.ds.LinkedList;

class Reverse {

	public static Node reverseUsingIterative(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	
	 static Node head;
	 public static Node reverseUsingRecursion(Node curr, Node prev) {
		 
	        if (curr.next == null) {
	            head = curr;
	            curr.next = prev;
	            return null;
	        }
	        Node temp = curr.next; 
	        curr.next = prev;
	        reverseUsingRecursion(temp, curr);
	        return head;
	    }
	 
}

public class ReverseLinkedList {

	public static void main(String arg[]) {
		LinkedList list = new LinkedList();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);

		list.display(list.getHead());
		
//		Node node1 = list.reverseUseingIterative(list.head);
//		list.display(node1);
		
		Node node2 = Reverse.reverseUsingRecursion(list.getHead(),null);
		list.display(node2);
	}
}

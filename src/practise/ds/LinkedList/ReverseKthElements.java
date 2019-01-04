package practise.ds.LinkedList;

class ReverseKth {
	public static Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null)
			head.next = reverse(next, k);
		return prev;
	}
}

public class ReverseKthElements {

	public static void main(String arg[]) {
		LinkedList list = new LinkedList();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		list.add(600);
		list.add(700);
		list.add(800);
		list.add(900);
		list.add(1000);

		list.display(list.getHead());
		Node head = ReverseKth.reverse(list.getHead(), 3);

		list.display(head);
	}

}

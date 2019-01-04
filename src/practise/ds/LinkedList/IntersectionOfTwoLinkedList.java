package practise.ds.LinkedList;

class Intersection {

	public static int getNode(Node head1, Node head2) {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		int d;

		if (c1 > c2) {
			d = c1 - c2;
			return intesectionNode(d, head1, head2);
		} else {
			d = c2 - c1;
			return intesectionNode(d, head2, head1);
		}
	}

	static int getCount(Node node) {
		Node current = node;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	public static int intesectionNode(int d, Node node1, Node node2) {
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for (i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}
}

public class IntersectionOfTwoLinkedList {

	public static void main(String arg[])
	{
		LinkedList list1 = new LinkedList();
		list1.add(100);
		list1.add(200);
		list1.add(300);
		list1.add(400);
		list1.add(500);
		list1.add(600);
		list1.add(700);
		list1.add(800);
		list1.add(900);
		list1.add(1000);
		
		LinkedList list2 = new LinkedList();
		list2.add(11);
		list2.add(22);
		list2.add(33);
		list2.add(44);
		list2.setCurrent(list1.getHead().getNext().getNext().getNext());
		
		
		System.out.println(Intersection.getNode(list1.getHead(), list2.getHead()));
		
	}
}

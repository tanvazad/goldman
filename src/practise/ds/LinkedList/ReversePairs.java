package practise.ds.LinkedList;

class Pairs
{
	public static Node pairWiseSwap(Node head)
    {
        Node temp = head;
 
        while (temp != null && temp.next != null) {
 
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
		}
        
        return head;
    }
}
public class ReversePairs {
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
		Node head = Pairs.pairWiseSwap(list.getHead());

		list.display(head);
	}
}

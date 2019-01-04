package practise.ds.LinkedList;

class LastNthElement
{
	public static int lastKthElement1(Node head, int k)
	{
		Node slow = head;
		Node fast = head;
		int count = 0;
		while(fast!=null)
		{
			if(count<k)
			{
				fast = fast.next;
			}
			else
			{
				slow=slow.next;
				fast=fast.next;
			}
			count++;
		}
		return slow.data;
	}
	
	public static int lastKthElement2(Node head, int k)
	{
		int size = new LinkedList().size(head)-k;
		int count=0;
		while(count<size)
		{
			head = head.next;
			count++;
		}
		return head.data;
	}
}
public class FindKthLastElementFromLinkedList {

	public static void main(String arg[])
	{
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
		
		int data1 = LastNthElement.lastKthElement1(list.getHead(), 3);
		
		int data2 = LastNthElement.lastKthElement2(list.getHead(), 5);
		
		System.out.println(data1);
		System.out.println(data2);
	}
}

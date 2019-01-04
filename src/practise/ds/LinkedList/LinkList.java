package practise.ds.LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class LinkList {

	private static final int Comparator = 0;
	private LinkNode head;

	// Print nth node from n in a link list using recursion

	// public static void printNthNodeFromEnd(LinkNode hdPtr, int n) {
	// // static int i = 0;
	// // if (hdPtr == null)
	// // return;
	// // printNthNodeFromEnd(hdPtr.getNext(), n);
	// // if (++i == n)
	// // System.out.println(hdPtr.getData());
	// // // System.out.println();
	// // }

	// Merge two sorted list so that the resultant list is in descending order

	public static LinkNode partition(LinkNode head, int x) {
		LinkNode dummy1 = new LinkNode(-1);
		LinkNode dummy2 = new LinkNode(-1);
		LinkNode p1 = dummy1;
		LinkNode p2 = dummy2;
		while (head != null) {
			if (head.getData() < x) {
				p1.setNext(head);
				p1 = head;

			} else {
				p2.setNext(head);
				p2 = head;

			}
			head = head.getNext();
		}
		p2.setNext(null);
		p1.setNext(dummy2.getNext());
		return dummy1.getNext();
	}

	public void segerateOddEven(LinkNode ptr) {
		LinkNode start = null;
		start = ptr;
		while (start != null) {
			if (start.getData() % 2 == 0) {
				start.setNext(null);
				start = addNode(start);
			}

			start = start.getNext();
		}
	}

	public LinkNode addNode(LinkNode ptr) {
		LinkNode p = new LinkNode(0);
		p.setData(ptr.getData());
		p.setNext(ptr);
		ptr = p;
		return ptr;
	}

	// Using Priority Queues
	public LinkNode mergeKSortedListsQueues(LinkList[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		LinkNode dummy = new LinkNode(-1);
		LinkNode curr = dummy;

		Queue<LinkNode> q = new PriorityQueue<LinkNode>(lists.length, new Comparator<LinkNode>() {
			@Override
			public int compare(LinkNode l1, LinkNode l2) {
				assert l1 != null && l2 != null;
				return l1.getData() - l2.getData();
			}
		});

		for (LinkList list : lists) {
			q.offer(list.getHead());
		}

		while (!q.isEmpty()) {
			LinkNode node = q.remove();
			curr.setNext(node);
			curr = node;
			if (node != null) {
				q.offer(node);
			}
		}

		return dummy.getNext();

	}

	public LinkNode mergeSortedListsRecursive(LinkNode l1, LinkNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		LinkNode mergeHead;
		if (l1.getData() < l2.getData()) {
			mergeHead = l1;
			mergeHead.setNext(mergeSortedListsRecursive(l1.getNext(), l2));
		} else {
			mergeHead = l2;
			mergeHead.setNext(mergeSortedListsRecursive(l1, l2.getNext()));
		}
		return mergeHead;
	}

	public LinkNode mergeKSortedLists(LinkList[] lists) {
		return partition(lists, 0, lists.length - 1);
	}

	private LinkNode partition(LinkList[] lists, int start, int end) {
		if (start == end)
			return lists[start].getHead();
		if (start < end) {
			int q = (start + end) / 2;
			LinkNode l1 = partition(lists, start, q);
			LinkNode l2 = partition(lists, q + 1, end);
			return mergeSortedListsRecursive(l1, l2);
		} else
			return null;
	}

	public LinkNode mergeSortedLists(LinkNode n1, LinkNode n2) {

		if (n1 == null && n2 == null)
			return null;

		LinkNode resNode = null;

		while (n1 != null && n2 != null) {
			if (n1.getData() <= n2.getData()) {
				LinkNode temp = n1.getNext();
				n1.setNext(resNode);
				resNode = n1;
				n1 = temp;
			} else {
				LinkNode temp = n2.getNext();
				n2.setNext(resNode);
				resNode = n2;
				n2 = temp;
			}
		}

		while (n1 != null) {
			LinkNode temp = n1.getNext();
			n1.setNext(resNode);
			resNode = n1;
			n1 = temp;
		}

		while (n2 != null) {
			LinkNode temp = n2.getNext();
			n2.setNext(resNode);
			resNode = n2;
			n2 = temp;
		}
		System.out.println();
		return resNode;
	}

	public void addNode(int x) {
		LinkNode temp = new LinkNode();
		temp.setData(x);
		temp.setNext(head);
		head = temp;
		// return temp;
	}

	public void displayList(LinkNode head) {
		LinkNode headPtr = head;
		while (headPtr != null) {
			System.out.print(headPtr.getData() + "  ");
			headPtr = headPtr.getNext();
		}
		System.out.println();
	}

	public LinkNode reverseList() {
		LinkNode curr = null;
		LinkNode nextPtr = null;
		LinkNode prev = null;
		curr = head;
		while (curr != null) {
			nextPtr = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = nextPtr;
		}
		System.out.println();
		return prev;
	}

	public void reverseList2() {
		LinkNode curr = null;
		LinkNode nextPtr = head;
		LinkNode prev = null;

		while (nextPtr != null) {
			curr = nextPtr;
			nextPtr = curr.getNext();
			curr.setNext(prev);
			prev = curr;
		}
		head = curr;
		System.out.println();
	}

	// Reverse K block of Node in a linked list

	public LinkNode reverseKBlocks(LinkNode head, int k) {
		LinkNode currNode = head;
		LinkNode nextNode = null;
		LinkNode prevNode = null;
		int cnt = 0;
		// Reverse the first k nodes of the list
		while (cnt < k && currNode != null) {
			nextNode = currNode.getNext();
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = nextNode;
			cnt++;
		}
		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (nextNode != null)
			head.setNext(reverseKBlocks(nextNode, k));
		// prev is now head of input list
		return prevNode;
	}

	// Reverse List in pairs

	public void reverseListInPairs(LinkNode headPtr) {
		LinkNode curr = headPtr, temp = null, temp2 = null;
		if (curr != null && curr.getNext() != null) {
			temp = curr.getNext();
			temp2 = temp.getNext();
			temp.setNext(curr);
			curr.setNext(temp2);
			if (curr != null)
				curr = curr.getNext();
		}

	}

	// Find the nth node from the end O(n)
	public void nthNodeFromEnd(int n) {
		int count = 0;
		LinkNode node1 = head;
		LinkNode node2 = head;
		if (node1 != null) {
			while (count < n) {
				if (node1 == null) {
					System.out.println(n + ",is grater than the no of Nodes in the list.");
					return;
				} else {
					node1 = node1.getNext();
					count++;
				}
			}
			while (node1 != null) {
				node1 = node1.getNext();
				node2 = node2.getNext();
			}
			System.out.println("Node no:" + n + ",from end;" + node2.getData());
		}
	}

	// Reverse every alternate K nodes of a link List

	public LinkNode reverseKAlternateNodes(LinkNode headptr, int k) {
		int listLen = 0;
		while (headptr != null) {
			listLen++;
			headptr = headptr.getNext();
		}

		for (int i = 0; i < listLen; i++) {
			if (i == k) {
				headptr = reverseKAlternateNodes(headptr, k);
			}
		}
		return headptr;
	}

	// Seperate odd and even in lists

	public LinkNode seperateOddEven(LinkNode headptr) {
		if (headptr == null)
			return null;
		LinkNode odd = headptr;
		LinkNode even = headptr.getNext();
		LinkNode evenHead = even;
		while (even != null && even.getNext() != null) {
			odd.setNext(even.getNext());
			odd = odd.getNext();
			even.setNext(odd.getNext());
			even = even.getNext();
		}
		odd.setNext(evenHead);

		return headptr;

	}

	public static void linkedDelete(LinkNode headPtr, int m, int n) {
		if (headPtr == null)
			return;
		LinkNode p = headPtr;
		LinkNode q = headPtr;

		for (int i = 0; i < m; i++) {
			p = p.getNext();
			q = q.getNext();
		}
		for (int i = 0; i < n; i++) {
			if (q != null)
				q = q.getNext();
		}
		if (p != null)
			p.setNext(q);
	}

	// public static LinkNode addTwoLists(LinkNode L1, LinkNode L2) {
	// LinkNode dummyHead = new LinkNode(0);
	// LinkNode p = L1;
	// LinkNode q = L2;
	// LinkNode curr = dummyHead;
	// int carry = 0;
	//
	// while (p != null || q != null) {
	// int x = p != null ? p.getData() : 0;
	// int y = p != null ? q.getData() : 0;
	//
	// int sum = carry + x + y;
	// carry = sum / 10;
	//
	// curr.setNext(new LinkList().addNode(sum % 10));
	// curr = curr.getNext();
	// if (p != null)
	// p = p.getNext();
	// if (q != null)
	// q = q.getNext();
	// }
	// if (carry > 0)
	// curr.setNext(new LinkList().addNode(carry));
	// return dummyHead.getNext();
	//
	// }

	public void removeNode(LinkNode p, int x) {
		LinkNode prev = null;
		while (p != null) {
			if (p.getData() == x)
				break;
			prev = p;
			p = p.getNext();
		}
		if (prev == null) {
			prev = head;
			head = head.getNext();
		} else {
			prev.setNext(p.getNext());
			prev = null;
		}
	}

	public LinkNode swapPairs(LinkNode head) {
		if (head == null)
			return head;

		LinkNode dummy = new LinkNode(12);
		dummy.setNext(head);
		LinkNode slow = head, fast = head.getNext(), prev = dummy;

		while (fast != null) {
			slow.setNext(fast.getNext());
			fast.setNext(slow);
			prev.setNext(fast);
			prev = slow;
			slow = slow.getNext();
			if (slow != null)
				fast = slow.getNext();
			else
				break;
		}

		return dummy.getNext();
	}

	public boolean isPalindrome(LinkNode headPtr) {
		boolean res = true;
		LinkNode p = headPtr;
		LinkNode q = headPtr;
		Stack<Integer> stack = new Stack<>();
		while (p != null) {
			stack.push(p.getData());
			p = p.getNext();
		}
		while (q != null && !stack.isEmpty()) {
			if (stack.pop().intValue() != q.getData()) {
				res = false;
				break;
			}
			q = q.getNext();
		}
		return res;
	}

	public boolean isPalindrome2(LinkNode headPtr) {
		LinkNode fast = null;
		LinkNode slow = null;
		fast = headPtr;
		slow = headPtr;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		if (fast != null)
			slow = slow.getNext();
		slow = reverse(slow);
		fast = headPtr;
		while (slow != null) {
			if (fast.getData() != slow.getData())
				return false;
			fast = fast.getNext();
			slow = slow.getNext();
		}
		return true;
	}

	public void reverseRecur(LinkNode ptr) {
		if (ptr.getNext() == null) {
			head = ptr;
			return;
		}
		reverseRecur(ptr.getNext());
		LinkNode q = ptr.getNext();
		q.setNext(ptr);
		ptr.setNext(null);
	}

	private LinkNode reverse(LinkNode head) {
		LinkNode prev = null;
		while (head != null) {
			LinkNode next = head.getNext();
			head.setNext(prev);
			prev = head;
			head = next;
		}
		return prev;
	}

	public void removeDuplicates(LinkNode head) {
		LinkNode current = head;
		LinkNode prev = null;
		Set<Integer> set = new HashSet<>();
		while (current != null) {
			if (set.contains(current.getData())) {
				prev.setNext(current.getNext());
			} else {
				set.add(current.getData());
				prev = current;
			}
			current = current.getNext();
		}

	}

	LinkNode removeDuplicatesSortedList(LinkNode head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		LinkNode curr = head;
		LinkNode nextPtr = null;

		if (head == null)
			return null;

		while (curr.getNext() != null) {
			if (curr.getData() == curr.getNext().getData()) {
				nextPtr = curr.getNext().getNext();
				curr.setNext(null);
				curr.setNext(nextPtr);
			} else
				curr = curr.getNext();
		}
		return curr;
	}

	LinkNode delteAtPosition(LinkNode head, int position) {
		if (head == null) {
			return null;
		} else if (position == 0) {
			return head.getNext();
		} else {
			/* Get Node one element before desired position */
			LinkNode n = head;
			for (int i = 0; i < position - 1; i++) {
				n = n.getNext();
			}
			/* Delete Node */
			n.setNext(n.getNext().getNext());

			return head;
		}
	}

	public static void main(String[] args) {
		List<LinkList> lists = new ArrayList<>();
		LinkList L = new LinkList();
		L.addNode(2);
		L.addNode(3);
		L.addNode(4);
		L.addNode(5);
		L.displayList(L.head);
		
		L.reverseRecur(L.head);
		L.displayList(L.head);

//		LinkList L1 = new LinkList();
//		L1.addNode(10);
//		L1.addNode(20);
//		L1.addNode(30);
//		L1.addNode(40);
//		L1.addNode(50);
//
//		LinkList L2 = new LinkList();
//		L2.addNode(100);
//		L2.addNode(200);
//		L2.addNode(300);
//		L2.addNode(400);
//		L2.addNode(500);
//
//		LinkList[] res = new LinkList[3];
//		res[0] = L;
//		res[1] = L1;
//		res[2] = L2;
//
//		L.displayList(L.mergeKSortedLists(res));

		// L.mergeKSortedLists(res).getData()
		//
		// lists.add(L);
		// lists.add(L1);
		// lists.add(L2);
		//
		// for(LinkList l:lists){
		// l.displayList(l.getHead());
		// }

	}

	public LinkNode getHead() {
		return head;
	}

	public void setHead(LinkNode head) {
		this.head = head;
	}

}

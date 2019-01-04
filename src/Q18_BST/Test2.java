package Q18_BST;

public class Test2 {

	public static void main(String[] args) {
		BST2 b = new BST2();
		b.add(1);
		b.add(4);
		b.add(11);
		b.add(13);
		b.add(15);
		b.add(17);
		b.add(11);
		b.add(14);
		b.display();
		System.out.println("BST contains " + b.contains(11));
	}
}



class BST2 {
	
	class Node2 {
		int data;
		Node2 left, right;

		Node2(int data) {
			this.data = data;
		}
	}
	
	private Node2 root;

	public void add(int data) {
		root = add(root, data);
	}

	private Node2 add(Node2 node, int data) {
		if (node == null) {
			node = new Node2(data);
		}
		if (node.data > data) {
			node.left = add(node.left, data);
		} else if (node.data < data) {
			node.right = add(node.right, data);
		}
		return node;
	}

	public void display() {
		inorder(root);
	}

	private void inorder(Node2 node) {

		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.data + " ");
		inorder(node.right);

	}

	public boolean contains(int data) {
		return contains(root, data);
	}

	public boolean contains(Node2 node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		if (node.data > data) {
			return contains(node.left, data);
		} else if (node.data < data) {
			return contains(node.right, data);
		}
		return false;
	}
}

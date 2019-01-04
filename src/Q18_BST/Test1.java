package Q18_BST;

public class Test1 {

	public static void main(String[] args) {
		BST b = new BST();
		b.add(1);
		b.add(4);
		b.add(11);
		b.add(13);
		b.add(15);
		b.add(17);
		b.add(11);
		b.add(14);
		b.display();
		System.out.println("BST contains " + b.contains(111));
	}
}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
	}
}

class BST {
	private Node root;

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			node = new Node(data);
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

	private void inorder(Node node) {

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

	public boolean contains(Node node, int data) {
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

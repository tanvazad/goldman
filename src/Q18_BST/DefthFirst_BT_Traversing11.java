package Q18_BST;

class NodeDemo11
{
	private class Node
	{
		int data;
		Node right, left;
	}

	Node root;

	public void insert(int data)
	{
		root = insert(root, data);
	}

	private Node insert(Node node, int data)
	{
		if (node == null)
		{
			node = new Node();
			node.data = data;
		}
		else
		{
			if (data <= node.data)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	public void preorder()
	{
		preorder(root);
	}

	private void preorder(Node node)
	{
		if (node != null)
		{
			System.out.print("  " + node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void inorder()
	{
		inorder(root);
	}

	private void inorder(Node node)
	{
		if (node != null)
		{
			inorder(node.left);
			System.out.print("  " + node.data);
			inorder(node.right);
		}
	}

	public void postorder()
	{
		postorder(root);
	}

	private void postorder(Node node)
	{
		if (node != null)
		{
			postorder(node.left);
			postorder(node.right);
			System.out.print("  " + node.data);
		}
	}
	
	public Node search(int key)
	{
		return search(root, key);
	}

	private Node search(Node node, int key)
	{
		if (node == null)
			return null;
		if (node.data == key)
			return node;
		else if (key < node.data)
			return search(node.left, key);
		else
			return search(node.right, key);
	}
}

public class DefthFirst_BT_Traversing11
{
	public static void main(String[] args)
	{
		NodeDemo11 NodeDemo = new NodeDemo11();
		NodeDemo.insert(10);
		NodeDemo.insert(2);
		NodeDemo.insert(6);
		NodeDemo.insert(5);
		NodeDemo.insert(8);
		NodeDemo.insert(3);

		NodeDemo.preorder();
		System.out.println();
		NodeDemo.inorder();
		System.out.println();
		NodeDemo.postorder();
	}
}
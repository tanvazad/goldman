package practise.ds.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Tree {

  private TreeNode root;


  public static void inorderTraverSalItr(TreeNode root) {

  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null)
      return null;
    if (root.getData() == p.getData() || root.getData() == q.getData())
      return root;

    TreeNode l = lowestCommonAncestor(root.getLeftChild(), p, q);
    TreeNode r = lowestCommonAncestor(root.getRightChild(), p, q);

    if (l != null && r != null)
      return root;

    if (l != null)
      return root.getLeftChild();
    else
      return root.getRightChild();

  }

  // Convert a given Binary Tree to Doubly Linked List

  public void binaryTreeToDLL(TreeNode rootPtr, TreeNode head) {
    if (rootPtr == null)
      return;
    binaryTreeToDLL(rootPtr.getRightChild(), head);
    rootPtr.setRightChild(head);
    if (head != null)
      head.setLeftChild(rootPtr);
    head = rootPtr;
    binaryTreeToDLL(rootPtr.getLeftChild(), head);
  }

  public void printDLL(TreeNode p) {
    while (p != null) {
      System.out.print(p.getData() + ",");
      p = p.getRightChild();
    }
    System.out.println();
  }

  // Print Top view of tree
  boolean onleft = true;

  public void printTopViewTree(TreeNode r) {
    if (r == null)
      return;
    if (onleft)
      printTopViewTree(r.getLeftChild());
    System.out.print(r.getData() + " ");
    if (r == root)
      onleft = false;
    if (!onleft)
      printTopViewTree(r.getRightChild());
    if (r == getRoot()) {
      System.out.println();
      onleft = true;
    }
  }


  public int countNodes(TreeNode ptr) {
    int count = 0;
    if (ptr != null) {
      count = 1 + countNodes(ptr.getLeftChild()) + countNodes(ptr.getRightChild());
    }
    return count;
  }

  // Density of Binary Tree in One Traversal
  // Given a Binary Tree, find density of it by doing one traversal of it.
  //
  // Density of Binary Tree = Size / Height
  public float desnsityTree(TreeNode ptr) {
    return countNodes(ptr) / getTreeHeight(ptr);
  }

  // Get the LCA of a Node
  public TreeNode getLCA(TreeNode r, int p, int q) {
    if (r == null)
      return null;
    if (r.getData() == p || r.getData() == q)
      return r;

    TreeNode left = getLCA(r.getLeftChild(), p, q);
    TreeNode right = getLCA(r.getRightChild(), p, q);
    if (left != null && right != null)
      return r;

    return (left != null) ? left : right;

  }

  // Convert BST to DLL in place

  public TreeNode convertBTDLLUtil() {
    if (root == null)
      return null;
    // Convert the left subtree and link to root

    root = convertBTDLLUtil(root);

    while (root.getLeftChild() != null)
      root = root.getLeftChild();

    return root;
  }

  public TreeNode convertBTDLLUtil(TreeNode node) {

    if (node.getLeftChild() != null) {
      TreeNode l = convertBTDLLUtil(node.getLeftChild());
      while (l.getRightChild() != null)
        l = l.getRightChild();
      l.setRightChild(node);
      node.setLeftChild(l);
    }

    // Convert the right subtree and link to root.
    if (node.getRightChild() != null) {
      TreeNode r = convertBTDLLUtil(node.getRightChild());
      while (r.getLeftChild() != null)
        r = r.getLeftChild();
      r.setLeftChild(node);
      node.setRightChild(r);

    }
    return node;
  }


  public void printList(TreeNode node) {
    System.out.println("BST To DLL in place");
    while (node != null) {
      System.out.print(node.getData() + ",");
      node = node.getRightChild();
    }

  }

  static int maxLevelRight = 0;

  public void printRightView(TreeNode r, int level) {

    if (r == null)
      return;
    if (maxLevelRight < level) {
      System.out.print(r.getData() + ",");
      maxLevelRight = level;
    }
    printRightView(r.getRightChild(), level + 1);
    printRightView(r.getLeftChild(), level + 1);
  }

  public void printRightView(TreeNode r) {
    printRightView(r, 1);
  }

  static int maxLevelLeft = 0;

  public void printLeftView(TreeNode r, int level) {

    if (r == null)
      return;
    if (maxLevelLeft < level) {
      System.out.print(r.getData() + ",");
      maxLevelLeft = level;
    }
    printLeftView(r.getLeftChild(), level + 1);
    printLeftView(r.getRightChild(), level + 1);

  }

  public void printLeftView(TreeNode r) {
    printLeftView(r, 1);
  }


  public void add(int x) {
    TreeNode node = new TreeNode();
    node.setData(x);
    node.setLeftChild(null);
    node.setRightChild(null);
    // node.setParent(null);
    TreeNode temp = root;
    if (root != null) {
      while (true) {
        if (temp.getData() > x) {
          if (temp.getLeftChild() == null) {
            temp.setLeftChild(node);
            // node.setParent(temp);
            break;
          }
          temp = temp.getLeftChild();
        } else if (temp.getData() < x) {
          if (temp.getRightChild() == null) {
            temp.setRightChild(node);
            // node.setParent(temp);
            break;
          }
          temp = temp.getRightChild();
        } else {
          temp = node;
        }
      }
    } else {
      root = node;
    }

  }

  public void inorderTraversal(TreeNode rootNode) {
    if (rootNode != null) {
      inorderTraversal(rootNode.getLeftChild());
      System.out.print(rootNode.getData() + "  ");
      inorderTraversal(rootNode.getRightChild());
    }
  }

  public int getTreeHeight(TreeNode ptr) {
    if (ptr != null) {
      int leftHeight = getTreeHeight(ptr.getLeftChild());
      int rightHeight = getTreeHeight(ptr.getRightChild());
      return Math.max(leftHeight, rightHeight) + 1;
    } else
      return 0;
  }



  public void printGivenLevel(TreeNode ptr, int level) {
    if (ptr == null)
      return;
    if (level == 1) {
      System.out.print("(" + ptr.getData() + ")");

    } else if (level > 1) {
      printGivenLevel(ptr.getLeftChild(), level - 1);
      printGivenLevel(ptr.getRightChild(), level - 1);
    }
  }

  public void levelOrderTraversalReverse(TreeNode ptr) {
    int h = getTreeHeight(ptr);
    for (int i = h; i >= 1; i--) {
      printGivenLevel(ptr, i);
      System.out.println();
    }
  }

  public void levelOrderTraversal(TreeNode ptr) {
    int h = getTreeHeight(ptr);
    for (int i = 1; i <= h; i++) {
      printGivenLevel(ptr, i);
      System.out.println();
    }
  }

  public void printGivenLevelReverse(TreeNode ptr, int level) {
    if (ptr == null)
      return;
    if (level == 1) {
      System.out.print(ptr.getData() + ",");

    } else if (level > 1) {
      printGivenLevel(ptr.getRightChild(), level - 1);
      printGivenLevel(ptr.getLeftChild(), level - 1);

    }
  }

  public void printZigZag(TreeNode ptr) {
    int h = getTreeHeight(ptr);
    for (int i = 1; i <= h; i++) {
      if (i % 2 == 0) {
        printGivenLevelReverse(ptr, i);
        System.out.println();
      } else {
        printGivenLevel(ptr, i);
        System.out.println();
      }

    }
  }

  public List<List<Integer>> leveOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    int h = getTreeHeight(root);
    printGivenLevel(root, 0, res);
    return res;
  }

  public void printGivenLevel(TreeNode root, int level, List<List<Integer>> res) {
    if (root == null)
      return;
    else if (level == 1)
      res.get(0).add(root.getData());
    else if (level > 1) {
      printGivenLevel(root.getLeftChild(), level, res);
      printGivenLevel(root.getRightChild(), level, res);
    }
  }


  public List<Double> averageLevel(TreeNode root) {
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    Queue<TreeNode> temp = new LinkedList<>();
    while (!q.isEmpty()) {
      long sum = 0;
      long count = 0;
      while (!q.isEmpty()) {
        TreeNode n = q.remove();
        sum += n.getData();
        count++;
        if (n.getLeftChild() != null)
          temp.add(n.getLeftChild());
        if (n.getRightChild() != null)
          temp.add(n.getRightChild());
      }
      q = temp;
      res.add(sum * 1.0 / count);
    }
    return res;
  }

  public void printLevelOrderUsingQueue(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    if (root != null)
      q.add(root);
    while (!q.isEmpty()) {
      TreeNode temp = q.poll();
      if (temp != null)
        System.out.print(temp.getData() + ",");

      if (temp.getLeftChild() != null)
        q.add(temp.getLeftChild());
      if (temp.getRightChild() != null)
        q.add(temp.getRightChild());
    }
  }



  // Given bounds print given levels in a separate line

  public static void printNodesWithinLevels(TreeNode node, int low, int high) {
    int level = 1;
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode marker = null;
    q.add(node);
    q.add(marker);
    while (!q.isEmpty()) {
      TreeNode n = q.remove();
      if (n == marker) {
        System.out.println();
        level++;
        if (q.isEmpty() || level > high)
          break;
        q.add(marker);
        continue;
      }
      if (level >= low)
        System.out.print(n.getData() + " ");
      if (n.getLeftChild() != null)
        q.add(n.getLeftChild());
      if (n.getRightChild() != null)
        q.add(n.getRightChild());
    }
  }

  // public void nodesBetweenLevels(TreeNode ptr, int low, int high) {
  // Queue<TreeNode> q = new LinkedList<TreeNode>();
  // int curLevel = 1;
  // int level = 0;
  // if (ptr == null)
  // return;
  // q.add(ptr);
  // while (!q.isEmpty()) {
  // level = q.size();
  // while (level > 0) {
  // TreeNode n = (TreeNode) q.remove();
  // if (curLevel >= low && curLevel <= high)
  // System.out.print(n.getData() + " ");
  // if (n.getLeftChild() != null)
  // q.add(n.getLeftChild());
  // if (n.getRightChild() != null)
  // q.add(n.getRightChild());
  // level--;
  // }
  // if (curLevel >= low && curLevel <= high)
  // System.out.println("");
  // curLevel++;
  // }
  // }

  // In order successor of a Node in a Tree
  public TreeNode getRightMin(TreeNode ptr) {
    TreeNode curr = ptr;
    while (curr.getLeftChild() != null)
      curr = curr.getLeftChild();
    return curr;
  }

  public TreeNode searchNode(TreeNode ptr, int x) {
    if (ptr == null)
      return ptr;
    while (ptr != null) {
      if (ptr.getData() == x)
        break;
      else if (ptr.getData() > x)
        ptr = ptr.getLeftChild();
      else if (ptr.getData() < x)
        ptr = ptr.getRightChild();
    }
    return ptr;
  }



  // Print a tree in vertically

  public class MapEntry {
    int nodeValue;
    int nodeLevel;

    MapEntry(int value, int level) {
      nodeValue = value;
      level = nodeLevel;
    }

  }


  public void printRightViewTree(TreeNode rootNode, int nextLevel) {
    int currentLevel = 0;
    if (rootNode == null)
      return;
    if (currentLevel < nextLevel) {
      System.out.print(" " + rootNode.getData());
      currentLevel = nextLevel;
    }
    printRightViewTree(rootNode.getRightChild(), nextLevel + 1);
    printRightViewTree(rootNode.getLeftChild(), nextLevel + 1);
  }


  public class QueuePack {
    int nodeLevel;
    TreeNode tnode;

    QueuePack(int nodeLevel, TreeNode tnode) {
      this.nodeLevel = nodeLevel;
      this.tnode = tnode;
    }
  }

  // End >>>>>>>>>>>>>> Another way print top view of a Binary Search Tree <<<<<<<<<<<<<<<<<<<<


  public void printBottomViewTree(TreeNode rootPtr, int level) {
    if (rootPtr == null)
      return;
    Map<Integer, Integer> map = new TreeMap<>();
    Queue<QueuePack> q = new LinkedList<>();
    q.add(new QueuePack(level, rootPtr));
    while (!q.isEmpty()) {
      QueuePack queuePack = q.remove();
      TreeNode tnode = queuePack.tnode;
      int nodeLevel = queuePack.nodeLevel;
      map.put(nodeLevel, tnode.getData());
      // Add left and right child
      if (tnode.getLeftChild() != null) {
        q.add(new QueuePack(nodeLevel - 1, tnode.getLeftChild()));
      }
      if (tnode.getRightChild() != null) {
        q.add(new QueuePack(nodeLevel + 1, tnode.getRightChild()));
      }
    }

    Set<Integer> keys = map.keySet();
    System.out.println("Printing bottom view of a tree");
    for (Integer key : keys) {
      System.out.print(map.get(key) + "  ");
    }


  }

  // public void populateNeighbourNodes(TreeNode treeRoot) {
  // if (treeRoot == null)
  // return;
  // if (treeRoot.getLeftChild() != null) {
  // if (treeRoot.getRightChild() != null) {
  // treeRoot.getLeftChild().setNeighbour(treeRoot.getRightChild());
  // } else {
  // TreeNode parentNighbour = treeRoot.getNeighbour();
  // TreeNode neighbourNode;
  // while (parentNighbour != null) {
  // neighbourNode = (parentNighbour.getLeftChild() != null) ? parentNighbour.getLeftChild()
  // : parentNighbour.getRightChild();
  // treeRoot.setLeftChild(neighbourNode);
  // break;
  // }
  // parentNighbour = parentNighbour.getNeighbour();
  // }
  // if (treeRoot.getRightChild() != null) {
  // TreeNode parentNeighbor = root.getNeighbour();
  // TreeNode neighborNode;
  //
  // while (parentNeighbor != null) {
  // neighborNode = (parentNeighbor.getLeftChild() != null) ? parentNeighbor.getLeftChild()
  // : parentNeighbor.getRightChild();
  //
  //
  // if (neighborNode != null) {
  // root.getRightChild().setNeighbour(neighborNode);
  // break;
  // }
  //
  // parentNeighbor = parentNeighbor.getNeighbour();
  // }
  // }
  // }
  //
  // populateNeighbourNodes(treeRoot.getRightChild());
  // populateNeighbourNodes(treeRoot.getLeftChild());
  // }

  // public void traverseUsingNeighborNode(TreeNode treeNode) {
  // TreeNode currentNode = treeNode;
  // while (currentNode != null) {
  // TreeNode temp = currentNode;
  // currentNode = null;
  // while (temp != null) {
  // if (currentNode == null) {
  // currentNode = (temp.getLeftChild() != null) ? temp.getLeftChild() : temp.getRightChild();
  // }
  // System.out.println("temp Val:" + temp.getData());
  // temp = temp.getNeighbour();
  // }
  // }
  // }

  // Finding the kth smallest element

  public int sizeOfTree(TreeNode ptr) {
    if (ptr == null)
      return 0;
    return sizeOfTree(ptr.getLeftChild()) + 1 + sizeOfTree(ptr.getRightChild());

  }

  public int sizeOfLeftSubTree(TreeNode ptr) {
    if (ptr == null)
      return 0;
    return sizeOfLeftSubTree(ptr.getLeftChild()) + 1;

  }

  public int sizeOfRightSubTree(TreeNode ptr) {
    if (ptr == null)
      return 0;
    return sizeOfRightSubTree(ptr.getRightChild()) + 1;

  }


  public int kthSmallest(TreeNode rootPtr, int k) {

    if (rootPtr == null)
      return 0;
    int numLeft = sizeOfTree(rootPtr.getLeftChild());
    if (numLeft == k - 1)
      return rootPtr.getData();
    else if (numLeft > k - 1)
      return kthSmallest(rootPtr.getLeftChild(), k);
    else
      return kthSmallest(rootPtr.getRightChild(), numLeft - 1);
  }

  public void kthSmallestNode(TreeNode root, int n, int k) {
    if (root == null)
      return;
    kthSmallestNode(root.getLeftChild(), n, k);
    n++;
    if (k == n) {
      System.out.println("kth smallest:" + root.getData());
      // return;
    }
    kthSmallestNode(root.getRightChild(), n, k);

  }

  public void secondLargestUtil(TreeNode p, int k, int c) {
    if (p == null || c >= k)
      return;
    else {
      secondLargestUtil(p.getRightChild(), k, c);
      c++;

      if (c == k) {
        System.out.println("kth Largest element is:" + p.getData());
        return;
      }
      secondLargestUtil(p.getLeftChild(), k, c);
    }
  }

  public void kthLargest(TreeNode ptr, int k) {
    int c = 0;
    secondLargestUtil(ptr, k, c);

  }


  // Print tree vertically
  public static Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

  public TreeNode printTreeVertically(TreeNode root, int level) {

    ArrayList<Integer> nodeList;

    if (root == null)
      return null;

    TreeNode y = printTreeVertically(root.getLeftChild(), --level);
    if (y == null)
      level++;
    if (map.get(level) != null) {
      ArrayList<Integer> nodeListAtLevel = map.get(level);
      nodeListAtLevel.add(root.getData());
      map.put(level, nodeListAtLevel);
    } else {
      nodeList = new ArrayList<>();
      nodeList.add(root.getData());
      map.put(level, nodeList);
    }

    return printTreeVertically(root.getRightChild(), ++level);
  }

  public void printMap(Map<Integer, Integer> map) {

    Set<Integer> set = map.keySet();
    System.out.println("Data at each Level vertically in a Tree");
    for (int key : set)
      if (key < 0)
        System.out.println("left at level:" + key + "," + map.get(key) + " ");
      else
        System.out.println("right at level:" + key + "," + map.get(key) + " ");
  }

  // >>>>>>>>>

  // In-order successor of a node in a binary search Tree

  public TreeNode inOrderSuccessorNode(TreeNode root, int data) {
    TreeNode current = searchNode(root, data);
    TreeNode succ = null;
    if (current == null)
      return null;
    // Case 1
    if (current.getRightChild() != null) {
      succ = findMinRightSubTree(current.getRightChild());
      return succ;
    } else {
      // There is no right subtree

      TreeNode ancestor = root;
      while (ancestor != current) {
        if (current.getData() < ancestor.getData()) {
          succ = ancestor;
          ancestor = ancestor.getLeftChild();
        } else if (current.getData() > ancestor.getData())
          ancestor = ancestor.getRightChild();
        else
          break;
      }
      return succ;
    }

  }


  private TreeNode findMinRightSubTree(TreeNode ptr) {
    TreeNode minNode = null;
    while (ptr != null) {
      minNode = ptr;
      ptr = ptr.getLeftChild();
    }
    return minNode;
  }



  public void printBottomTree(TreeNode root) {
    Map<Integer, Integer> m = new TreeMap<>();
    Queue<TempNode> q = new LinkedList<TempNode>();
    q.add(new TempNode(root, 0));
    int maxCol = 0;
    int minCol = 0;
    while (!q.isEmpty()) {
      TempNode n = q.remove();
      m.put(n.c, n.node.getData());
      // System.out.println(n.node.getData() + ":" + n.c);
      maxCol = Math.max(maxCol, n.c);
      minCol = Math.min(minCol, n.c);
      if (n.node.getLeftChild() != null)
        q.add(new TempNode(n.node.getLeftChild(), n.c - 1));
      if (n.node.getRightChild() != null)
        q.add(new TempNode(n.node.getRightChild(), n.c + 1));
    }

    for (int i = minCol; i <= maxCol; i++) {
      System.out.print(m.get(i) + " ");
    }

  }

  public class TempNode {
    TreeNode node;
    int c;

    TempNode(TreeNode r, int col) {
      node = r;
      c = col;
    }
  }

  // >>>>>>>>>>>>>> Print path from root to Leaf <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
  public void printPathRootToLeaf(TreeNode r) {
    if (r == null)
      return;
    ArrayList<Integer> path = new ArrayList<>();
    printRootToLeaf(r, path);
  }



  private void printRootToLeaf(TreeNode r, ArrayList<Integer> path) {

    path.add(r.getData());
    if (r.getLeftChild() == null && r.getRightChild() == null) {
      printArrayList(path);
      return;
    }
    if (r.getLeftChild() != null)
      printRootToLeaf(r.getLeftChild(), new ArrayList<Integer>(path));
    if (r.getRightChild() != null)
      printRootToLeaf(r.getRightChild(), new ArrayList<Integer>(path));

  }

  /*
   * Serialize Tree
   */


  public void searializeTree(TreeNode root, List<Integer> arr) {
    if (root == null) {
      arr.add(-1);
      return;
    }
    arr.add(root.getData());
    searializeTree(root.getLeftChild(), arr);
    searializeTree(root.getRightChild(), arr);
  }

  int index = 0;

  public TreeNode deSearializeTree(List<Integer> arr) {
    if (arr.size() == index || arr.get(index) == -1) {
      index += 1;
      return null;
    }
    TreeNode rootNode = new TreeNode();
    rootNode.setData(arr.get(index));
    index += 1;
    rootNode.setLeftChild(deSearializeTree(arr));
    rootNode.setRightChild(deSearializeTree(arr));
    return rootNode;
  }

  /*
   * de-Serialize Tree end
   */

  /*
   * Serialize and deserialize a Tree
   */
  public static String serializeBinaryTree(TreeNode root) {
    if (root == null)
      return "*";
    return " " + root.getData() + " " + serializeBinaryTree(root.getLeftChild()) + " "
        + serializeBinaryTree(root.getRightChild());
  }

  public static TreeNode deSerializeBinaryTree(String searialzedTree) {
    return buildTreeFromData(new Scanner(searialzedTree));
  }

  private static TreeNode buildTreeFromData(Scanner scanner) {
    if (!scanner.hasNext())
      return null;
    String tk = scanner.next();
    if (tk.equals("*"))
      return null;
    TreeNode root = new TreeNode();
    root.setData(Integer.parseInt(tk));
    root.setLeftChild(buildTreeFromData(scanner));
    root.setRightChild(buildTreeFromData(scanner));
    return root;
  }
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

  private void printQueue(Queue<TreeNode> q) {
    System.out.println("Printing Queue");
    while (!q.isEmpty()) {
      System.out.println(q.poll().getData());
    }

  }

  public void printArrayList(ArrayList<Integer> pathList) {

    for (Integer i : pathList) {
      System.out.print(i + "->");
    }
    System.out.println();
  }

  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

  // Min depth of a Binary search Tree
  public int minDepthTree(TreeNode r) {
    if (r == null)
      return 0;
    if (r.getLeftChild() == null && r.getRightChild() == null)
      return 1;

    int leftDepth = r.getLeftChild() != null ? minDepthTree(r.getLeftChild()) : Integer.MAX_VALUE;

    int rightDepth =
        r.getRightChild() != null ? minDepthTree(r.getRightChild()) : Integer.MAX_VALUE;

    return 1 + Math.min(leftDepth, rightDepth);
  }

  // Leaf view of a tree????

  // Sum of all leaf nodes of a tree

  public boolean isLeafNode(TreeNode r) {
    if (r == null)
      return false;
    if (r.getLeftChild() == null && r.getRightChild() == null)
      return true;
    return false;
  }

  public void sumLeafNodes(TreeNode r, int leftLeavesSum[]) {
    if (r == null)
      return;
    if (isLeafNode(r.getLeftChild())) {
      leftLeavesSum[0] += r.getLeftChild().getData();
    }

    if (r.getLeftChild() != null)
      sumLeafNodes(r, leftLeavesSum);

    if (r.getRightChild() != null)
      sumLeafNodes(r, leftLeavesSum);

  }



  // Print Diagonals of a tree second solution using recursion

  public void treeDiagonalPrint(TreeNode root) {

    Queue<TreeNode> q = new LinkedList<TreeNode>();

    if (root != null) {
      q.add(root);
      q.add(null);
    }

    while (!q.isEmpty()) {
      TreeNode temp = q.poll();
      if (temp == null) {
        if (!q.isEmpty())
          q.add(null);
        System.out.println();
        continue;
      }

      while (temp != null) {
        if (temp.getLeftChild() != null)
          q.add(temp.getLeftChild());
        System.out.print(temp.getData() + ",");
        temp = temp.getRightChild();
      }
    }
  }

  // Print Diagonals of a tree First solution using HasMap
  public void printDiagonalMap(HashMap<Integer, ArrayList<Integer>> mapList) {

    for (Entry<Integer, ArrayList<Integer>> entry : mapList.entrySet()) {
      System.out.print(
          "Tree left Count:" + entry.getKey() + ",Tree Diagonals:" + entry.getValue().toString());
      System.out.println();
    }

  }


  public class QueueNode {
    int lcnt;
    TreeNode node;

    QueueNode(TreeNode tnode, int nodeLeftCount) {
      this.lcnt = nodeLeftCount;
      this.node = tnode;
    }
  }


  public void displayDiagonalTree(Map<Integer, List<Integer>> map) {
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      System.out.println(
          "Level[" + entry.getKey() + "]" + ":" + Arrays.toString(entry.getValue().toArray()));
    }
  }

  public HashMap<Integer, List<Integer>> diagonalPrintTree(TreeNode root) {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    Queue<QueueNode> q = new LinkedList<QueueNode>();

    QueueNode rootNode = new QueueNode(root, 0);
    if (root != null) {
      q.add(rootNode);
    }

    while (!q.isEmpty()) {
      QueueNode temp = q.poll();
      if (temp == null)
        break;
      if (map.get(temp.lcnt) == null)
        map.put(temp.lcnt, new ArrayList<Integer>());
      map.get(temp.lcnt).add(temp.node.getData());

      if (temp.node.getLeftChild() != null)
        q.add(new QueueNode(temp.node.getLeftChild(), temp.lcnt + 1));
      if (temp.node.getRightChild() != null)
        q.add(new QueueNode(temp.node.getRightChild(), temp.lcnt));

    }
    return map;
  }

  // Diagonals of a tree First solution using HasMap End


  // Print all nodes that don’t have sibling

  public void printSingles(TreeNode node) {

    if (node == null)
      return;
    if (node.getLeftChild() != null && node.getRightChild() != null) {
      printSingles(node.getLeftChild());
      printSingles(node.getRightChild());
      // System.out.println();
    }

    if (node.getRightChild() != null) {
      System.out.print(node.getRightChild().getData() + ",");
      printSingles(node.getRightChild());
      System.out.println();
    }

    if (node.getLeftChild() != null) {
      System.out.print(node.getLeftChild().getData() + ",");
      printSingles(node.getLeftChild());
    }
  }

  // O(h) recursive method
  public TreeNode swapNodes(TreeNode p) {
    TreeNode temp = null;
    if (p == null)
      return null;
    else {
      TreeNode left = swapNodes(p.getLeftChild());
      TreeNode right = swapNodes(p.getRightChild());
      temp = left;
      left = right;
      right = temp;
    }
    return p;
  }

  // Iterative method

  public TreeNode swapNodes2(TreeNode p) {

    if (p == null)
      return null;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(p);
    while (!q.isEmpty()) {
      TreeNode current = q.poll();
      TreeNode temp = current.getLeftChild();
      current.setLeftChild(current.getRightChild());
      current.setRightChild(temp);

      if (current.getLeftChild() != null)
        q.add(current.getLeftChild());
      if (current.getRightChild() != null)
        q.add(current.getRightChild());
    }
    return p;
  }


  public static void nonRecursiveInorder(TreeNode root) {

    Stack<TreeNode> stack = new Stack<>();
    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.getLeftChild();
      }
      if (stack.isEmpty())
        return;
      root = stack.pop();
      System.out.print(root.getData() + ",");
      root = root.getRightChild();

    }
  }

  public static void nonRecursivePreorder(TreeNode root) {
    if (root == null)
      return;

    Stack<TreeNode> stack = new Stack<>();
    while (true) {
      while (root != null) {
        System.out.print(root.getData() + ",");
        stack.push(root);
        root = root.getLeftChild();
      }
      if (stack.isEmpty())
        return;
      root = stack.pop();
      // System.out.print(root.getData() + ",");
      root = root.getRightChild();

    }
  }

  // TBD need to check
  public static void nonRecursivePostOrder(TreeNode root) {
    if (root == null)
      return;

    Stack<TreeNode> stack = new Stack<>();
    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.getLeftChild();
      }
      if (stack.isEmpty())
        return;
      root = stack.pop();
      root = root.getRightChild();

    }
  }


  public boolean validateBst(TreeNode root) {
    TreeNode current = root;
    TreeNode prev = null;
    Stack<TreeNode> stack = new Stack<>();

    while (!stack.isEmpty() || current != null) {
      if (current != null) {
        stack.push(current);
        current = current.getLeftChild();
      } else {
        TreeNode p = stack.pop();
        if (prev != null && p.getData() <= prev.getData())
          return false;
        prev = p;
        current = p.getRightChild();
      }
    }

    return true;
  }

  /*
   * Boundary of a binary Tree
   * 
   */
  public static void printBoundary(TreeNode root) {
    System.out.println("Left boundary");
    printBoundaryLeftTree(root);
    System.out.println();
    System.out.println("Right boundary");
    printBoundaryRightTree(root);
    System.out.println();
    System.out.println("Leaf nodes");
    printLeafNodes(root);

  }

  public static void printLeafNodes(TreeNode root) {
    if (root != null) {
      printLeafNodes(root.getLeftChild());
      if (root.getLeftChild() == null && root.getRightChild() == null)
        System.out.print(root.getData() + ",");
      printLeafNodes(root.getRightChild());
    }
  }

  public static void printBoundaryLeftTree(TreeNode root) {
    if (root == null)
      return;

    if (root.getLeftChild() != null) {
      printBoundaryLeftTree(root.getLeftChild());
    }
    System.out.print(root.getData() + ",");

  }

  public static void printBoundaryRightTree(TreeNode root) {
    if (root == null)
      return;
    if (root.getRightChild() != null)
      printBoundaryRightTree(root.getRightChild());
    System.out.print(root.getData() + ",");
  }

  /*
   * 
   * Diagonal Sum binary Tree
   */

  public static void computeDiagonalSumTree(TreeNode root, int currentDiag,
      Map<Integer, Integer> map) {
    if (root == null)
      return;
    computeDiagonalSumTree(root.getLeftChild(), currentDiag + 1, map);
    int prevSum = 0;
    if (map.get(currentDiag) != null) {
      prevSum = map.get(currentDiag);
    }
    map.put(currentDiag, prevSum + root.getData());
    computeDiagonalSumTree(root.getRightChild(), currentDiag, map);
  }

  public static boolean isBinarySEarchTree(TreeNode root) {
    return bstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean bstUtil(TreeNode root, int min, int max) {
    if (root == null)
      return true;
    if (root.getData() < min || root.getData() > max)
      return false;

    return !bstUtil(root.getLeftChild(), min, root.getData() - 1)
        && !bstUtil(root.getRightChild(), max, root.getData() - 1);

  }

  TreeNode prev;

  public boolean isBST() {
    prev = null;
    return isBST(root);

  }

  public boolean isBST(TreeNode root) {
    if (root != null) {
      if (!isBST(root.getLeftChild()))
        return false;
      if (prev != null && prev.getData() >= root.getData())
        return false;
      prev = root;
      return isBST(root.getRightChild());
    }
    return true;

  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);

    while (!q.isEmpty()) {
      List<Integer> ls = new LinkedList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.remove();
        ls.add(node.getData());
        if (node.getLeftChild() != null)
          q.add(node.getLeftChild());
        if (node.getRightChild() != null)
          q.add(node.getRightChild());
      }
      ((LinkedList) res).addFirst(ls);
    }
    return res;
  }

  public static void main(String[] args) {
    // String str = new String();

    Tree T = new Tree();
    T.add(8);
    T.add(3);
    T.add(10);
    T.add(1);
    T.add(6);
    T.add(14);
    T.add(13);
    T.add(4);
    T.add(7);
    T.inorderTraversal(T.root);
    System.out.println();

    System.out.println(T.levelOrderBottom(T.root));
    // T.printNodesWithinLevels(T.root, 1, 4);
    // System.out.println();
    // System.out.println(T.isBST());
    // System.out.println(isBinarySEarchTree(T.root));
    // Map<Integer, Integer> diagSumMap = new HashMap<>();
    //
    // computeDiagonalSumTree(T.root, 0, diagSumMap);
    // System.out.println();
    // displayMap(diagSumMap);


    // System.out.println();
    // printBoundary(T.root);
    // System.out.println();
    // List<Integer> arr = new ArrayList<Integer>();
    // T.searializeTree(T.root, arr);
    // System.out.println("Serialized Tree:" + Arrays.toString(arr.toArray()));
    // System.out.print("De Serialized Tree:");
    // T.inorderTraversal(T.deSearializeTree(arr));
    // nonRecursiveInorder(T.root);
    // T.displayDiagonalTree(T.diagonalPrintTree(T.root));

    // T.inorderTraversal(T.root);
    // System.out.println(serializeBinaryTree(T.getRoot()));
    // T.levelOrderTraversal(deSerializeBinaryTree(serializeBinaryTree(T.getRoot())));
    // T.inorderTraversal(deSerializeBinaryTree(serializeBinaryTree(T.getRoot())));
    // T.displayDiagonalTree(T.diagonalPrintTree(T.root));
    // String seralizedTreeNodes = T.serializeTree(T.root);
    // T.inorderTraversal(T.decodeTree(T.serializeTree(T.root)));
    // System.out.println(T.decodeTree(seralizedTreeNodes).getData());
    // System.out.println(seralizedTreeNodes);
    // T.inorderTraversal(T.decodeTree(seralizedTreeNodes));


    //
    // //T.inorderTraversal(T.getRoot());
    // T.root = T.swapNodes2(T.getRoot());
    // System.out.println();
    // T.printPathRootToLeaf(T.getRoot());
    // T.lowestCommonAncestor(T.getRoot(), p, q)
    // System.out.println("Top view");
    // T.printTop(T.getRoot());
    // T.printLeftView(T.getRoot());
    // T.printSingles(T.getRoot());
    // // T.inorderTraversal(T.getRoot());
    // System.out.println();
    // HashMap<Integer, ArrayList<Integer>> mapList = T.diagonalPrintTree(T.getRoot());
    // T.printDiagonalMap(mapList);
    // T.printPathRootToLeaf(T.getRoot());
    // T.levelOrderTraversalReverse(T.getRoot());

    // Node res = T.getLCA(T.getRoot(), 4, 27);
    // System.out.println(res.getData());
    // Node head = T.convertBTDLLUtil();
    // T.printList(head);
    // T.inorderTraversal(T.getRoot());
    // System.out.println();
    // int leafSum[]= new int[1];
    // T.sumLeafNodes(T.getRoot(), leafSum);
    // T.printPathRootToLeaf(T.getRoot());
    // T.printLeftView(T.getRoot());
    // T.printRightView(T.getRoot());
    // T.printBottomTree(T.getRoot());
    // T.printTop(T.getRoot());
    // T.printTop(T.getRoot());


    // if (T.inOrderSuccessorNode(T.getRoot(), 20) != null)
    // System.out.println(T.inOrderSuccessorNode(T.getRoot(), 20).getData());
    // // T.printTreeVertically(T.getRoot(), 0);
    // T.printMap((TreeMap) map);

    // T.printTopViewTree(T.getRoot());
    // T.kthLargest(T.getRoot(), 2);
    // T.kthSmallestNode(T.getRoot(), 1, 3);
    // // System.out.println(T.kthSmallest(T.getRoot(), 3));
    // // System.out.println(T.sizeOfLeftSubTree(T.getRoot()));
    // System.out.println();
    // System.out.println(T.numNodesLeftSubTree(T.getRoot()));
    // T.kthSmallest(T.getRoot(), 3);
    // T.traverseUsingNeighborNode(T.getRoot());
    // System.out.println(T.inOrderSuccessor(T.getRoot(), 225).getData());


    // System.out.println(T.inOrderSuccessor(T.getRoot(), 10).getData());
    // System.out.println(T.inorderSuccessorWithParent(T.getRoot(), 12));
    // T.topViewTree(T.getRoot(), 0);
    // T.printBottomViewTree(T.getRoot(), 0);
    // //T.printBottomViewTree(T.getRoot(), 0);
    // T.printTopView();
    // // T.printRightViewTree(T.getRoot(), 1);
    //
    // // T.printVerticalOrder(T.getRoot());
    //
    // // T.nodesBetweenLevels(T.root, 2, 4);
    // // System.out.println(T.inOrderSuccessor(T.getRoot(), 14).getData());
    // // T.printLevelOrderUsingQueue(T.getRoot());
    // // T.inorderTraversal(T.getRoot());
    // // System.out.println();
    // // System.out.println("Tree height:" + T.getTreeHeight(T.getRoot()));
    // // T.levelOrderTraversal(T.getRoot());
    // // T.printZigZag(T.getRoot());
    // int Arr[]= {1,2,1,3,1,14,2,4,6,7};
    // Map<Integer,Integer>map = new LinkedHashMap<>();
    //
    // for(int i=0; i <Arr.length;i++){
    // if(!map.containsKey(Arr[i]))
    // map.put(Arr[i], 1);
    // else{
    // map.put(Arr[i],map.get(Arr[i])+1);
    // }
    // }
    // System.out.println();
    // int cnt =0;
    // for(Map.Entry<Integer, Integer>entry:map.entrySet()){
    // if(entry.getValue()>1)cnt++;
    // //System.out.println(entry.getValue());
    // }
    // System.out.println(cnt);
    //



  }

  private static void displayMap(Map<Integer, Integer> diagSumMap) {
    for (Map.Entry<Integer, Integer> entry : diagSumMap.entrySet()) {
      System.out.println("Level_" + entry.getKey() + "," + entry.getValue());
    }
  }

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

}

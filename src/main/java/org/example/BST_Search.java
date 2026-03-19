package org.example;

public class BST_Search {
	class TreeNode {
		int data;
		TreeNode leftChild, rightChild, parent;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private TreeNode root;

	public void insert(int value) {
		TreeNode newNode = new TreeNode(value);
		if (root == null) { root = newNode; return; }
		TreeNode curr = root, parent = null;
		while (curr != null) {
			parent = curr;
			if (value < curr.data) curr = curr.leftChild;
			else curr = curr.rightChild;
		}
		newNode.parent = parent;
		if (value < parent.data) parent.leftChild = newNode;
		else parent.rightChild = newNode;
	}

	public TreeNode find(int findMe) {
		TreeNode n = root;
		while (n != null) {
			if (n.data == findMe)     return n;
			if (n.data < findMe)      n = n.rightChild;
			else                      n = n.leftChild;
		}
		return null;
	}

	public static void main(String[] args) {
		BST_Search bst = new BST_Search();
		bst.insert(6); bst.insert(2); bst.insert(8);
		bst.insert(1); bst.insert(4);

		System.out.println(bst.find(4).data);  // 4
		System.out.println(bst.find(99));       // null
	}
}
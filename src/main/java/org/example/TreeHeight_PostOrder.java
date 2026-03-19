package org.example;

public class TreeHeight_PostOrder {
	static class TreeNode {
		int data;
		TreeNode leftChild, rightChild;

		TreeNode(int data) { this.data = data; }
	}

	public static int getHeight(TreeNode n) {
		if (n == null)
			return 0;
		int leftHeight  = getHeight(n.leftChild);
		int rightHeight = getHeight(n.rightChild);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(3);
		root.leftChild.leftChild = new TreeNode(4);

		System.out.println(getHeight(root)); // 3
	}
}

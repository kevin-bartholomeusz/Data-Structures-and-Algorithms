package org.example;

import java.util.Stack;

public class Iterative_PreOrder_TreeTraversal {
	static class TreeNode {
		int data;
		TreeNode leftChild, rightChild;

		TreeNode(int data) { this.data = data; }
	}

	public static void preOrder(TreeNode t) {
		Stack<TreeNode> s = new Stack<>();
		s.push(t);
		while (!s.empty()) {
			t = s.pop();
			if (t != null) {
				System.out.print(t.data + " ");
				s.push(t.rightChild); // push right first
				s.push(t.leftChild);  // so left is processed first
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(3);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		preOrder(root); // 1 2 4 5 3
	}
}

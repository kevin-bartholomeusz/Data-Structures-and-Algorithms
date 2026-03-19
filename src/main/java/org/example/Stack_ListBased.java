package org.example;

import java.util.EmptyStackException;

public class Stack_ListBased {
	class ListNode {
		int data;
		ListNode next;

		ListNode(int d, ListNode n) {
			data = d;
			next = n;
		}
	}

	private ListNode topNode;

	public Stack_ListBased() {
		topNode = null;
	}

	public int top() {
		if (topNode == null) throw new EmptyStackException();
		return topNode.data;
	}

	public void pop() {
		if (topNode == null) throw new EmptyStackException();
		topNode = topNode.next;
	}

	public void push(int data) {
		topNode = new ListNode(data, topNode);
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	public static void main(String[] args) {
		Stack_ListBased stack = new Stack_ListBased();
		stack.push(60);
		stack.push(23);
		stack.push(10);
		stack.push(42);
		stack.pop();
		System.out.println(stack.top()); // 10
	}
}
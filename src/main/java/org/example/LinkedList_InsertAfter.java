package org.example;

public class LinkedList_InsertAfter {
	static class ListNode {
		int data;
		ListNode next;
		ListNode previous;

		ListNode(int data) {
			this.data = data;
		}
	}

	public static void insertAfter(ListNode node, int newData) {
		ListNode newNode = new ListNode(newData);
		ListNode next = node.next;
		newNode.next = next;
		newNode.previous = node;
		node.next = newNode;
		if (next != null)
			next.previous = newNode;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(30);
		head.next = second;
		second.previous = head;

		insertAfter(head, 20); // inserts 20 between 10 and 30

		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.data + " "); // 10 20 30
			curr = curr.next;
		}
	}
}

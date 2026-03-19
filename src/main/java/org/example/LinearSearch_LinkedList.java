package org.example;

public class LinearSearch_LinkedList {
	static class ListNode {
		int data;
		ListNode next;
		ListNode previous;

		ListNode(int data) {
			this.data = data;
		}
	}

	public static ListNode findLocation(ListNode head, int findMe) {
		ListNode n = head;
		while (n != null && n.data != findMe)
			n = n.next;
		return n; // null if not found
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);

		ListNode result = findLocation(head, 20);
		System.out.println(result != null ? result.data : "Not found"); // 20
	}
}

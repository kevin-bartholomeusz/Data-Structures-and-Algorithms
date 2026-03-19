package org.example;

public class LinkedList_Remove {
	static class ListNode {
		int data;
		ListNode next;
		ListNode previous;

		ListNode(int data) {
			this.data = data;
		}
	}

	public static void remove(ListNode node) {
		ListNode next = node.next;
		ListNode previous = node.previous;
		if (next != null)
			next.previous = previous;
		if (previous != null)
			previous.next = next;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(10);
		ListNode b = new ListNode(20);
		ListNode c = new ListNode(30);
		a.next = b; b.previous = a;
		b.next = c; c.previous = b;

		remove(b); // remove 20

		ListNode curr = a;
		while (curr != null) {
			System.out.print(curr.data + " "); // 10 30
			curr = curr.next;
		}
	}
}

package org.example;

public class Queue_ArrayV1 {
	public static final int CAPACITY = 10;
	private int[] entries;
	private int front = 0, back = 0;

	public Queue_ArrayV1() {
		entries = new int[CAPACITY];
	}

	public void queue(int n) {
		if (back == CAPACITY)
			throw new RuntimeException("Queue is full");
		entries[back++] = n;
	}

	public int dequeue() {
		if (front == back)
			throw new RuntimeException("Queue is empty");
		return entries[front++];
	}

	public static void main(String[] args) {
		Queue_ArrayV1 q = new Queue_ArrayV1();
		q.queue(42); q.queue(10); q.queue(23);
		System.out.println(q.dequeue()); // 42
		System.out.println(q.dequeue()); // 10
	}
}

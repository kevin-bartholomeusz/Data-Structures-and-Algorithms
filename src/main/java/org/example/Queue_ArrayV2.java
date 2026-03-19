package org.example;

public class Queue_ArrayV2 {
	public static final int CAPACITY = 10;
	private int[] entries;
	private int front = 0, back = 0;

	public Queue_ArrayV2() {
		entries = new int[CAPACITY];
	}

	public void queue(int n) {
		if ((back + 1) % CAPACITY == front)
			throw new RuntimeException("Queue is full");
		entries[back] = n;
		back = (back + 1) % CAPACITY;
	}

	public int dequeue() {
		if (front == back)
			throw new RuntimeException("Queue is empty");
		int val = entries[front];
		front = (front + 1) % CAPACITY;
		return val;
	}

	public boolean isEmpty() {
		return front == back;
	}

	public static void main(String[] args) {
		Queue_ArrayV2 q = new Queue_ArrayV2();
		q.queue(42); q.queue(10); q.queue(23);
		System.out.println(q.dequeue()); // 42
		System.out.println(q.dequeue()); // 10
	}
}

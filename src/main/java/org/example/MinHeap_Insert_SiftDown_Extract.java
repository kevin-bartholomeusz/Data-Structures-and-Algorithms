package org.example;

public class MinHeap_Insert_SiftDown_Extract {
	private int[] items;
	private int size;
	public static final int INITIAL_CAPACITY = 1000;

	public MinHeap_Insert_SiftDown_Extract() {
		items = new int[INITIAL_CAPACITY];
		size = 0;
	}

	public void insert(int newItem) {
		int index = size++;
		while (index > 0) {
			int parent = (index - 1) / 2;
			if (items[parent] <= newItem) {
				items[index] = newItem;
				return;
			}
			items[index] = items[parent];
			index = parent;
		}
		items[0] = newItem;
	}

	public int extractMin() {
		int min = items[0];
		int last = items[--size];
		int index = 0;
		// Sift down
		while (true) {
			int left  = 2 * index + 1;
			int right = 2 * index + 2;
			int smallest = index;
			if (left < size && items[left] < items[smallest])
				smallest = left;
			if (right < size && items[right] < items[smallest])
				smallest = right;
			if (smallest == index) break;
			items[index] = items[smallest];
			index = smallest;
		}
		items[index] = last;
		return min;
	}

	public boolean isEmpty() { return size == 0; }

	public static void main(String[] args) {
		MinHeap_Insert_SiftDown_Extract heap = new MinHeap_Insert_SiftDown_Extract();
		heap.insert(10); heap.insert(3);
		heap.insert(7);  heap.insert(1);
		System.out.println(heap.extractMin()); // 1
		System.out.println(heap.extractMin()); // 3
	}
}

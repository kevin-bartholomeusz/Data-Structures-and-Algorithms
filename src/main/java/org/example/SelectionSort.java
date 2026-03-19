package org.example;

public class SelectionSort {
	public static void sort(int[] values) {
		int lastUnsorted = values.length - 1;
		while (lastUnsorted > 0) {
			int maxIndex = 0;
			int maxValue = values[0];
			for (int i = 1; i <= lastUnsorted; i++) {
				if (values[i] > maxValue) {
					maxIndex = i;
					maxValue = values[i];
				}
			}
			values[maxIndex] = values[lastUnsorted];
			values[lastUnsorted] = maxValue;
			lastUnsorted--;
		}
	}

	public static void main(String[] args) {
		int[] arr = {91, 32, 92, 13, 73, 14};
		sort(arr);
		for (int x : arr) System.out.print(x + " "); // 13 14 32 73 91 92
	}
}

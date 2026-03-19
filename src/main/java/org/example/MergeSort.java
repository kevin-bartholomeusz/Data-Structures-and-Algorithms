package org.example;

public class MergeSort {
	private static void mergeRanges(int[] values, int first, int mid, int last) {
		int[] aux = new int[last - first + 1];
		int left = first;
		int right = mid + 1;
		int k = 0;

		// Compare elements from both halves, copy smaller to aux
		while (left <= mid && right <= last) {
			if (values[left] <= values[right])
				aux[k++] = values[left++];
			else
				aux[k++] = values[right++];
		}
		// Copy any remaining elements from left half
		while (left <= mid)
			aux[k++] = values[left++];
		// Copy any remaining elements from right half
		while (right <= last)
			aux[k++] = values[right++];
		// Copy aux back to original array
		for (int i = 0; i < aux.length; i++)
			values[first + i] = aux[i];
	}

	private static void sortRange(int[] values, int first, int last) {
		if (last > first) {
			int mid = (first + last) / 2;
			sortRange(values, first, mid);
			sortRange(values, mid + 1, last);
			mergeRanges(values, first, mid, last);
		}
	}

	public static void sort(int[] values) {
		sortRange(values, 0, values.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = {91, 32, 92, 13, 73, 14};
		sort(arr);
		for (int x : arr) System.out.print(x + " "); // 13 14 32 73 91 92
	}
}

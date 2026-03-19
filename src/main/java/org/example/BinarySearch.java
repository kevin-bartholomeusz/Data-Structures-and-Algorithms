package org.example;

public class BinarySearch {
	public static int binarySearch(int[] values, int findMe) {
		int first = 0, last = values.length - 1;
		while (first <= last) {
			int middle = (first + last) / 2;
			if (values[middle] == findMe)
				return middle;
			else if (values[middle] < findMe)
				first = middle + 1;
			else
				last = middle - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13};
		System.out.println(binarySearch(arr, 7));   // 3
		System.out.println(binarySearch(arr, 6));   // -1
	}
}

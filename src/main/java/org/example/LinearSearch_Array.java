package org.example;

public class LinearSearch_Array {
	public static int findLocation(int[] values, int findMe) {
		for (int i = 0; i < values.length; i++)
			if (values[i] == findMe)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {10, 30, 50, 70, 90};
		System.out.println(findLocation(arr, 50));  // 2
		System.out.println(findLocation(arr, 99));  // -1
	}
}

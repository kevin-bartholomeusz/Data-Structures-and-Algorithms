package org.example;

public class Euclids_GCD {
	public static int gcd(int x, int y) {
		while (x > 0) {
			if (x < y)
				y = y - x;
			else
				x = x - y;
		}
		return y;
	}

	public static void main(String[] args) {
		System.out.println(gcd(48, 18)); // 6
	}
}

package bai3;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String args[]) {
		System.out.println("nhap gia tri:");
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		fibonacci(n);
	}

	public static void fibonacci(int n) {
		int[] fi = new int[n];
		fi[0] = 1;
		fi[1] = 1;
		for (int i = 2; i < n; i++) {
			fi[i] = fi[i - 1] + fi[i - 2];

		}
		System.out.println(fi[n-1]);
	}
}

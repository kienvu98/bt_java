package homeword4;

import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.print("Nhap n: ");
		n = sc.nextInt();

		int[] x = new int[n];
		tries(0, x);

		
	}

	public static void tries(int i, int[] x) {
		for (int v = 0; v <= 1; v++) {
			x[i] = v;
			if (i == x.length - 1)
				print(x);
			else
				tries(i + 1, x);
		}
	}

	public static void print(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

}

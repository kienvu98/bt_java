package homeword4;

import java.util.Scanner;

public class HoanVi {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập n:");
		int n = sc.nextInt();
		boolean daQua[] = intput(n);
		int kq[] = new int[n];
		Try(0, daQua, kq);

	}

	private static boolean[] intput(int n) {
		// TODO Auto-generated method stub
		boolean a[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			a[i] = false;
		}
		return a;
	}

	public static void Try(int n, boolean daQua[], int ketQua[]) {
		for (int i = 1; i <= ketQua.length; i++) {
			if (daQua[i] == false) {
				ketQua[n] = i;
				daQua[i] = true;
				if (n == ketQua.length - 1) {
					print(ketQua);
				} else {
					Try(n + 1, daQua, ketQua);
				}
				daQua[i] = false;
			}
		}
	}

	private static void print(int[] ketQua) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ketQua.length; i++) {
			System.out.print(ketQua[i] + " ");
		}
		System.out.println();
	}
}
